// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g 2010-04-11 18:09:29

  package ConFreeG;
  
  import ConFreeG.IR.*;
  import ConFreeG.Functions.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class whileParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUM", "IDENT", "LOWER", "UPPER", "NONNULL", "NUMBER", "NEWLINE", "WHITESPACE", "';'", "'('", "'-'", "'+'", "'*'", "')'", "'true'", "'false'", "'&&'", "'||'", "'!'", "'='", "'>'", "'<'", "'skip'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'od'", "':='", "'input'", "'output'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int NUMBER=9;
    public static final int WHITESPACE=11;
    public static final int EOF=-1;
    public static final int NONNULL=8;
    public static final int NUM=4;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int NEWLINE=10;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENT=5;
    public static final int LOWER=6;
    public static final int UPPER=7;

    // delegates
    // delegators


        public whileParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public whileParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return whileParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g"; }






    // $ANTLR start "program"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:18:1: program returns [Program p] : a= input s= stmt ';' b= output ;
    public final Program program() throws RecognitionException {
        Program p = null;

        Input a = null;

        Statement s = null;

        Output b = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:18:28: (a= input s= stmt ';' b= output )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:19:4: a= input s= stmt ';' b= output
            {
            pushFollow(FOLLOW_input_in_program46);
            a=input();

            state._fsp--;

            pushFollow(FOLLOW_stmt_in_program52);
            s=stmt();

            state._fsp--;

            match(input,12,FOLLOW_12_in_program54); 
            pushFollow(FOLLOW_output_in_program60);
            b=output();

            state._fsp--;


                   p = new Program(a,s,b);
               

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return p;
    }
    // $ANTLR end "program"


    // $ANTLR start "arith"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:25:1: arith returns [AExpr a] : (t= term | '(' a1= arith op= ( '-' | '+' | '*' ) a2= arith ')' );
    public final AExpr arith() throws RecognitionException {
        AExpr a = null;

        Token op=null;
        AExpr t = null;

        AExpr a1 = null;

        AExpr a2 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:25:24: (t= term | '(' a1= arith op= ( '-' | '+' | '*' ) a2= arith ')' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=NUM && LA1_0<=IDENT)) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:26:5: t= term
                    {
                    pushFollow(FOLLOW_term_in_arith97);
                    t=term();

                    state._fsp--;

                    	
                        	a = t;  	
                        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:30:7: '(' a1= arith op= ( '-' | '+' | '*' ) a2= arith ')'
                    {
                    match(input,13,FOLLOW_13_in_arith114); 
                    pushFollow(FOLLOW_arith_in_arith120);
                    a1=arith();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=14 && input.LA(1)<=16) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_arith_in_arith144);
                    a2=arith();

                    state._fsp--;

                    match(input,17,FOLLOW_17_in_arith146); 

                          		if ((op!=null?op.getText():null).equals("-")){
                            		a = new Minus( a1, a2);
                          		}
                          		else if ((op!=null?op.getText():null).equals("+")){
                           			 a = new Plus( a1, a2);
                          		}
                         		if ((op!=null?op.getText():null).equals("*")){		
                            		a = new Times( a1, a2);
                          		} 
                        	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "arith"


    // $ANTLR start "bool"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:44:1: bool returns [BExpr b] : ( 'true' | 'false' | '(' b1= bool op= ( '&&' | '||' ) b2= bool ')' | '(' '!' b1= bool ')' | '(' t1= term op= ( '=' | '>' | '<' ) t2= term ')' );
    public final BExpr bool() throws RecognitionException {
        BExpr b = null;

        Token op=null;
        BExpr b1 = null;

        BExpr b2 = null;

        AExpr t1 = null;

        AExpr t2 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:44:23: ( 'true' | 'false' | '(' b1= bool op= ( '&&' | '||' ) b2= bool ')' | '(' '!' b1= bool ')' | '(' t1= term op= ( '=' | '>' | '<' ) t2= term ')' )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                switch ( input.LA(2) ) {
                case 22:
                    {
                    alt2=4;
                    }
                    break;
                case 13:
                case 18:
                case 19:
                    {
                    alt2=3;
                    }
                    break;
                case NUM:
                case IDENT:
                    {
                    alt2=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:45:7: 'true'
                    {
                    match(input,18,FOLLOW_18_in_bool189); 
                    	b = new True();  	

                    }
                    break;
                case 2 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:46:7: 'false'
                    {
                    match(input,19,FOLLOW_19_in_bool201); 
                    	b = new False();	

                    }
                    break;
                case 3 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:47:7: '(' b1= bool op= ( '&&' | '||' ) b2= bool ')'
                    {
                    match(input,13,FOLLOW_13_in_bool213); 
                    pushFollow(FOLLOW_bool_in_bool219);
                    b1=bool();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=20 && input.LA(1)<=21) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_bool_in_bool239);
                    b2=bool();

                    state._fsp--;

                    match(input,17,FOLLOW_17_in_bool241); 

                            	if( (op!=null?op.getText():null).equals("&&")){
                              		b = new And( b1, b2);
                              	}        
                            	else if( (op!=null?op.getText():null).equals("||")){
                              		b = new Or( b1, b2);
                            	}
                          

                    }
                    break;
                case 4 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:56:7: '(' '!' b1= bool ')'
                    {
                    match(input,13,FOLLOW_13_in_bool258); 
                    match(input,22,FOLLOW_22_in_bool260); 
                    pushFollow(FOLLOW_bool_in_bool266);
                    b1=bool();

                    state._fsp--;

                    match(input,17,FOLLOW_17_in_bool268); 

                            	b = new Neg(b1);      	
                          	

                    }
                    break;
                case 5 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:59:7: '(' t1= term op= ( '=' | '>' | '<' ) t2= term ')'
                    {
                    match(input,13,FOLLOW_13_in_bool278); 
                    pushFollow(FOLLOW_term_in_bool284);
                    t1=term();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=23 && input.LA(1)<=25) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_bool308);
                    t2=term();

                    state._fsp--;

                    match(input,17,FOLLOW_17_in_bool310); 

                            	if((op!=null?op.getText():null).equals("=")){
                              		b = new Equals(t1, t2);
                            	}
                            	else if((op!=null?op.getText():null).equals(">")){
                              		b = new Larger(t1, t2);
                            	}
                            	else if((op!=null?op.getText():null).equals ("<")){
                              		b = new Smaller(t1, t2);
                            	}
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return b;
    }
    // $ANTLR end "bool"


    // $ANTLR start "term"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:72:1: term returns [AExpr a] : ( NUM | IDENT );
    public final AExpr term() throws RecognitionException {
        AExpr a = null;

        Token NUM1=null;
        Token IDENT2=null;

        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:72:24: ( NUM | IDENT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NUM) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:73:5: NUM
                    {
                    NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_term346); 
                    	
                        	int n = Integer.parseInt((NUM1!=null?NUM1.getText():null));
                        	a = new Num(n);
                        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:78:7: IDENT
                    {
                    IDENT2=(Token)match(input,IDENT,FOLLOW_IDENT_in_term363); 
                    	
                        	a = new Var((IDENT2!=null?IDENT2.getText():null));	
                        

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "term"


    // $ANTLR start "stmt"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:84:1: stmt returns [Statement s] : ( 'skip' | assignStmt | sequenceStmt | ifStmt | whileStmt );
    public final Statement stmt() throws RecognitionException {
        Statement s = null;

        Assign assignStmt3 = null;

        Sequence sequenceStmt4 = null;

        If ifStmt5 = null;

        While whileStmt6 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:84:32: ( 'skip' | assignStmt | sequenceStmt | ifStmt | whileStmt )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt4=1;
                }
                break;
            case IDENT:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            case 27:
                {
                alt4=4;
                }
                break;
            case 31:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:85:6: 'skip'
                    {
                    match(input,26,FOLLOW_26_in_stmt397); 
                    	s = new Skip();		

                    }
                    break;
                case 2 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:86:7: assignStmt
                    {
                    pushFollow(FOLLOW_assignStmt_in_stmt410);
                    assignStmt3=assignStmt();

                    state._fsp--;

                    	s = assignStmt3;	

                    }
                    break;
                case 3 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:87:7: sequenceStmt
                    {
                    pushFollow(FOLLOW_sequenceStmt_in_stmt423);
                    sequenceStmt4=sequenceStmt();

                    state._fsp--;

                    	s = sequenceStmt4;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:88:7: ifStmt
                    {
                    pushFollow(FOLLOW_ifStmt_in_stmt434);
                    ifStmt5=ifStmt();

                    state._fsp--;

                    	s = ifStmt5;	   	

                    }
                    break;
                case 5 :
                    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:89:7: whileStmt
                    {
                    pushFollow(FOLLOW_whileStmt_in_stmt446);
                    whileStmt6=whileStmt();

                    state._fsp--;

                    	s = whileStmt6;	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "stmt"


    // $ANTLR start "sequenceStmt"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:92:1: sequenceStmt returns [Sequence s] : '(' s1= stmt ';' s2= stmt ')' ;
    public final Sequence sequenceStmt() throws RecognitionException {
        Sequence s = null;

        Statement s1 = null;

        Statement s2 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:92:35: ( '(' s1= stmt ';' s2= stmt ')' )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:93:2: '(' s1= stmt ';' s2= stmt ')'
            {
            match(input,13,FOLLOW_13_in_sequenceStmt475); 
            pushFollow(FOLLOW_stmt_in_sequenceStmt481);
            s1=stmt();

            state._fsp--;

            match(input,12,FOLLOW_12_in_sequenceStmt483); 
            pushFollow(FOLLOW_stmt_in_sequenceStmt489);
            s2=stmt();

            state._fsp--;

            match(input,17,FOLLOW_17_in_sequenceStmt491); 

                		s = new Sequence(s1, s2);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "sequenceStmt"


    // $ANTLR start "ifStmt"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:98:1: ifStmt returns [If i] : 'if' bool 'then' s1= stmt 'else' s2= stmt 'fi' ;
    public final If ifStmt() throws RecognitionException {
        If i = null;

        Statement s1 = null;

        Statement s2 = null;

        BExpr bool7 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:98:22: ( 'if' bool 'then' s1= stmt 'else' s2= stmt 'fi' )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:99:2: 'if' bool 'then' s1= stmt 'else' s2= stmt 'fi'
            {
            match(input,27,FOLLOW_27_in_ifStmt512); 
            pushFollow(FOLLOW_bool_in_ifStmt514);
            bool7=bool();

            state._fsp--;

            match(input,28,FOLLOW_28_in_ifStmt516); 
            pushFollow(FOLLOW_stmt_in_ifStmt522);
            s1=stmt();

            state._fsp--;

            match(input,29,FOLLOW_29_in_ifStmt525); 
            pushFollow(FOLLOW_stmt_in_ifStmt531);
            s2=stmt();

            state._fsp--;

            match(input,30,FOLLOW_30_in_ifStmt533); 

            		i = new If( bool7, s1, s2); 		
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return i;
    }
    // $ANTLR end "ifStmt"


    // $ANTLR start "whileStmt"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:104:1: whileStmt returns [While w] : 'while' bool 'do' stmt 'od' ;
    public final While whileStmt() throws RecognitionException {
        While w = null;

        BExpr bool8 = null;

        Statement stmt9 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:104:28: ( 'while' bool 'do' stmt 'od' )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:105:2: 'while' bool 'do' stmt 'od'
            {
            match(input,31,FOLLOW_31_in_whileStmt549); 
            pushFollow(FOLLOW_bool_in_whileStmt551);
            bool8=bool();

            state._fsp--;

            match(input,32,FOLLOW_32_in_whileStmt553); 
            pushFollow(FOLLOW_stmt_in_whileStmt555);
            stmt9=stmt();

            state._fsp--;

            match(input,33,FOLLOW_33_in_whileStmt557); 

            		w = new While( bool8, stmt9);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return w;
    }
    // $ANTLR end "whileStmt"


    // $ANTLR start "assignStmt"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:110:1: assignStmt returns [Assign a] : variable ':=' arith ;
    public final Assign assignStmt() throws RecognitionException {
        Assign a = null;

        Var variable10 = null;

        AExpr arith11 = null;


        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:110:30: ( variable ':=' arith )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:111:2: variable ':=' arith
            {
            pushFollow(FOLLOW_variable_in_assignStmt573);
            variable10=variable();

            state._fsp--;

            match(input,34,FOLLOW_34_in_assignStmt575); 
            pushFollow(FOLLOW_arith_in_assignStmt577);
            arith11=arith();

            state._fsp--;


            		a = new Assign(variable10, arith11); 
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "assignStmt"


    // $ANTLR start "variable"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:116:1: variable returns [Var v] : IDENT ;
    public final Var variable() throws RecognitionException {
        Var v = null;

        Token IDENT12=null;

        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:116:25: ( IDENT )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:117:2: IDENT
            {
            IDENT12=(Token)match(input,IDENT,FOLLOW_IDENT_in_variable593); 
            	
            		v = new Var((IDENT12!=null?IDENT12.getText():null));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return v;
    }
    // $ANTLR end "variable"


    // $ANTLR start "input"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:122:1: input returns [Input i] : 'input' '(' IDENT ')' ';' ;
    public final Input input() throws RecognitionException {
        Input i = null;

        Token IDENT13=null;

        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:122:24: ( 'input' '(' IDENT ')' ';' )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:123:4: 'input' '(' IDENT ')' ';'
            {
            match(input,35,FOLLOW_35_in_input611); 
            match(input,13,FOLLOW_13_in_input613); 
            IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_input615); 
            match(input,17,FOLLOW_17_in_input617); 
            match(input,12,FOLLOW_12_in_input619); 

                    Var v = new Var((IDENT13!=null?IDENT13.getText():null));
                    i = new Input(v);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return i;
    }
    // $ANTLR end "input"


    // $ANTLR start "output"
    // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:130:1: output returns [Output o] : 'output' '(' IDENT ')' ;
    public final Output output() throws RecognitionException {
        Output o = null;

        Token IDENT14=null;

        try {
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:130:26: ( 'output' '(' IDENT ')' )
            // C:\\Users\\Muna\\workspace\\CFG\\src\\ConFreeG\\while.g:131:5: 'output' '(' IDENT ')'
            {
            match(input,36,FOLLOW_36_in_output645); 
            match(input,13,FOLLOW_13_in_output647); 
            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_output649); 
            match(input,17,FOLLOW_17_in_output651); 

                    Var v = new Var((IDENT14!=null?IDENT14.getText():null));
                    o = new Output(v);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return o;
    }
    // $ANTLR end "output"

    // Delegated rules


 

    public static final BitSet FOLLOW_input_in_program46 = new BitSet(new long[]{0x000000008C002020L});
    public static final BitSet FOLLOW_stmt_in_program52 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_program54 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_output_in_program60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_arith97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_arith114 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_arith_in_arith120 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_set_in_arith126 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_arith_in_arith144 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_arith146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bool189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_bool201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_bool213 = new BitSet(new long[]{0x00000000000C2000L});
    public static final BitSet FOLLOW_bool_in_bool219 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_set_in_bool225 = new BitSet(new long[]{0x00000000000C2000L});
    public static final BitSet FOLLOW_bool_in_bool239 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_bool241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_bool258 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_bool260 = new BitSet(new long[]{0x00000000000C2000L});
    public static final BitSet FOLLOW_bool_in_bool266 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_bool268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_bool278 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_term_in_bool284 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_set_in_bool290 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_term_in_bool308 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_bool310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_in_term346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_stmt397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStmt_in_stmt410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceStmt_in_stmt423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStmt_in_stmt446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_sequenceStmt475 = new BitSet(new long[]{0x000000008C002020L});
    public static final BitSet FOLLOW_stmt_in_sequenceStmt481 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_sequenceStmt483 = new BitSet(new long[]{0x000000008C002020L});
    public static final BitSet FOLLOW_stmt_in_sequenceStmt489 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_sequenceStmt491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ifStmt512 = new BitSet(new long[]{0x00000000000C2000L});
    public static final BitSet FOLLOW_bool_in_ifStmt514 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ifStmt516 = new BitSet(new long[]{0x000000008C002020L});
    public static final BitSet FOLLOW_stmt_in_ifStmt522 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ifStmt525 = new BitSet(new long[]{0x000000008C002020L});
    public static final BitSet FOLLOW_stmt_in_ifStmt531 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStmt533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_whileStmt549 = new BitSet(new long[]{0x00000000000C2000L});
    public static final BitSet FOLLOW_bool_in_whileStmt551 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_whileStmt553 = new BitSet(new long[]{0x000000008C002020L});
    public static final BitSet FOLLOW_stmt_in_whileStmt555 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_whileStmt557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_assignStmt573 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_assignStmt575 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_arith_in_assignStmt577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_variable593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_input611 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_input613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_input615 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_input617 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_input619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_output645 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_output647 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_output649 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_output651 = new BitSet(new long[]{0x0000000000000002L});

}