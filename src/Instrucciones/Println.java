package Instrucciones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;

public class Println extends Instruccion{
    
    Expresion valor;
    
    public Println(int linea, Expresion valor){
        this.linea = linea;
        this.valor = valor;
    }

    @Override
    public Object ejecutar(Entorno e) {
        Object val = valor.getValor(e);
        if(val!=null)
        {
            System.out.println(val.toString());
        }
        else
        {
            System.out.println("Error!! al ejecutar println() en linea: " + linea);
        }
        return null;
    }
    
}
