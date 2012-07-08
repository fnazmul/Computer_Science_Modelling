/*************************************************************
 ** A placeholder to encapsulate and check a property of interest.
 **
 ** 07/02-2006 Henrik Pilegaard for assignment 1 of 02141
 ** revised 17/02-2010 Henrik Pilegaard for assignment 1 of 02141
 *
 ** revised 05/03-2010 s094747 for assignment 1 of 02141
 **************************************************************/
package RegLang;

import RegLang.RegExp.*;
import RegLang.FA.*;

public class Prop {

	// RegExp which ensures the PROP property
	public static RegExp exp = new UnionExp(new StarExp(new UnionExp(
			new SymbExp("n"), new SymbExp("w"))), new ConcatExp(new StarExp(
			new SymbExp("n")), new ConcatExp(new SymbExp("w"), new ConcatExp(
			new StarExp(new UnionExp(new SymbExp("n"), new SymbExp("w"))),
			new ConcatExp(new SymbExp("r"), new StarExp(new UnionExp(
					new SymbExp("w"), new UnionExp(new SymbExp("r"),
							new SymbExp("n")))))))));

	public static boolean check(RegExp re) {

		// code to check argument re for property of interest
		// creating the DFA of re
		Automaton re_DFA = re.createDFA();
		// adding r,w,n to the alphabet set of the DFA
		// to avoid the case if any one is missing in e
		re_DFA.alphabet.add("r");
		re_DFA.alphabet.add("w");
		re_DFA.alphabet.add("n");
		// recreating the dfa with proper alphabet
		re_DFA = re_DFA.toDFA();
		// complementing
		Automaton re_complDFA = re_DFA.cmplDFA();
		// creating the DFA for exp
		Automaton exp_DFA = exp.createDFA();

		// creating the DFA of (exp U re')
		Automaton union = re_complDFA.createUnionDFA(exp_DFA);
		// RegExp uni = new UnionExp(re_complDFA.toRegExp(),
		// exp_DFA.toRegExp());
		// Automaton union = uni.createDFA();

		// complementing it
		Automaton compl = union.cmplDFA();
		// testing for emptiness
		boolean result = compl.testEmptiness();

		return result;
	}

	public static void main(String[] arg) {

		// given re to test
		RegExp L_e = new ConcatExp(new StarExp(new SymbExp("n")),
				new ConcatExp(new SymbExp("w"), new ConcatExp(new SymbExp("r"),
						new ConcatExp(new SymbExp("n"), new SymbExp("w")))));

		if (check(L_e))
			System.out.println("The given expression " + L_e.toString()
					+ " satisfies the PROP property.");
		else
			System.out.println("The given expression " + L_e.toString()
					+ " does not satisfy the PROP property.");

		// another re to test
		RegExp L_e2 = new ConcatExp(new SymbExp("r"), new ConcatExp(
				new SymbExp("w"), new ConcatExp(new SymbExp("r"),
						new ConcatExp(new SymbExp("n"), new SymbExp("w")))));

		if (check(L_e2))
			System.out.println("The given expression " + L_e2.toString()
					+ " satisfies the PROP property.");
		else
			System.out.println("The given expression " + L_e2.toString()
					+ " does not satisfy the PROP property.");

	}
}
