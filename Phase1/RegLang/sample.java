/******************************************** 
 ** A class containing the regular expression
 **           Exp = 0(0+eps)*2141
 ** which is the course name with at least 1
 ** zero in front. 
 **
 ** 07/02-2006 Henrik Pilegaard.
 ** revised 17/02-2010 Henrik Pilegaard for assignment 1 of 02141
 *
 ** revised 05/03-2010 s094747 for assignment 1 of 02141
 *********************************************/
package RegLang;

import RegLang.FA.Automaton;
import RegLang.RegExp.*;

public class sample {
	public static RegExp Exp = new ConcatExp(new SymbExp("0"), new ConcatExp(
			new StarExp(new ParenExp(new UnionExp(new SymbExp("0"),
					new EpsExp()))), new ConcatExp(new SymbExp("2"),
					new ConcatExp(new SymbExp("1"), new ConcatExp(new SymbExp(
							"4"), new SymbExp("1"))))));

	public static void main(String[] args) {
		System.out.println(Exp.toString());
	}
	
}
