package ConFreeG.IR;

public class Assign extends Statement
{

    public Var lhs;
    public AExpr e;

    public Assign(Var lhs, AExpr e) {
       this.lhs = lhs;
       this.e = e;
    }
}
