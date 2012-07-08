package ConFreeG.IR;

public class Or extends BExpr{

    public BExpr left;
    public BExpr right;

    public Or(BExpr l, BExpr r) {
       this.left = l;
       this.right = r;
    }

}
