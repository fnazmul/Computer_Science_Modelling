package ConFreeG.IR;

public class If extends Statement{

    public BExpr condition;
    public Statement s1;
    public Statement s2;

    public If(BExpr condition, Statement s1, Statement s2) {
        this.condition = condition;
        this.s1 = s1;
        this.s2 = s2;
    }
}
