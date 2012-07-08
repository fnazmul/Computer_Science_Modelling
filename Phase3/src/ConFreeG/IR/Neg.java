package ConFreeG.IR;

public class Neg extends BExpr{

    public BExpr arg;

    public Neg(BExpr arg) {
       this.arg = arg;
    }
}
