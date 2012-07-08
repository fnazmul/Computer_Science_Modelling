package ConFreeG.IR;

public class Larger extends BExpr
{

    public AExpr left;
    public AExpr right;

    public Larger(AExpr l, AExpr r) {
       this.left = l;
       this.right = r;
    }
}
