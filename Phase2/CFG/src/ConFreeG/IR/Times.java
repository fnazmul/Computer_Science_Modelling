package ConFreeG.IR;

public class Times extends AExpr{

    public AExpr left;
    public AExpr right;

    public Times(AExpr l, AExpr r) {
       this.left = l;
       this.right = r;
    }

}
