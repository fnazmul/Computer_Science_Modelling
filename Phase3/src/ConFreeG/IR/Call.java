package ConFreeG.IR;

public class Call extends AExpr{

    public String mid;
    public AExpr param;

    public Call(String m, AExpr p) {
       this.mid = m;
       this.param = p;
    }

}
