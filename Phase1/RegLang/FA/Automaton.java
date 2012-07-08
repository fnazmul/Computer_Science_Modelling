/*************************************************************
 ** An implementation of generic finite automata.
 ** Please see Hopcroft, Motwani, and Ullman and ../FAsample.java 
 ** for documentation.
 **
 ** 07/02-2006 Dagur Gunnarsson for assignment 1 of 02141
 ** revised 17/02-2010 Henrik Pilegaard for assignment 1 of 02141
 *
 ** revised 05/03-2010 s094747 for assignment 1 of 02141
 **************************************************************/

package RegLang.FA;

import java.util.*;

import RegLang.RegExp.*;

public class Automaton extends Object {

	public State startState;
	public TreeSet<State> finals;
	public HashMap<State, HashMap<String, TreeSet<State>>> transitions;
	public TreeSet<State> states;
	public TreeSet<String> alphabet;
	public HashMap<State, HashMap<State, RegExp>> newTransitions;

	public Automaton() {
		finals = new TreeSet<State>();
		transitions = new HashMap<State, HashMap<String, TreeSet<State>>>();
		states = new TreeSet<State>();
		alphabet = new TreeSet<String>();
		newTransitions = new HashMap<State, HashMap<State, RegExp>>();
	}

	public State addState() {
		State newState = new State();
		states.add(newState);
		return newState;
	}

	public State addState(State state) {
		states.add(state);
		return state;
	}

	public void deleteState(State state) {
		transitions.remove(state);
		states.remove(state);
		if (state == startState)
			startState = null;
	}

	public void setStartState(State state) {
		if (!states.contains(state)) {
			states.add(state);
		}
		startState = state;
	}

	public void setFinalState(State state) {
		if (!states.contains(state)) {
			states.add(state);
		}
		finals.add(state);
	}

	public void addTransition(State from, State to, String token) {
		alphabet.add(token);

		HashMap map = transitions.get(from);
		if (map == null) {
			map = new HashMap<String, TreeSet<State>>();
		}

		TreeSet set = (TreeSet) map.get(token);
		if (set == null) {
			set = new TreeSet<State>();
			map.put(token, set);
		}

		set.add(to);
		transitions.put(from, map);
	}

	public TreeSet<State> delta(State state, String token) {
		TreeSet<State> result = null;
		HashMap<String, TreeSet<State>> map = transitions.get(state);
		try {
			result = (TreeSet<State>) map.get(token);
		} catch (Exception e) {
			return null;
		}
		return result;
	}

	public String toString() {
		String result = "\t\t";

		for (Object token : alphabet) {
			result += token + "\t\t";
		}
		result += "\n";
		for (Object state : states) {
			if (startState == state)
				result += "->";
			if (finals.contains(state))
				result += "*";
			result += state;
			for (Object token : alphabet) {
				TreeSet d = delta((State) state, token.toString());
				result += "\t\t" + (d == null ? "@" : d.toString());
			}
			result += "\n";
		}

		return result;
	}

	public RegExp toRegExp() {

		RegExp result = new EmpExp();
		Automaton temp = this.toDFA();
		Automaton dfa = new Automaton();

		// test if the language of DFA is empty
		if (temp.testEmptiness()) {
			return result;
		}

		// a TreeSet of all states of the dfa except new start and final state
		TreeSet<State> allStates = new TreeSet<State>();

		// adding all states of temp
		for (State s : temp.states) {
			dfa.addState(s);
			allStates.add(s);
		}

		// adding a single start state
		State sState = dfa.addState();
		dfa.setStartState(sState);
		// adding a single final state
		State finalState = dfa.addState();
		dfa.setFinalState(finalState);

		// converting all edge of the temp to RegExp in dfa
		// and keep these in newTransitions

		for (State from : temp.transitions.keySet()) {
			for (String token : temp.alphabet) {
				if (temp.delta(from, token) != null)
					for (State to : temp.delta(from, token)) {
						RegExp alpha = new SymbExp(token);
						// when there are multiple transitions between two
						// states
						RegExp existing = null;
						HashMap Map = dfa.newTransitions.get(from);
						if (Map != null) {
							existing = dfa.newTransitions.get(from).get(
									to);
						}
						if (existing != null) {
							alpha = new UnionExp(alpha, existing);
						}
						dfa.addToRegExpTransition(from, to, alpha);
					}
			}
		}

		// adding the epsilon transitions from new start to prev start
		// and prev finals to new final
		RegExp eps = new EpsExp();
		dfa.addToRegExpTransition(dfa.startState, temp.startState, eps);
		for (State f : temp.finals) {
			dfa.addToRegExpTransition(f, finalState, eps);
		}

		// loops through until all states except start and final is removed
		while (!allStates.isEmpty()) {

			// select a state to remove
			State s = allStates.first();

			HashMap<State, RegExp> Outgoing = new HashMap<State, RegExp>();
			HashMap<State, RegExp> Temp = new HashMap<State, RegExp>();
			RegExp self = null;

			// search for all outgoing edges from s
			// and search for self loop
			Temp = dfa.newTransitions.get(s);
			for (State to : Temp.keySet()) {
				if (!to.equals(s)) {
					Outgoing.put(to, Temp.get(to));
				} else {
					if (self != null) {
						self = new UnionExp(self, Temp.get(to));
					} else {
						self = Temp.get(to);
					}
				}
			}

			// search for all incoming edges to s
			// and add direct transitions from each incoming state of s
			// to outgoing state of s
			for (State from : dfa.states) {
				// except the state itself and the final state
				if (!from.equals(s) & !from.equals(finalState)) {
					// if there is an incoming edge
					if (dfa.newTransitions.get(from).containsKey(s)) {
						// the RegExp of the incoming edge
						RegExp inEdge = dfa.newTransitions.get(from).get(s);
						// remove the existing transition from newTransitions
						dfa.newTransitions.get(from).remove(s);

						// concat the incoming edge to each of the outgoing edge
						for (State to : Outgoing.keySet()) {
							RegExp edge = null;
							RegExp outEdge = null;
							// if there is no self loop
							if (self == null) {
								outEdge = new ConcatExp(inEdge, Outgoing
										.get(to));
							}
							// when there is a self loop
							else {
								outEdge = new ConcatExp(inEdge, new ConcatExp(
										new StarExp(self), Outgoing.get(to)));
							}
							// check if a transition from incoming to outgoing
							// already exists
							if (dfa.newTransitions.get(from).containsKey(to)) {
								// then union it with the new RegExp
								edge = new UnionExp(dfa.newTransitions
										.get(from).get(to), outEdge);
								dfa.newTransitions.get(from).remove(to);
							} else {
								edge = outEdge;
							}
							// add the new transition to newTransitions
							dfa.addToRegExpTransition(from, to, edge);
						}
					}
				}
			}

			// remove the state from dfa, allStates and newTransitions
			dfa.newTransitions.remove(s);
			allStates.remove(s);
			dfa.states.remove(s);
		}

		result = dfa.newTransitions.get(dfa.startState).get(finalState);
		if(result == null){
			result = new EmpExp();
		}
		return result;
	}

	// a function to add transition to newTransitions with RegExp
	public void addToRegExpTransition(State from, State to, RegExp token) {
		HashMap map = newTransitions.get(from);
		if (map == null) {
			map = new HashMap<State, RegExp>();
		}
		map.put(to, token);
		newTransitions.put(from, map);
	}

	public Automaton cmplDFA() {

		Automaton result = new Automaton();
		Automaton dfa = this.toDFA();

		// adding all states of the current automaton
		for (State state : dfa.states) {
			result.addState(state);
		}

		// adding all transitions of this automaton
		for (State key : dfa.transitions.keySet()) {
			for (String alpha : dfa.alphabet) {
				if (dfa.delta(key, alpha) != null)
					for (State value : dfa.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		// setting the start state
		result.setStartState(dfa.startState);

		// creating the final states
		for (State state : dfa.states) {
			if (!dfa.finals.contains(state))
				result.setFinalState(state);
		}
		return result;
	}

	public Automaton toDFA() {

		Automaton result = new Automaton();
		State emptyState = new State("#");

		// HashMap between the new states and the set of old states
		HashMap<TreeSet<State>, State> newStates = new HashMap<TreeSet<State>, State>();
		// HashMap of the set of old states with a counter
		TreeMap<String, TreeSet<State>> enumStates = new TreeMap<String, TreeSet<State>>();

		// getting the e-close of start state
		TreeSet<State> startEclose = getEClose(this, this.startState);

		// adding a starting state to the DFA
		State newStart = result.addState();
		result.setStartState(newStart);

		// a counter of the new states that has been processed
		int taken = 1;

		// putting the start state in the HashMap
		newStates.put(startEclose, newStart);
		enumStates.put(Integer.toString(taken), startEclose);

		// taking each state in the startEclose and find the transitions
		int size = 1; // a counter of the new states
		TreeSet<State> eclose = new TreeSet<State>();
		TreeSet<State> tempEclose = new TreeSet<State>();

		// finding transition for each new state
		while (enumStates.containsKey(Integer.toString(taken))) {
			// this loop works until all the new states have been processed

			// taking the set of states to be processed
			eclose = enumStates.get(Integer.toString(taken));

			// for each alphabet
			for (String token : this.alphabet) {
				if (token != "eps") {
					tempEclose = new TreeSet<State>();

					// for each state in eclose
					for (Iterator i = eclose.iterator(); i.hasNext();) {
						State from = (State) i.next();

						// setting the final state
						if (this.finals.contains(from))
							result.setFinalState(newStates.get(eclose));

						// checking the transitions
						if (this.delta(from, token) != null) {
							for (State to : this.delta(from, token)) {
								// if a transition exists, then adding the
								// e-close of that sate
								tempEclose.addAll(this.getEClose(this, to));
							}
						}
					}

					// if there is no transition, then it leads to an empty set
					if (tempEclose.isEmpty()) {
						tempEclose.add(emptyState);
					}

					// if the found state is an existing one
					if (newStates.containsKey(tempEclose)) {
						// just adding transition
						result.addTransition(newStates.get(eclose), newStates
								.get(tempEclose), token);
					} else {
						size += 1;
						// adding a new state in the DFA
						State newState = result.addState();
						newStates.put(tempEclose, newState);
						enumStates.put(Integer.toString(size), tempEclose);
						// adding transition
						result.addTransition(newStates.get(eclose), newState,
								token);
					}
				}
			}
			taken++;
			eclose = new TreeSet<State>();
		}
		return result;
	}

	// given an automaton and a state, this function returns the e-closure of
	// the given state
	public TreeSet<State> getEClose(Automaton a, State s) {

		TreeSet<State> temp = new TreeSet<State>();
		TreeSet<State> eclose = new TreeSet<State>();

		eclose.add(s);
		temp.add(s);
		
		while (!temp.isEmpty()){
			State from = temp.first();
			for (String token : a.alphabet) {
				if (token == "eps") {
					if (a.delta(from, token) != null) {
						for (State to : a.delta(from, token)) {
							eclose.add(to);
							temp.add(to);
						}
					}
				}
			}
			temp.remove(from);
		}
		return eclose;
	}

	// this function checks if the language recognized by an DFA is empty or not
	public boolean testEmptiness() {

		boolean result = false;

		Automaton a = this.toDFA();
		TreeSet<State> reachable = new TreeSet<State>();

		// adding the first state to the reachable
		reachable.add(this.startState);
		// if this is a final state, then return false
		if (this.finals.contains(this.startState)) {
			return result;
		}
		// if the set of final states is empty, then return true
		else if (this.finals.isEmpty()) {
			result = true;
			return true;
		}

		TreeSet<State> tempStates = new TreeSet<State>();

		// a TreeSet of all states of the automaton
		TreeSet<State> allStates = new TreeSet<State>();
		for (State s : this.states) {
			allStates.add(s);
		}

		// loops until all the states have been checked
		while (!allStates.isEmpty()) {
			// for each state in reachable
			for (Iterator i = reachable.iterator(); i.hasNext();) {
				State from = (State) i.next();
				// for each token
				for (String token : this.alphabet) {
					// checking the transitions
					if (this.delta(from, token) != null) {
						for (State to : this.delta(from, token)) {
							// adding the state to temp
							tempStates.add(to);

							// if reached a final state, return false
							if (this.finals.contains(to)) {
								return result;
							}
						}
					}
				}
				// removing the processed state from the set
				tempStates.remove(from);
				allStates.remove(from);
			}
			// taking the new reached states to check
			reachable = new TreeSet<State>();
			reachable.addAll(tempStates);
		}
		result = true;
		return result;
	}

	// this function creates the union DFA of two DFAs
	public Automaton createUnionDFA(Automaton b) {

		Automaton result = new Automaton();

		Automaton a = this;

		// creating a start state
		State startState = result.addState();
		result.setStartState(startState);

		// adding all a.states
		for (State state : a.states) {
			result.addState(state);
		}

		// adding all b.states
		for (State state : b.states) {
			result.addState(state);
		}

		// adding all transitions of a
		for (State key : a.transitions.keySet()) {
			for (String alpha : a.alphabet) {
				if (a.delta(key, alpha) != null)
					for (State value : a.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		// adding all transitions of b
		for (State key : b.transitions.keySet()) {
			for (String alpha : b.alphabet) {
				if (b.delta(key, alpha) != null)
					for (State value : b.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		// transition from start to a.start
		result.addTransition(result.startState, a.startState, "eps");
		// transition from start to b.start
		result.addTransition(result.startState, b.startState, "eps");

		// creating a final state
		State finalState = result.addState();
		result.setFinalState(finalState);

		// make the epsilon transition from each final state of a to the
		// final-state of result
		for (State state : a.finals) {
			result.addTransition(state, finalState, "eps");
		}

		// make the epsilon transition from each final state of b to the
		// final-state of result
		for (State state : b.finals) {
			result.addTransition(state, finalState, "eps");
		}
		return result.toDFA();
	}

}
