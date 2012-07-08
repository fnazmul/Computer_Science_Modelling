package ConFreeG.IR;

public class Minus extends AExpr{

    public AExpr left;
    public AExpr right;

    public Minus(AExpr l, AExpr r) {
       this.left = l;
       this.right = r;
      
    }

}
