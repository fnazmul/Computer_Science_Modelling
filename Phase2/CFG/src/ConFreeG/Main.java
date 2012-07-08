package ConFreeG;

import org.antlr.runtime.*;

import ConFreeG.IR.*;
import ConFreeG.Functions.*;
import RegLang.Prop;
import RegLang.RegExp.RegExp;

public class Main {
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
            	//System.out.println("\nhello");
            } catch (RecognitionException e)
            {
            	e.printStackTrace();
            }
        } catch (java.io.IOException e) 
        {
            e.printStackTrace();
        }

        // functions to check the functionality of A, B, S, P
        //testFunctionA("(x+(y*(a-3)))");		    
	    //testFunctionB("(!((a<3)&&(b=c)))");
	    //testFunctionS(" (x:= (y+z); if (c>d) then a := b else e :=f fi)");
	    //testFunctionP("input(n); (m:=1; while (n>0) do (m:=(m*n); n:= (n-1)) od); output(m)) ");
        
        // here p contains the representation of the input
        // here you should write some code to invoke the method of
        // question 7 (which in turn should invoke the other 
        // methods)        
	    
        // call to functionP to generate the string / regular expression of the program
		RegExp str = DerivedFunctions.functionP(p);
		System.out.println("The string representation of program P:");
		String changeStr = str.toString().replaceAll("@", "");
		System.out.println(changeStr);
		
		// call to functionVariableList to create the list of variables in the program		
		DerivedFunctions.functionVariableList(str);
		String[] variableList = (String[])DerivedFunctions.varList.toArray(new String[DerivedFunctions.varList.size()]);
		int varNum  = DerivedFunctions.varList.size(); 
		
		// check the property for all v belongs to Var
		for(int i = 0; i < varNum; i++){
			
			// call to functionHomomorphism with a variable as argument to convert it to RegExp or r,w,n
			Var var = new Var(variableList[i]);
			DerivedFunctions.functionHomomorphism(str, var.name);			
			//System.out.println(s.toString());
		
			// call to check the property of the variable
			boolean result = Prop.check(str);
		
			if(result){
				System.out.println("\nIn program P the variable \"" + var.name + "\" does not hold the given property.");
			}
			else{
				System.out.println("\nIn program P the variable \"" + var.name + "\" holds the given property.");
			}
		}
    }
    
    
    
    // a test function to get the string of an arithmetic expression
    public static void testFunctionA(String inp)
    {    	
    	CharStream charStream=new ANTLRStringStream(inp);		
    	whileLexer lexer=new whileLexer(charStream);
		TokenStream tokenStream=new CommonTokenStream(lexer);
		whileParser parser=new whileParser(tokenStream);
		
		try {
			AExpr aExp=parser.arith();
			RegExp s = DerivedFunctions.functionA(aExp);
			System.out.println(s.toString());			
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
    
    //a test function to get the string of an boolean expression
    public static void testFunctionB(String inp)
    {    	
    	CharStream charStream=new ANTLRStringStream(inp);		
    	whileLexer lexer=new whileLexer(charStream);
		TokenStream tokenStream=new CommonTokenStream(lexer);
		whileParser parser=new whileParser(tokenStream);
		
		try {
			BExpr bExp=parser.bool();
			RegExp b = DerivedFunctions.functionB(bExp);
			System.out.println(b.toString());
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    //a test function to get the string of a statement
    public static void testFunctionS(String inp)
    {
    	
    	CharStream charStream=new ANTLRStringStream(inp);		
    	whileLexer lexer=new whileLexer(charStream);
		TokenStream tokenStream=new CommonTokenStream(lexer);
		whileParser parser=new whileParser(tokenStream);
		
		try {
			Statement stmnt = parser.stmt();			
			RegExp s = DerivedFunctions.functionS(stmnt);
			System.out.println(s.toString());
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    //a test function to get the string of a program
    public static void testFunctionP(String inp)
    {
    	
    	CharStream charStream=new ANTLRStringStream(inp);		
    	whileLexer lexer=new whileLexer(charStream);
		TokenStream tokenStream=new CommonTokenStream(lexer);
		whileParser parser=new whileParser(tokenStream);
		
		try {
			Program p = parser.program();			
			RegExp s = DerivedFunctions.functionP(p);
			System.out.println(s.toString());
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
}
