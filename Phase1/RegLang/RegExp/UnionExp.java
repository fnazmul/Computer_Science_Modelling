/*************************************************************
 ** An abstract syntax specification for regular expressions.
 ** Please see Hopcroft, Motwani, and Ullman and ../sample.java 
 ** for documentation.
 **
 ** 07/02-2006 Henrik Pilegaard for assignment 1 of 02141
 ** revised 17/02-2010 Henrik Pilegaard for assignment 1 of 02141
 *
 ** revised 05/03-2010 s094747 for assignment 1 of 02141
 **************************************************************/
package RegLang.RegExp;

import RegLang.FA.*;

public class UnionExp extends RegExp {
	public RegExp exp1;
	public RegExp exp2;

	public UnionExp(RegExp e1, RegExp e2) {
		exp1 = e1;
		exp2 = e2;
	}

	public String toString() {
		return ("(" + exp1.toString() + " + " + exp2.toString() + ")");
	}

	public Automaton createNFA() {

		Automaton result = new Automaton();

		// creating a start state
		State startState = result.addState();
		result.setStartState(startState);

		// creating NFAs of the given parameters
		Automaton R = exp1.createNFA();
		Automaton S = exp2.createNFA();

		// adding all R.states
		for (State state : R.states) {
			result.addState(state);
		}

		// adding all S.states
		for (State state : S.states) {
			result.addState(state);
		}

		// adding all transitions of R
		for (State key : R.transitions.keySet()) {
			for (String alpha : R.alphabet) {
				if (R.delta(key, alpha) != null)
					for (State value : R.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		// adding all transitions of S
		for (State key : S.transitions.keySet()) {
			for (String alpha : S.alphabet) {
				if (S.delta(key, alpha) != null)
					for (State value : S.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		// transition from start to R.start
		result.addTransition(result.startState, R.startState, "eps");
		// transition from start to S.start
		result.addTransition(result.startState, S.startState, "eps");

		// creating a final state
		State finalState = result.addState();
		result.setFinalState(finalState);

		// make the epsilon transition from each final state of R to the
		// final-state of result
		for (State state : R.finals) {
			result.addTransition(state, finalState, "eps");
		}

		// make the epsilon transition from each final state of S to the
		// final-state of result
		for (State state : S.finals) {
			result.addTransition(state, finalState, "eps");
		}

		return result;
	}

	public Automaton createDFA() {
		Automaton result = new Automaton();

		result = this.createNFA().toDFA();

		return result;
	}
}
