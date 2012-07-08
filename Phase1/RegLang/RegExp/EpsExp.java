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

public class EpsExp extends RegExp {
	public EpsExp() {
	}

	public String toString() {
		return "@";
	}

	public Automaton createNFA() {
		Automaton result = new Automaton();

		// creating a start state
		State startState = result.addState();
		result.setStartState(startState);

		// creating a final state
		State finalState = result.addState();
		result.setFinalState(finalState);

		// adding the epsilon transition from start to final
		result.addTransition(result.startState, finalState, "eps");

		return result;
	}

	public Automaton createDFA() {
		Automaton result = new Automaton();

		result = this.createNFA().toDFA();

		return result;
	}

}
