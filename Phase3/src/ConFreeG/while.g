grammar while;

@lexer::header {
  package ConFreeG;
}  

@header {

  package ConFreeG;  
  import ConFreeG.IR.*;
  import java.util.Vector;
  
}

@parser::members {

}

program returns [Program p]:
   d = decM s = stmt   
   {  
       p = new Program(d,s);
   }
   ;
   
decM returns [Vector<MDec> DmList]:
	{DmList = new Vector<MDec>();}
	(m = IDENT '=' '{' i = input s = stmt ';' o = output '}' ';'
	{
		MDec d = new MDec($m.text,i,s,o);
		DmList.add(d);
	})+
	|;
      
arith returns [AExpr a]:
    t = term  	
    {	
    	a = $t.a;  	
    }
    | '(' a1 = arith op = ( '-' | '+' | '*' ) a2 = arith ')'  
    	{
      		if ($op.text.equals("-")){
        		a = new Minus( $a1.a, $a2.a);
      		}
      		else if ($op.text.equals("+")){
       			 a = new Plus( $a1.a, $a2.a);
      		}
     		if ($op.text.equals("*")){		
        		a = new Times( $a1.a, $a2.a);
      		} 
    	}    
    |m = IDENT '(' a1 = arith ')'
     {
     	a = new Call($m.text, $a1.a);
     }
    ;
    
bool returns [BExpr b]:    
      'true' 		{	b = new True();  	}
    | 'false' 		{	b = new False();	}
    | '(' b1 = bool op = ( '&&' | '||' ) b2 = bool ')'
      	{
        	if( $op.text.equals("&&")){
          		b = new And( $b1.b, $b2.b);
          	}        
        	else if( $op.text.equals("||")){
          		b = new Or( $b1.b, $b2.b);
        	}
      }
    | '(' '!' b1 = bool ')'	{
        	b = new Neg($b1.b);      	
      	}
    | '(' t1 = term op = ( '=' | '>' | '<' ) t2 = term ')' 	{
        	if($op.text.equals("=")){
          		b = new Equals($t1.a, $t2.a);
        	}
        	else if($op.text.equals(">")){
          		b = new Larger($t1.a, $t2.a);
        	}
        	else if($op.text.equals ("<")){
          		b = new Smaller($t1.a, $t2.a);
        	}
      }
    ;
        
term  returns [AExpr a]:    
    NUM			
    {	
    	int n = Integer.parseInt($NUM.text);
    	a = new Num(n);
    }
    | IDENT		
    {	
    	a = new Var($IDENT.text);	
    }
    ;

stmt     returns [Statement s] :
     'skip'				{	s = new Skip();		}
    | assignStmt	  	{	s = $assignStmt.a;	}
    | sequenceStmt		{	s = $sequenceStmt.s;}
    | ifStmt			{	s = $ifStmt.i;	   	}
    | whileStmt     	{	s = $whileStmt.w;	}
    ;
    
sequenceStmt returns [Sequence s] :
	'(' s1 = stmt ';' s2 = stmt ')'	{
    		s = new Sequence($s1.s, $s2.s);
    }    	
	;

ifStmt returns [If i]:
	'if' bool 'then' s1 = stmt  'else' s2 = stmt 'fi' {
		i = new If( $bool.b, $s1.s, $s2.s); 		
	}
	;

whileStmt returns [While w]:
	'while' bool 'do' stmt 'od' {
		w = new While( $bool.b, $stmt.s);
	}
	;

assignStmt returns [Assign a]:
	variable ':=' arith {
		a = new Assign($variable.v, $arith.a); 
	}
	;

variable returns [Var v]:
	IDENT	{	
		v = new Var($IDENT.text);
	}
	;

input returns [Input i]:
   'input' '(' IDENT ')' ';'
    {
        Var v = new Var($IDENT.text);
        i = new Input(v);
    }
    ;

output returns [Output o]:
    'output' '(' IDENT ')' 
    {
        Var v = new Var($IDENT.text);
        o = new Output(v);
    }
    ;

fragment LOWER : ('a'..'z');
fragment UPPER : ('A'..'Z');
fragment NONNULL : ('1'..'9');
fragment NUMBER : ('0' | NONNULL);
IDENT  : ( LOWER | UPPER ) ( LOWER | UPPER | NUMBER )*;
NUM    : '0' | NONNULL NUMBER*;

fragment NEWLINE:'\r'? '\n';
WHITESPACE  :   ( ' ' | '\t' | NEWLINE )+ { $channel=HIDDEN; };
