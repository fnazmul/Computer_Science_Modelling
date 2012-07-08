package ConFreeG.IR;

public class Smaller extends BExpr
{

    public AExpr left;
    public AExpr right;

    public Smaller(AExpr l, AExpr r) {
       this.left = l;
       this.right = r;
    }
}
