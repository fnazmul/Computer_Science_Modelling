/*************************************************************
 ** An implementation of generic finite automata.
 ** Please see Hopcroft, Motwani, and Ullman and ../FAsample.java 
 ** for documentation.
 **
 ** 07/02-2006 Dagur Gunnarsson for assignment 1 of 02141
 ** revised 17/02-2010 Henrik Pilegaard for assignment 1 of 02141
 **************************************************************/
package RegLang.FA;

public class Transition extends Object {
	public State from;
	public State to;
	public String symbol;

	public Transition(State s1, String symb, State s2) {
		from = s1;
		to = s2;
		symbol = symb;
	}
}