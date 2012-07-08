package Interpreter;

import ConFreeG.IR.*;
import java.util.*;

public class Test {

    // A sequence of function declarations
    private static MDec[] mdecs = 
    { //First function -- mutually recursive implementation of factorial function
	new MDec("factorial", 
		 new Input(new Var("n")), 
		 new If(new Equals(new Var("n"), new Num(1)), 
			new Assign(new Var("result"), new Var("n")),
			new Assign(new Var("result"), new Times(new Var("n"), 
								new Call("factorial2", new Minus(new Var("n"), new Num(1)))
								)
				   )
			),
		 new Output(new Var ("result"))),
	// Second function -- factorial again (other half)
	new MDec("factorial2", 
		 new Input(new Var("n")), 
		 new If(new Equals(new Var("n"), new Num(1)), 
			new Assign(new Var("result"), new Var("n")),
			new Assign(new Var("result"), new Times(new Var("n"), 
								new Call("factorial", new Minus(new Var("n"), new Num(1)))
								)
				   )
			),
		 new Output(new Var ("result"))),
	// Third function -- dummy
	new MDec("M2", new Input(new Var("i")), new Skip(), new Output(new Var ("o")))
    };
    
    // A program
    public static Program p = 
	new Program(
		    // The functions declarations from above
		    new Vector( Arrays.asList(mdecs)),
		    // Assignment -- x := factorial(5)
		    
		    new Sequence(
		    new Assign(
			       new Var("x"),
			       new Call("factorial", new Num(5))
			       ),
		    
			new Assign(
		       new Var("x2"),
		       new Call("factorial2", new Num(8))
		       )
		    )
	    );
}
