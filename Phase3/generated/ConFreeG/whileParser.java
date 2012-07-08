// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g 2010-05-12 06:14:27


  package ConFreeG;  
  import ConFreeG.IR.*;
  import java.util.Vector;
  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class whileParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "NUM", "LOWER", "UPPER", "NONNULL", "NUMBER", "NEWLINE", "WHITESPACE", "'='", "'{'", "';'", "'}'", "'('", "'-'", "'+'", "'*'", "')'", "'true'", "'false'", "'&&'", "'||'", "'!'", "'>'", "'<'", "'skip'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'od'", "':='", "'input'", "'output'"
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
    public static final int NUM=5;
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
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENT=4;
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
    public String getGrammarFileName() { return "D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g"; }






    // $ANTLR start "program"
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:19:1: program returns [Program p] : d= decM s= stmt ;
    public final Program program() throws RecognitionException {
        Program p = null;

        Vector<MDec> d = null;

        Statement s = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:19:28: (d= decM s= stmt )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:20:4: d= decM s= stmt
            {
            pushFollow(FOLLOW_decM_in_program46);
            d=decM();

            state._fsp--;

            pushFollow(FOLLOW_stmt_in_program52);
            s=stmt();

            state._fsp--;

              
                   p = new Program(d,s);
               

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


    // $ANTLR start "decM"
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:26:1: decM returns [Vector<MDec> DmList] : ( (m= IDENT '=' '{' i= input s= stmt ';' o= output '}' ';' )+ | );
    public final Vector<MDec> decM() throws RecognitionException {
        Vector<MDec> DmList = null;

        Token m=null;
        Input i = null;

        Statement s = null;

        Output o = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:26:35: ( (m= IDENT '=' '{' i= input s= stmt ';' o= output '}' ';' )+ | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==12) ) {
                    alt2=1;
                }
                else if ( (LA2_1==36) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==16||(LA2_0>=28 && LA2_0<=29)||LA2_0==33) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:27:2: (m= IDENT '=' '{' i= input s= stmt ';' o= output '}' ';' )+
                    {
                    DmList = new Vector<MDec>();
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:28:2: (m= IDENT '=' '{' i= input s= stmt ';' o= output '}' ';' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==IDENT) ) {
                            int LA1_2 = input.LA(2);

                            if ( (LA1_2==12) ) {
                                alt1=1;
                            }


                        }


                        switch (alt1) {
                    	case 1 :
                    	    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:28:3: m= IDENT '=' '{' i= input s= stmt ';' o= output '}' ';'
                    	    {
                    	    m=(Token)match(input,IDENT,FOLLOW_IDENT_in_decM87); 
                    	    match(input,12,FOLLOW_12_in_decM89); 
                    	    match(input,13,FOLLOW_13_in_decM91); 
                    	    pushFollow(FOLLOW_input_in_decM97);
                    	    i=input();

                    	    state._fsp--;

                    	    pushFollow(FOLLOW_stmt_in_decM103);
                    	    s=stmt();

                    	    state._fsp--;

                    	    match(input,14,FOLLOW_14_in_decM105); 
                    	    pushFollow(FOLLOW_output_in_decM111);
                    	    o=output();

                    	    state._fsp--;

                    	    match(input,15,FOLLOW_15_in_decM113); 
                    	    match(input,14,FOLLOW_14_in_decM115); 

                    	    		MDec d = new MDec((m!=null?m.getText():null),i,s,o);
                    	    		DmList.add(d);
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:33:3: 
                    {
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
        return DmList;
    }
    // $ANTLR end "decM"


    // $ANTLR start "arith"
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:35:1: arith returns [AExpr a] : (t= term | '(' a1= arith op= ( '-' | '+' | '*' ) a2= arith ')' | m= IDENT '(' a1= arith ')' );
    public final AExpr arith() throws RecognitionException {
        AExpr a = null;

        Token op=null;
        Token m=null;
        AExpr t = null;

        AExpr a1 = null;

        AExpr a2 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:35:24: (t= term | '(' a1= arith op= ( '-' | '+' | '*' ) a2= arith ')' | m= IDENT '(' a1= arith ')' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case NUM:
                {
                alt3=1;
                }
                break;
            case IDENT:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==16) ) {
                    alt3=3;
                }
                else if ( (LA3_2==EOF||LA3_2==14||(LA3_2>=17 && LA3_2<=20)||(LA3_2>=31 && LA3_2<=32)||LA3_2==35) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:36:5: t= term
                    {
                    pushFollow(FOLLOW_term_in_arith148);
                    t=term();

                    state._fsp--;

                    	
                        	a = t;  	
                        

                    }
                    break;
                case 2 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:40:7: '(' a1= arith op= ( '-' | '+' | '*' ) a2= arith ')'
                    {
                    match(input,16,FOLLOW_16_in_arith165); 
                    pushFollow(FOLLOW_arith_in_arith171);
                    a1=arith();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=17 && input.LA(1)<=19) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_arith_in_arith195);
                    a2=arith();

                    state._fsp--;

                    match(input,20,FOLLOW_20_in_arith197); 

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
                case 3 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:52:6: m= IDENT '(' a1= arith ')'
                    {
                    m=(Token)match(input,IDENT,FOLLOW_IDENT_in_arith221); 
                    match(input,16,FOLLOW_16_in_arith223); 
                    pushFollow(FOLLOW_arith_in_arith229);
                    a1=arith();

                    state._fsp--;

                    match(input,20,FOLLOW_20_in_arith231); 

                         	a = new Call((m!=null?m.getText():null), a1);
                         

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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:58:1: bool returns [BExpr b] : ( 'true' | 'false' | '(' b1= bool op= ( '&&' | '||' ) b2= bool ')' | '(' '!' b1= bool ')' | '(' t1= term op= ( '=' | '>' | '<' ) t2= term ')' );
    public final BExpr bool() throws RecognitionException {
        BExpr b = null;

        Token op=null;
        BExpr b1 = null;

        BExpr b2 = null;

        AExpr t1 = null;

        AExpr t2 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:58:23: ( 'true' | 'false' | '(' b1= bool op= ( '&&' | '||' ) b2= bool ')' | '(' '!' b1= bool ')' | '(' t1= term op= ( '=' | '>' | '<' ) t2= term ')' )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                switch ( input.LA(2) ) {
                case 25:
                    {
                    alt4=4;
                    }
                    break;
                case 16:
                case 21:
                case 22:
                    {
                    alt4=3;
                    }
                    break;
                case IDENT:
                case NUM:
                    {
                    alt4=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:59:7: 'true'
                    {
                    match(input,21,FOLLOW_21_in_bool268); 
                    	b = new True();  	

                    }
                    break;
                case 2 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:60:7: 'false'
                    {
                    match(input,22,FOLLOW_22_in_bool280); 
                    	b = new False();	

                    }
                    break;
                case 3 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:61:7: '(' b1= bool op= ( '&&' | '||' ) b2= bool ')'
                    {
                    match(input,16,FOLLOW_16_in_bool292); 
                    pushFollow(FOLLOW_bool_in_bool298);
                    b1=bool();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=23 && input.LA(1)<=24) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_bool_in_bool318);
                    b2=bool();

                    state._fsp--;

                    match(input,20,FOLLOW_20_in_bool320); 

                            	if( (op!=null?op.getText():null).equals("&&")){
                              		b = new And( b1, b2);
                              	}        
                            	else if( (op!=null?op.getText():null).equals("||")){
                              		b = new Or( b1, b2);
                            	}
                          

                    }
                    break;
                case 4 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:70:7: '(' '!' b1= bool ')'
                    {
                    match(input,16,FOLLOW_16_in_bool337); 
                    match(input,25,FOLLOW_25_in_bool339); 
                    pushFollow(FOLLOW_bool_in_bool345);
                    b1=bool();

                    state._fsp--;

                    match(input,20,FOLLOW_20_in_bool347); 

                            	b = new Neg(b1);      	
                          	

                    }
                    break;
                case 5 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:73:7: '(' t1= term op= ( '=' | '>' | '<' ) t2= term ')'
                    {
                    match(input,16,FOLLOW_16_in_bool357); 
                    pushFollow(FOLLOW_term_in_bool363);
                    t1=term();

                    state._fsp--;

                    op=(Token)input.LT(1);
                    if ( input.LA(1)==12||(input.LA(1)>=26 && input.LA(1)<=27) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_bool387);
                    t2=term();

                    state._fsp--;

                    match(input,20,FOLLOW_20_in_bool389); 

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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:86:1: term returns [AExpr a] : ( NUM | IDENT );
    public final AExpr term() throws RecognitionException {
        AExpr a = null;

        Token NUM1=null;
        Token IDENT2=null;

        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:86:24: ( NUM | IDENT )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NUM) ) {
                alt5=1;
            }
            else if ( (LA5_0==IDENT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:87:5: NUM
                    {
                    NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_term425); 
                    	
                        	int n = Integer.parseInt((NUM1!=null?NUM1.getText():null));
                        	a = new Num(n);
                        

                    }
                    break;
                case 2 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:92:7: IDENT
                    {
                    IDENT2=(Token)match(input,IDENT,FOLLOW_IDENT_in_term442); 
                    	
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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:98:1: stmt returns [Statement s] : ( 'skip' | assignStmt | sequenceStmt | ifStmt | whileStmt );
    public final Statement stmt() throws RecognitionException {
        Statement s = null;

        Assign assignStmt3 = null;

        Sequence sequenceStmt4 = null;

        If ifStmt5 = null;

        While whileStmt6 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:98:32: ( 'skip' | assignStmt | sequenceStmt | ifStmt | whileStmt )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt6=1;
                }
                break;
            case IDENT:
                {
                alt6=2;
                }
                break;
            case 16:
                {
                alt6=3;
                }
                break;
            case 29:
                {
                alt6=4;
                }
                break;
            case 33:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:99:6: 'skip'
                    {
                    match(input,28,FOLLOW_28_in_stmt476); 
                    	s = new Skip();		

                    }
                    break;
                case 2 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:100:7: assignStmt
                    {
                    pushFollow(FOLLOW_assignStmt_in_stmt489);
                    assignStmt3=assignStmt();

                    state._fsp--;

                    	s = assignStmt3;	

                    }
                    break;
                case 3 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:101:7: sequenceStmt
                    {
                    pushFollow(FOLLOW_sequenceStmt_in_stmt502);
                    sequenceStmt4=sequenceStmt();

                    state._fsp--;

                    	s = sequenceStmt4;

                    }
                    break;
                case 4 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:102:7: ifStmt
                    {
                    pushFollow(FOLLOW_ifStmt_in_stmt513);
                    ifStmt5=ifStmt();

                    state._fsp--;

                    	s = ifStmt5;	   	

                    }
                    break;
                case 5 :
                    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:103:7: whileStmt
                    {
                    pushFollow(FOLLOW_whileStmt_in_stmt525);
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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:106:1: sequenceStmt returns [Sequence s] : '(' s1= stmt ';' s2= stmt ')' ;
    public final Sequence sequenceStmt() throws RecognitionException {
        Sequence s = null;

        Statement s1 = null;

        Statement s2 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:106:35: ( '(' s1= stmt ';' s2= stmt ')' )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:107:2: '(' s1= stmt ';' s2= stmt ')'
            {
            match(input,16,FOLLOW_16_in_sequenceStmt554); 
            pushFollow(FOLLOW_stmt_in_sequenceStmt560);
            s1=stmt();

            state._fsp--;

            match(input,14,FOLLOW_14_in_sequenceStmt562); 
            pushFollow(FOLLOW_stmt_in_sequenceStmt568);
            s2=stmt();

            state._fsp--;

            match(input,20,FOLLOW_20_in_sequenceStmt570); 

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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:112:1: ifStmt returns [If i] : 'if' bool 'then' s1= stmt 'else' s2= stmt 'fi' ;
    public final If ifStmt() throws RecognitionException {
        If i = null;

        Statement s1 = null;

        Statement s2 = null;

        BExpr bool7 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:112:22: ( 'if' bool 'then' s1= stmt 'else' s2= stmt 'fi' )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:113:2: 'if' bool 'then' s1= stmt 'else' s2= stmt 'fi'
            {
            match(input,29,FOLLOW_29_in_ifStmt591); 
            pushFollow(FOLLOW_bool_in_ifStmt593);
            bool7=bool();

            state._fsp--;

            match(input,30,FOLLOW_30_in_ifStmt595); 
            pushFollow(FOLLOW_stmt_in_ifStmt601);
            s1=stmt();

            state._fsp--;

            match(input,31,FOLLOW_31_in_ifStmt604); 
            pushFollow(FOLLOW_stmt_in_ifStmt610);
            s2=stmt();

            state._fsp--;

            match(input,32,FOLLOW_32_in_ifStmt612); 

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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:118:1: whileStmt returns [While w] : 'while' bool 'do' stmt 'od' ;
    public final While whileStmt() throws RecognitionException {
        While w = null;

        BExpr bool8 = null;

        Statement stmt9 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:118:28: ( 'while' bool 'do' stmt 'od' )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:119:2: 'while' bool 'do' stmt 'od'
            {
            match(input,33,FOLLOW_33_in_whileStmt628); 
            pushFollow(FOLLOW_bool_in_whileStmt630);
            bool8=bool();

            state._fsp--;

            match(input,34,FOLLOW_34_in_whileStmt632); 
            pushFollow(FOLLOW_stmt_in_whileStmt634);
            stmt9=stmt();

            state._fsp--;

            match(input,35,FOLLOW_35_in_whileStmt636); 

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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:124:1: assignStmt returns [Assign a] : variable ':=' arith ;
    public final Assign assignStmt() throws RecognitionException {
        Assign a = null;

        Var variable10 = null;

        AExpr arith11 = null;


        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:124:30: ( variable ':=' arith )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:125:2: variable ':=' arith
            {
            pushFollow(FOLLOW_variable_in_assignStmt652);
            variable10=variable();

            state._fsp--;

            match(input,36,FOLLOW_36_in_assignStmt654); 
            pushFollow(FOLLOW_arith_in_assignStmt656);
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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:130:1: variable returns [Var v] : IDENT ;
    public final Var variable() throws RecognitionException {
        Var v = null;

        Token IDENT12=null;

        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:130:25: ( IDENT )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:131:2: IDENT
            {
            IDENT12=(Token)match(input,IDENT,FOLLOW_IDENT_in_variable672); 
            	
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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:136:1: input returns [Input i] : 'input' '(' IDENT ')' ';' ;
    public final Input input() throws RecognitionException {
        Input i = null;

        Token IDENT13=null;

        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:136:24: ( 'input' '(' IDENT ')' ';' )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:137:4: 'input' '(' IDENT ')' ';'
            {
            match(input,37,FOLLOW_37_in_input690); 
            match(input,16,FOLLOW_16_in_input692); 
            IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_input694); 
            match(input,20,FOLLOW_20_in_input696); 
            match(input,14,FOLLOW_14_in_input698); 

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
    // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:144:1: output returns [Output o] : 'output' '(' IDENT ')' ;
    public final Output output() throws RecognitionException {
        Output o = null;

        Token IDENT14=null;

        try {
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:144:26: ( 'output' '(' IDENT ')' )
            // D:\\DTU\\workspace\\assign3Intpreter\\src\\ConFreeG\\while.g:145:5: 'output' '(' IDENT ')'
            {
            match(input,38,FOLLOW_38_in_output724); 
            match(input,16,FOLLOW_16_in_output726); 
            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_output728); 
            match(input,20,FOLLOW_20_in_output730); 

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


 

    public static final BitSet FOLLOW_decM_in_program46 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_program52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_decM87 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_decM89 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_decM91 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_input_in_decM97 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_decM103 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_decM105 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_output_in_decM111 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_decM113 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_decM115 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_term_in_arith148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_arith165 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_arith_in_arith171 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_set_in_arith177 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_arith_in_arith195 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_arith197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_arith221 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_arith223 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_arith_in_arith229 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_arith231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_bool268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_bool280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_bool292 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_bool_in_bool298 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_set_in_bool304 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_bool_in_bool318 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bool320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_bool337 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_bool339 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_bool_in_bool345 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bool347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_bool357 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_term_in_bool363 = new BitSet(new long[]{0x000000000C001000L});
    public static final BitSet FOLLOW_set_in_bool369 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_term_in_bool387 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bool389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_in_term425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_stmt476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStmt_in_stmt489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceStmt_in_stmt502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStmt_in_stmt525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_sequenceStmt554 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_sequenceStmt560 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_sequenceStmt562 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_sequenceStmt568 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sequenceStmt570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ifStmt591 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_bool_in_ifStmt593 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStmt595 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_ifStmt601 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifStmt604 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_ifStmt610 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifStmt612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_whileStmt628 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_bool_in_whileStmt630 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_whileStmt632 = new BitSet(new long[]{0x0000000230010010L});
    public static final BitSet FOLLOW_stmt_in_whileStmt634 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_whileStmt636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_assignStmt652 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_assignStmt654 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_arith_in_assignStmt656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_variable672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_input690 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_input692 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_input694 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_input696 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_input698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_output724 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_output726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_output728 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_output730 = new BitSet(new long[]{0x0000000000000002L});

}