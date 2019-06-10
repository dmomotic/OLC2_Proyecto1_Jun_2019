package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;

public class Ternario extends Expresion{

    Expresion condicion;
    Expresion isTrue;
    Expresion isFalse;
    public Tipo tipo;

    public Ternario(int linea, Expresion condicion, Expresion isTrue, Expresion isFalse) {
        this.linea = linea;
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
                //Agregado para capturar el tipo de retorno
                tipo = isTrue.getTipo(e);
                return retorno;
            }
            else{
                Object retorno = isFalse.getValor(e);
                if(retorno==null){
                    System.out.println("Error!! la opcion falsa del opeardor ternario retorno null en linea: " 
                            + linea);
                }
                //Agregado para capturar el tipo de retorno
                tipo = isFalse.getTipo(e);
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
        //return (boolean)condicion.getValor(e)==true?isTrue.getTipo(e):isFalse.getTipo(e);
        //Para evitar que se vuelva a ejecutar el incremento 
        if(tipo!=null)
            return this.tipo;
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
