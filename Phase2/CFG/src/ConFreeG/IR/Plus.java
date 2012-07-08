package ConFreeG.IR;

public class Plus extends AExpr{

    public AExpr left;
    public AExpr right;

    public Plus(AExpr l, AExpr r) {
       this.left = l;
       this.right = r;
    }

}
