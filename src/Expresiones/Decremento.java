package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;

public class Decremento extends Expresion{

    Identificador id;
    boolean postfijo;
    
    public Decremento(int linea, Identificador id){
        this.linea = linea;
        this.id = id;
    }

    public Decremento(int linea, Identificador id, boolean postfijo) {
        this.linea = linea;
        this.id = id;
        this.postfijo = postfijo;
    }
    
    @Override
    public Object getValor(Entorno e) {
        Simbolo s = e.get(id.valor);
        if(s!=null)
        {
            if(s.tipo.isDouble()){
                s.valor = (double)s.valor - 1;
                if(postfijo)
                    return (double)s.valor + 1;
                //prefijo
                return s.valor;
            }
            else if(s.tipo.isChar()){
                char aux = (char) ((char)s.valor - 1);
                s.valor = aux;
                if(postfijo)
                    return (char)(aux+1);
                //prefijo
                return aux;
            }
            else if(s.tipo.isNumeric()){
                s.valor = (int)s.valor - 1;
                if(postfijo)
                    return (int)s.valor + 1;
                //prefijo
                return s.valor;
            }
            else{
                System.out.println("Error!! No se puede realizar el drecremento a la variable: " + id.valor + " de tipo: " 
                        + s.tipo.get() + " en la linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! no se puede realizar el decremento -- porque no se encontro el id: " + id.valor 
                    + " en la linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        Simbolo s = e.get(id.valor);
        if(s!=null){
            if(s.tipo.isDouble())
                return new Tipo(Simbolo.TipoS.DOUBLE);
            else if(s.tipo.isNumeric())
                return new Tipo(Simbolo.TipoS.INT);
        }
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
