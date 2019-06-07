package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Tipo;

public class Ternario extends Expresion{

    Expresion condicion;
    Expresion isTrue;
    Expresion isFalse;

    public Ternario(Expresion condicion, Expresion isTrue, Expresion isFalse) {
        this.condicion = condicion;
        this.isTrue = isTrue;
        this.isFalse = isFalse;
    }
    
    @Override
    public Object getValor(Entorno e) {
        Object val = condicion==null?null:condicion.getValor(e);
        if(val!=null)
        {
            if((boolean)val){
                Object retorno = isTrue.getValor(e);
                if(retorno==null){
                    System.out.println("Error!! la opcion verdadera del opeardor ternario retorno null en linea: " 
                            + linea);
                }
                return retorno;
            }
            else{
                Object retorno = isFalse.getValor(e);
                if(retorno==null){
                    System.out.println("Error!! la opcion falsa del opeardor ternario retorno null en linea: " 
                            + linea);
                }
                return retorno;
            }
        }
        else{
            System.out.println("Error!! Al capturar valor de la condicion en operador ternario en linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return (boolean)condicion.getValor(e)==true?isTrue.getTipo(e):isFalse.getTipo(e);
    }
    
}
