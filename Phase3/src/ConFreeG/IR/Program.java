package ConFreeG.IR;
import java.util.*;

public class Program 
{
    public Vector<MDec> mdecs;
    public Statement stmt;

   public Program(Vector<MDec> ml, Statement s) {
    
       this.mdecs  = ml;
       this.stmt   = s;
   }

}
