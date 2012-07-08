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

public class ParenExp extends RegExp {
	public RegExp exp;

	public ParenExp(RegExp e) {
		exp = e;
	}

	public String toString() {
		return exp.toString();
	}

	public Automaton createNFA() {
		Automaton result = new Automaton();

		result = exp.createNFA();

		return result;
	}

	public Automaton createDFA() {
		Automaton result = new Automaton();

		result = this.createNFA().toDFA();

		return result;
	}
}
