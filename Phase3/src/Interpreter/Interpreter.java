package Interpreter;

import java.util.HashMap;
import java.util.Enumeration;

import org.antlr.runtime.*;

import ConFreeG.whileLexer;
import ConFreeG.whileParser;
import ConFreeG.IR.*;

public class Interpreter {
	
	//the table that stores the variable with its associated value
	public static Table stoOenv = new Table();
	//method environment
	public static HashMap<String, MDec> envM = new HashMap<String, MDec>();
	
    public static void main(String args[]) {

        Program p = null;

        try {
            String filename = args[0];
            whileLexer lex =
            	new whileLexer(new ANTLRFileStream (filename));
            CommonTokenStream tokens = new CommonTokenStream(lex);
            whileParser parser = new whileParser(tokens);    
	    
            try {
            	p = parser.program();		           	
            	//p = Test.p;
            	Interpreter.functionP(p);
            	
            	//print all the elements of the program environment
        		for(Enumeration allKeys = stoOenv.keys(); allKeys.hasMoreElements();){
        			Symbol next = (Symbol)(allKeys.nextElement());
        			System.out.print(next + " -> ");
        			System.out.println(stoOenv.get(next));
        		}
            	
            } catch (RecognitionException e)
            {
            	e.printStackTrace();
            }
        } catch (java.io.IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    
public static int functionA(AExpr a){
		
		int value = 0;
		
		if( a instanceof Var){
			//get the value of the variable from the environment
			Symbol s = Symbol.symbol(((Var)a).name);
			if(stoOenv.get(s)!=null)
				value = ((Integer)(stoOenv.get(s))).intValue();
			else{	//if it is not available in the table
				System.out.println("The variable " + s.toString() + " is not initialized.");
				value = 0;
			}
		}
		else if ( a instanceof Num){			
			value = ((Num)a).num;			
		}
		
		else if  ( a instanceof Plus){			
			value = functionA(((Plus)a).left) + functionA(((Plus)a).right) ;
		}
		else if  ( a instanceof Minus){
			value = functionA(((Minus)a).left) - functionA(((Minus)a).right) ;
		}
		else if  ( a instanceof Times){
			value = functionA(((Times)a).left) * functionA(((Times)a).right) ;
		}
		else if  ( a instanceof Call){
			//check if the method is already declared
			String methodName = ((Call)(a)).mid;
			if(envM.containsKey(methodName)){
				// evaluate the value of the input parameter
				int inputVal = functionA(((Call)(a)).param);
				// create a new scope for the callee
				stoOenv.beginScope();
				//create the input variable
				Symbol inputVar = Symbol.symbol(envM.get(methodName).input.arg.name);
				//store it in the environment
				stoOenv.put(inputVar, inputVal);
				//process the statements
				functionS(envM.get(methodName).stmt);
				//get the output variable from the environment
				Symbol outputVar = Symbol.symbol(envM.get(methodName).output.arg.name);
				if(stoOenv.get(outputVar) != null){
					//get the output value from the current environment
					int outputVal = ((Integer)(stoOenv.get(outputVar))).intValue();
					//return the output value
					value = outputVal;
				}else{
					System.out.println("The ouput variable " + outputVar.toString() + " is not defined.");
					value = 0;
				}
				//end the scope for the callee and return to the previous environment
				stoOenv.endScope();				
			}
			else	//if it is not available in the envM
				System.out.println("The method " + methodName + " is not declared.");
		}
		
		return value;
	}
	
	
	public static boolean functionB(BExpr b){
		
		boolean value = true;
		
		if ( b instanceof True){
			value = true;
		}
		else if ( b instanceof False){
			value = false;
		}		
		else if  ( b instanceof Equals){			
			if( functionA(((Equals)b).left) == functionA(((Equals)b).right))
				value = true;
			else
				value = false;
		}
		else if  ( b instanceof Larger){
			if( functionA(((Larger)b).left) > functionA(((Larger)b).right) )
				value = true;
			else
				value = false;
		}
		else if  ( b instanceof Smaller){
			if ( functionA(((Smaller)b).left) < functionA(((Smaller)b).right) )
				value = true;
			else
				value = false;				
		}
		else if  ( b instanceof And){
			value = functionB(((And)b).left) && functionB(((And)b).right);
								
		}
		else if  ( b instanceof Or){
			value = functionB(((Or)b).left) || functionB(((Or)b).right);
		}
		else if  ( b instanceof Neg){
			value = !(functionB(((Neg)b).arg));
		}
		return value;
	}
	
	
	public static void functionS(Statement s){
				
		if ( s instanceof Skip){
			//do nothing
		}
		else if  ( s instanceof Assign){
			//get the unique symbol associated with the lhs
			Symbol  x = Symbol.symbol(((Assign)s).lhs.name);
			//evaluate the expression on the right hand side
			int value = functionA(((Assign)s).e);
			//store it in the environment
			stoOenv.put(x, value);
		}
		else if  ( s instanceof Sequence){
			functionS(((Sequence)s).s1);
			functionS(((Sequence)s).s2);
		}
		else if  ( s instanceof If){
			boolean value = functionB(((If)s).condition);
			if (value)
				functionS(((If)s).s1);
			else
				functionS(((If)s).s2);
		}
		else if  ( s instanceof While){
			boolean value = functionB(((While)s).condition);
			while (value) {
				functionS(((While)s).s);
				value = functionB(((While)s).condition);
			}
		}
	}
	
	
	public static void functionP(Program p){
		
		// process the method declarations 
		if (p.mdecs != null) {
			for (int i = 0; i < p.mdecs.size(); i++) {
				envM.put(p.mdecs.get(i).mid, p.mdecs.get(i));
			}
		}
		// process the statements
		if (p.stmt != null) {
			//start with a new environment for the program
			stoOenv.beginScope();
			//process all the statements
			functionS(p.stmt);
		}		
	}	
	    
}
