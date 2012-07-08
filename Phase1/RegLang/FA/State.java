/*************************************************************
 ** An implementation of generic finite automata.
 ** Please see Hopcroft, Motwani, and Ullman and ../FAsample.java 
 ** for documentation.
 **
 ** 07/02-2006 Dagur Gunnarsson for assignment 1 of 02141
 ** revised 17/02-2010 Henrik Pilegaard for assignment 1 of 02141
 **
 ** revised 05/03-2010 s094747 for assignment 1 of 02141
 **************************************************************/
package RegLang.FA;

public class State extends Object implements Comparable<State> {

	public String label;
	private static int next = 0;

	public State() {
		this.label = "q" + next++;
	}

	public State(String s) {
		this.label = s;
	};

	public int compareTo(State state) {
		return label.compareTo(state.label);
	}

	public String toString() {
		return label;
	}

}
