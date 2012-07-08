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

/* An abstract superclass */
public abstract class RegExp {
	public abstract Automaton createNFA();

	public abstract String toString();

	public abstract Automaton createDFA();
}

/**
 * public class EpsExp extends RegExp { EpsExp() {} }
 * 
 * class EmpExp extends RegExp { EmpExp() {} }
 * 
 * class SymbExp extends RegExp { String symb; SymbExp(String s) {symb=s;} }
 * 
 ** Unary and binary instances for the inductive step class UnionExp extends
 * RegExp { RegExp exp1; RegExp exp2; UnionExp(RegExp e1, RegExp
 * e2){exp1=e1;exp2=e2;} }
 * 
 * class ConcatExp extends RegExp { RegExp exp1; RegExp exp2; ConcatExp(RegExp
 * e1, RegExp e2){exp1=e1;exp2=e2;} }
 * 
 * class StarExp extends RegExp { RegExp exp; StarExp(RegExp e){exp=e;} }
 * 
 * class ParenExp extends RegExp { RegExp exp; ParenExp(RegExp e){exp=e;} }
 **/
