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

public class StarExp extends RegExp {
	public RegExp exp;

	public StarExp(RegExp e) {
		exp = e;
	}

	public String toString() {
		return ("(" + exp.toString() + ")*");
	}

	public Automaton createNFA() {

		Automaton result = new Automaton();

		// creating a start state
		State startState = result.addState();
		result.setStartState(startState);

		// creating the NFA for the given exp
		Automaton R = exp.createNFA();

		// adding all states of R to result
		for (State state : R.states) {
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

		// adding the epsilon transition from start to R.start
		result.addTransition(result.startState, R.startState, "eps");

		// creating a final state
		State finalState = result.addState();
		result.setFinalState(finalState);

		// make the epsilon transition from each final state of R to the
		// final-state of result
		for (State state : R.finals) {
			result.addTransition(state, finalState, "eps");
		}

		// adding the epsilon transition from start to final
		result.addTransition(result.startState, finalState, "eps");

		// adding the epsilon transition from R.final to R.start
		for (State state : R.finals) {
			result.addTransition(state, R.startState, "eps");
		}

		return result;
	}

	public Automaton createDFA() {
		Automaton result = new Automaton();

		result = this.createNFA().toDFA();

		return result;
	}
}
