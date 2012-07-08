package ConFreeG.IR;

public class MDec 
{
    public String mid; 
    public Input input;
    public Statement stmt;
    public Output output;

    public MDec(String m, Input i, Statement s, Output o) {
    	this.mid = m;
    	this.input  = i;
    	this.stmt   = s;
    	this.output = o;
    }
}