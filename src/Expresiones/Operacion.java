package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Tipo;

public class Operacion extends Expresion{

    public enum TipoO{
        SUMA,RESTA,MULTIPLICACION,DIVISION,NEGATIVO,POTENCIA,MODULO,
        MAYQUE,MENQUE,MAYIGUALQUE,MENIGUALQUE,
        AND, OR, NOT,
        IGUALQUE, DIFQUE
    }
    
    public Expresion opizq;
    public TipoO operacion;
    public Expresion opder;
    
    public Operacion(int linea, Expresion opizq, TipoO operacion, Expresion opder){
        this.linea = linea;
        this.opizq = opizq;
        this.operacion = operacion;
        this.opder = opder;
    }
    
    public Operacion(int linea, Expresion opizq, TipoO operacion){
        this.linea = linea;
        this.opizq = opizq;
        this.operacion = operacion;
    }
    
    @Override
    public Object getValor(Entorno e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo getTipo(Entorno e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
