package ConFreeG.IR;

public class Equals extends BExpr
{

    public AExpr left;
    public AExpr right;

    public Equals(AExpr l, AExpr r) {
       this.left = l;
       this.right = r;
    }
}
