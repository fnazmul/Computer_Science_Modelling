/*
 * This class contains the user defined functions.
 * This class contains the implementation of the functions A, B, S, P and Homomorphism 
 * This class also contains a function to create the variable list of the program P
 */

package ConFreeG.Functions;

import ConFreeG.IR.*;
import RegLang.RegExp.*;
import java.util.ArrayList;

public class DerivedFunctions {
	
	public static ArrayList<String> varList = new ArrayList<String>();
	
	public static RegExp functionA(AExpr a){
		
		RegExp regExpr = null;
		//String toString = "";
		
		if( a instanceof Var){
			String toString =  '?' + ((Var)a).name;
			regExpr = new SymbExp(toString);
		}
		if ( a instanceof Num){
			//toString = "";
			regExpr = new EpsExp();
		}
		
		if  ( a instanceof Plus){
			//toString = (functionA(((Plus)a).left)).toString() + (functionA(((Plus)a).right)).toString();
			regExpr = new ConcatExp(functionA(((Plus)a).left) , functionA(((Plus)a).right) );
		}
		if  ( a instanceof Minus){
			//toString = (functionA(((Minus)a).left)).toString() + (functionA(((Minus)a).right)).toString();
			regExpr = new ConcatExp(functionA(((Minus)a).left) , functionA(((Minus)a).right) );
		}
		if  ( a instanceof Times){
			//toString = (functionA(((Times)a).left)).toString() + (functionA(((Times)a).right)).toString();
			regExpr = new ConcatExp(functionA(((Times)a).left) , functionA(((Times)a).right) );
		}
		
		return regExpr;
	}
	
	
	public static RegExp functionB(BExpr b){
		
		RegExp regExpr = null;
		//String toString = "";
		
		if (( b instanceof True) || ( b instanceof False)){
			//toString = "";
			regExpr = new EpsExp();
		}
		if  ( b instanceof Equals){
			//toString = (functionA(((Equals)b).left)).toString() + (functionA(((Equals)b).right)).toString();
			regExpr = new ConcatExp(functionA(((Equals)b).left) , functionA(((Equals)b).right) );
		}
		if  ( b instanceof Larger){
			//toString = (functionA(((Larger)b).left)).toString() + (functionA(((Larger)b).right)).toString();
			regExpr = new ConcatExp(functionA(((Larger)b).left) , functionA(((Larger)b).right) );
		}
		if  ( b instanceof Smaller){
			//toString = (functionA(((Smaller)b).left)).toString() + (functionA(((Smaller)b).right)).toString();
			regExpr = new ConcatExp(functionA(((Smaller)b).left) , functionA(((Smaller)b).right) );
		}
		if  ( b instanceof And){
			//toString = (functionB(((And)b).left)).toString() + (functionB(((And)b).right)).toString();
			regExpr = new ConcatExp(functionB(((And)b).left) , functionB(((And)b).right) );
		}
		if  ( b instanceof Or){
			//toString = (functionB(((Or)b).left)).toString() + (functionB(((Or)b).right)).toString();
			regExpr = new ConcatExp(functionB(((Or)b).left) , functionB(((Or)b).right) );
		}
		if  ( b instanceof Neg){
			//toString = (functionB((Neg)b)).toString();
			regExpr = functionB(((Neg)b).arg);
		}
		return regExpr;
	}
	
	
	public static RegExp functionS(Statement s){
		
		RegExp regExpr = null;
		//String toString = "";
		
		if ( s instanceof Skip){
			//toString = "";
			regExpr = new EpsExp();
		}
		if  ( s instanceof Assign){
			String toString =   "!" + ((Assign)s).lhs.name ;
			regExpr = new ConcatExp(functionA(((Assign)s).e), new SymbExp(toString));
			//toString = regExpr.toString();
			
		}
		if  ( s instanceof Sequence){
			//toString = (functionS(((Sequence)s).s1)).toString() + (functionS(((Sequence)s).s2)).toString();
			regExpr = new ConcatExp(functionS(((Sequence)s).s1) , functionS(((Sequence)s).s2));
		}
		if  ( s instanceof If){
			//toString = (functionB(((If)s).condition)).toString() + 
				//"(" + (functionS(((If)s).s1)).toString() + "+" + (functionS(((If)s).s2)).toString() + ")";
			regExpr = new ConcatExp( functionB(((If)s).condition),  
						new UnionExp( functionS(((If)s).s1), functionS(((If)s).s2)));
		}
		if  ( s instanceof While){
			//toString = (functionB(((While)s).condition)).toString() + 
				//"(" + (functionS(((While)s).s)).toString() + (functionB(((While)s).condition)).toString() + ")" + "*";
			regExpr = new ConcatExp( functionB(((While)s).condition), 
					new StarExp( new ConcatExp(functionS(((While)s).s),functionB(((While)s).condition))));
		}
		return regExpr;
	}
	
	
	public static RegExp functionP(Program p){
		
		//String toString = "";
		
		String input  =  '!' + ((Var)(p.input.arg)).name;	
		RegExp inp  =  new SymbExp(input);	
		
		//String stmnt = (functionS((Statement)(p.stmt))).toString();
		RegExp stm = functionS((Statement)(p.stmt));
		
		String output  =  '?' + ((Var)(p.output.arg)).name;
		RegExp outp  =  new SymbExp(output);
		
		//toString = input + stmnt + output;
		
		RegExp regExpr = new ConcatExp(inp, new ConcatExp(stm, outp));
		return regExpr;
	}

	
	public static void functionHomomorphism(RegExp exp, String var){			
		if(exp instanceof UnionExp){
			functionHomomorphism(((UnionExp) exp).exp1 , var);
			functionHomomorphism(((UnionExp) exp).exp2 , var);
		}
		if(exp instanceof ConcatExp){
			functionHomomorphism(((ConcatExp) exp).exp1 , var);
			functionHomomorphism(((ConcatExp) exp).exp2 , var);
		}
		if(exp instanceof StarExp){
			functionHomomorphism(((StarExp) exp).exp , var);			
		}
		if(exp instanceof EpsExp){
			return;		
		}
		if(exp instanceof SymbExp){
			
			String s = ((SymbExp) exp).symb.substring(1);
			
			if (s.equals(var)){
				if(((SymbExp) exp).symb.startsWith("?"))
					((SymbExp) exp).symb = "r";
				else if(((SymbExp) exp).symb.startsWith("!"))
					((SymbExp) exp).symb = "w";
			}
			else
				((SymbExp) exp).symb = "n";				
		}
	}
	
	
	public static void functionVariableList(RegExp exp){			
		if(exp instanceof UnionExp){
			functionVariableList(((UnionExp) exp).exp1 );
			functionVariableList(((UnionExp) exp).exp2 );
		}
		if(exp instanceof ConcatExp){
			functionVariableList(((ConcatExp) exp).exp1 );
			functionVariableList(((ConcatExp) exp).exp2 );
		}
		if(exp instanceof StarExp){
			functionVariableList(((StarExp) exp).exp );			
		}
		if(exp instanceof SymbExp){			
			String s = ((SymbExp) exp).symb.substring(1);
			if(!(varList.contains(s)))
				varList.add(s);						
		}
	}


}
