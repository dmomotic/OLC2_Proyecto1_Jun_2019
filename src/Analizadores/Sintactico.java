
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import Arbol.*;
import Expresiones.*;
import Instrucciones.*;
import Expresiones.Operaciones.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Simbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\035\000\002\002\004\000\002\002\003\000\002\006" +
    "\004\000\002\006\003\000\002\005\003\000\002\005\003" +
    "\000\002\005\007\000\002\004\006\000\002\003\007\000" +
    "\002\003\005\000\002\007\003\000\002\007\003\000\002" +
    "\007\003\000\002\007\003\000\002\007\003\000\002\010" +
    "\005\000\002\010\003\000\002\011\004\000\002\011\005" +
    "\000\002\011\005\000\002\011\005\000\002\011\005\000" +
    "\002\011\003\000\002\011\003\000\002\011\003\000\002" +
    "\011\003\000\002\011\003\000\002\011\003\000\002\011" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\060\000\020\004\017\005\014\006\006\007\012\010" +
    "\011\054\005\062\010\001\002\000\022\002\ufffe\004\ufffe" +
    "\005\ufffe\006\ufffe\007\ufffe\010\ufffe\054\ufffe\062\ufffe\001" +
    "\002\000\004\013\060\001\002\000\004\054\ufff5\001\002" +
    "\000\022\002\ufffd\004\ufffd\005\ufffd\006\ufffd\007\ufffd\010" +
    "\ufffd\054\ufffd\062\ufffd\001\002\000\004\022\054\001\002" +
    "\000\004\054\ufff3\001\002\000\004\054\ufff4\001\002\000" +
    "\004\002\053\001\002\000\004\054\ufff6\001\002\000\022" +
    "\002\000\004\017\005\014\006\006\007\012\010\011\054" +
    "\005\062\010\001\002\000\022\002\ufffc\004\ufffc\005\ufffc" +
    "\006\ufffc\007\ufffc\010\ufffc\054\ufffc\062\ufffc\001\002\000" +
    "\004\054\ufff7\001\002\000\004\054\022\001\002\000\010" +
    "\013\023\014\024\015\025\001\002\000\010\013\ufff1\014" +
    "\ufff1\015\ufff1\001\002\000\022\011\033\012\036\017\032" +
    "\054\027\055\035\056\031\057\034\060\030\001\002\000" +
    "\022\002\ufff8\004\ufff8\005\ufff8\006\ufff8\007\ufff8\010\ufff8" +
    "\054\ufff8\062\ufff8\001\002\000\004\054\026\001\002\000" +
    "\010\013\ufff2\014\ufff2\015\ufff2\001\002\000\016\014\uffeb" +
    "\016\uffeb\017\uffeb\020\uffeb\021\uffeb\023\uffeb\001\002\000" +
    "\016\014\uffe8\016\uffe8\017\uffe8\020\uffe8\021\uffe8\023\uffe8" +
    "\001\002\000\016\014\uffe9\016\uffe9\017\uffe9\020\uffe9\021" +
    "\uffe9\023\uffe9\001\002\000\022\011\033\012\036\017\032" +
    "\054\027\055\035\056\031\057\034\060\030\001\002\000" +
    "\016\014\uffe6\016\uffe6\017\uffe6\020\uffe6\021\uffe6\023\uffe6" +
    "\001\002\000\016\014\uffe7\016\uffe7\017\uffe7\020\uffe7\021" +
    "\uffe7\023\uffe7\001\002\000\016\014\uffea\016\uffea\017\uffea" +
    "\020\uffea\021\uffea\023\uffea\001\002\000\016\014\uffe5\016" +
    "\uffe5\017\uffe5\020\uffe5\021\uffe5\023\uffe5\001\002\000\014" +
    "\014\041\016\042\017\043\020\040\021\044\001\002\000" +
    "\022\011\033\012\036\017\032\054\027\055\035\056\031" +
    "\057\034\060\030\001\002\000\022\002\ufff9\004\ufff9\005" +
    "\ufff9\006\ufff9\007\ufff9\010\ufff9\054\ufff9\062\ufff9\001\002" +
    "\000\022\011\033\012\036\017\032\054\027\055\035\056" +
    "\031\057\034\060\030\001\002\000\022\011\033\012\036" +
    "\017\032\054\027\055\035\056\031\057\034\060\030\001" +
    "\002\000\022\011\033\012\036\017\032\054\027\055\035" +
    "\056\031\057\034\060\030\001\002\000\016\014\uffec\016" +
    "\uffec\017\uffec\020\uffec\021\uffec\023\uffec\001\002\000\016" +
    "\014\uffee\016\uffee\017\uffee\020\040\021\044\023\uffee\001" +
    "\002\000\016\014\uffef\016\uffef\017\uffef\020\040\021\044" +
    "\023\uffef\001\002\000\016\014\uffed\016\uffed\017\uffed\020" +
    "\uffed\021\uffed\023\uffed\001\002\000\016\014\ufff0\016\ufff0" +
    "\017\ufff0\020\ufff0\021\ufff0\023\ufff0\001\002\000\022\002" +
    "\uffff\004\uffff\005\uffff\006\uffff\007\uffff\010\uffff\054\uffff" +
    "\062\uffff\001\002\000\004\002\001\001\002\000\022\011" +
    "\033\012\036\017\032\054\027\055\035\056\031\057\034" +
    "\060\030\001\002\000\014\016\042\017\043\020\040\021" +
    "\044\023\056\001\002\000\004\014\057\001\002\000\022" +
    "\002\ufffb\004\ufffb\005\ufffb\006\ufffb\007\ufffb\010\ufffb\054" +
    "\ufffb\062\ufffb\001\002\000\022\011\033\012\036\017\032" +
    "\054\027\055\035\056\031\057\034\060\030\001\002\000" +
    "\014\014\062\016\042\017\043\020\040\021\044\001\002" +
    "\000\022\002\ufffa\004\ufffa\005\ufffa\006\ufffa\007\ufffa\010" +
    "\ufffa\054\ufffa\062\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\060\000\016\002\012\003\006\004\015\005\003\006" +
    "\014\007\017\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\003\006\004\015\005\051\007\017\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\010\020" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\036\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\011\050\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\011\047\001\001\000\002\001\001\000\004" +
    "\011\046\001\001\000\004\011\045\001\001\000\004\011" +
    "\044\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\054\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\060\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  
    LinkedList<Nodo> arbol;

    //Metodo al que se llama automaticamente ante algun error sintactico
    public void syntax_error(Symbol s)
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!!!!!!! Error Sintactico Recuperado !!!!!!!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);
    }

    //Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!!!!!!! Error Sintactico, Panic Mode !!!!!!! ");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);
    }

    public LinkedList<Nodo> getAST(){
        return arbol;
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {





  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= INSTRUCCIONES 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		LinkedList<Nodo> a = (LinkedList<Nodo>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 parser.arbol=a; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              LinkedList<Nodo> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		LinkedList<Nodo> a = (LinkedList<Nodo>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo b = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=a; RESULT.add(b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              LinkedList<Nodo> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Nodo a = (Nodo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new LinkedList<>(); RESULT.add(a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= DECLARACION 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=a; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INSTRUCCION ::= ASIGNACION 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=a; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INSTRUCCION ::= rprintln parizq EXP parder ptocoma 
            {
              Nodo RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Println(bright,a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ASIGNACION ::= id igual EXP ptocoma 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		 RESULT=new Asignacion(aright,new Identificador(aright,a),b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ASIGNACION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // DECLARACION ::= TIPO_VAR L_VARIABLES igual EXP ptocoma 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)).right;
		Tipo a = (Tipo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		LinkedList<String> b = (LinkedList<String>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Expresion c = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Declaracion(dright,a,b,c); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACION",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DECLARACION ::= TIPO_VAR L_VARIABLES ptocoma 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Tipo a = (Tipo)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		LinkedList<String> b = (LinkedList<String>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Declaracion(cright,a,b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACION",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // TIPO_VAR ::= rint 
            {
              Tipo RESULT =null;
		 RESULT=new Tipo(Simbolo.TipoS.INT); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("TIPO_VAR",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // TIPO_VAR ::= rdouble 
            {
              Tipo RESULT =null;
		 RESULT=new Tipo(Simbolo.TipoS.DOUBLE); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("TIPO_VAR",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // TIPO_VAR ::= rchar 
            {
              Tipo RESULT =null;
		 RESULT=new Tipo(Simbolo.TipoS.CHAR); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("TIPO_VAR",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // TIPO_VAR ::= rboolean 
            {
              Tipo RESULT =null;
		 RESULT=new Tipo(Simbolo.TipoS.BOOLEAN); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("TIPO_VAR",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // TIPO_VAR ::= rstring 
            {
              Tipo RESULT =null;
		 RESULT=new Tipo(Simbolo.TipoS.STRING); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("TIPO_VAR",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // L_VARIABLES ::= L_VARIABLES coma id 
            {
              LinkedList<String> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		LinkedList<String> a = (LinkedList<String>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=a; RESULT.add(b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("L_VARIABLES",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // L_VARIABLES ::= id 
            {
              LinkedList<String> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new LinkedList<>(); RESULT.add(a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("L_VARIABLES",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXP ::= menos EXP 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXP ::= EXP mas EXP 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Aritmetica(cright,a,Operacion.TipoO.SUMA,b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXP ::= EXP menos EXP 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Aritmetica(cright,a,Operacion.TipoO.RESTA,b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXP ::= EXP por EXP 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Aritmetica(cright,a,Operacion.TipoO.MULTIPLICACION,b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXP ::= EXP div EXP 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Aritmetica(cright,a,Operacion.TipoO.DIVISION,b); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EXP ::= id 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Identificador(aright,a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EXP ::= numero 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Literal(aright,Integer.parseInt(a)); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // EXP ::= decimal 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Literal(aright,Double.parseDouble(a)); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // EXP ::= cadena 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Literal(aright,a); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // EXP ::= caracter 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Literal(aright,a.charAt(1)); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // EXP ::= rtrue 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Literal(aright,true); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // EXP ::= rfalse 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT=new Literal(aright,false); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
