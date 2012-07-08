package ConFreeG.IR;

public class Program 
{
   public Input input;
   public Statement stmt;
   public Output output;

   public Program(Input i, Statement s, Output o) {
    
       this.input  = i;
       this.stmt   = s;
       this.output = o;
   }

}
