package ConFreeG.IR;

public class Sequence extends Statement 
{
    public Statement s1;
    public Statement s2;

    public Sequence(Statement s1, Statement s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
}
