package ConFreeG.IR;

public class While extends Statement{

    public BExpr condition;
    public Statement s;

    public While(BExpr condition, Statement s) {
        this.condition = condition;
        this.s = s;
    }

}
