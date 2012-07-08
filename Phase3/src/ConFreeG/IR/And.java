package ConFreeG.IR;

public class And extends BExpr
{

    public BExpr left;
    public BExpr right;

    public And(BExpr l, BExpr r) {
       this.left = l;
       this.right = r;
    }
}
