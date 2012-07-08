/*************************************************************
 ** An abstract syntax specification for regular expressions.
 ** Please see Hopcroft, Motwani, and Ullman and ../sample.java 
 ** for documentation.
 **
 ** 07/02-2006 Henrik Pilegaard for assignment 1 of 02141
 **
 ** revised 05/03-2010 s094747 for assignment 1 of 02141
 **************************************************************/
package RegLang.RegExp;

import RegLang.FA.*;

public class ConcatExp extends RegExp {
	public RegExp exp1;
	public RegExp exp2;

	public ConcatExp(RegExp e1, RegExp e2) {
		exp1 = e1;
		exp2 = e2;
	}

	public String toString() {
		return (exp1.toString() + " " + exp2.toString());
	}

	public Automaton createNFA() {
		Automaton result = new Automaton();
		Automaton R = exp1.createNFA();
		Automaton S = exp2.createNFA();

		for (State state : R.states) {
			result.addState(state);
		}
		for (State state : S.states) {
			result.addState(state);
		}

		for (State key : R.transitions.keySet()) {
			for (String alpha : R.alphabet) {
				if (R.delta(key, alpha) != null)
					for (State value : R.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		for (State key : S.transitions.keySet()) {
			for (String alpha : S.alphabet) {
				if (S.delta(key, alpha) != null)
					for (State value : S.delta(key, alpha)) {
						result.addTransition(key, value, alpha);
					}
			}
		}

		// set the start state of the resulting NFA
		result.setStartState(R.startState);
		// make the epsilon transition from each final state of R to the
		// start-state of S
		for (State state : R.finals) {
			result.addTransition(state, S.startState, "eps");
		}
		// set the final states of the resulting NFA
		for (State state : S.finals) {
			result.setFinalState(state);
		}

		return result;
	}

	public Automaton createDFA() {
		Automaton result = new Automaton();

		result = this.createNFA().toDFA();

		return result;
	}
}
