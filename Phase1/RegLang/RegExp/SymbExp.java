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

public class SymbExp extends RegExp {
	public String symb;

	public SymbExp(String s) {
		symb = s;
	}

	public String toString() {
		return symb;
	}

	public Automaton createNFA() {
		Automaton auto = new Automaton();
		State p1 = auto.addState();
		State p2 = auto.addState();
		auto.setStartState(p1);
		auto.setFinalState(p2);
		auto.addTransition(p1, p2, symb);
		return auto;
	}

	public Automaton createDFA() {
		Automaton result = new Automaton();

		result = this.createNFA().toDFA();

		return result;
	}
}
