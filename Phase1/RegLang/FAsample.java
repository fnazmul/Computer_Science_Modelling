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
package RegLang;

import java.util.*;//TreeSet;

//import java.util.Iterator;

import RegLang.FA.*;
import RegLang.RegExp.*;

public class FAsample {

	public static void main(String[] arg) {
		Automaton auto1 = new Automaton();
		State p1 = auto1.addState();
		State p2 = auto1.addState();
		auto1.setStartState(p1);
		auto1.setFinalState(p1);
		auto1.addTransition(p1, p1, "0");

		auto1.addTransition(p2, p2, "1");
		auto1.addTransition(p2, p1, "0");
		System.out.println(auto1.toString());

		UnionExp union = new UnionExp(new SymbExp("0"), new SymbExp("1"));
		StarExp exp = new StarExp(union);

		// ConcatExp c = new ConcatExp(new SymbExp("0"), new SymbExp("1"));
		// StarExp exp = new StarExp(c);
		/*
		 * RegExp exp = new UnionExp(new StarExp(new UnionExp( new SymbExp("n"),
		 * new SymbExp("w"))), new ConcatExp(new StarExp( new SymbExp("n")), new
		 * ConcatExp(new SymbExp("w"), new ConcatExp( new StarExp(new
		 * UnionExp(new SymbExp("n"), new SymbExp("w"))), new ConcatExp(new
		 * SymbExp("r"), new StarExp(new UnionExp( new SymbExp("w"), new
		 * UnionExp(new SymbExp("r"), new SymbExp("n")))))))));
		 */
		Automaton auto = exp.createNFA();
		Automaton res = auto.toDFA().cmplDFA();
		System.out.println(res.toRegExp());

	}

}
