package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;

public class Identificador extends Expresion{

    public String valor;
    
    public Identificador(int linea, String valor){
        this.linea = linea;
        this.valor = valor;
    }
    
    @Override
    public Object getValor(Entorno e) {
        Simbolo s = e.get(valor);
        if(s!=null)
        {
            Object val = s.valor;
            if(val!=null)
                return val;
            else
            {
                System.out.println("Error!! al capturar el valor del id: " + valor + " en linea: " + linea);
            }
        }
        else{
            System.out.println("Error!! No se encontro el id: " + valor + " en este ambito linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        Simbolo s = e.get(valor);
        if(s!=null)
        {
            return s.tipo;
        }
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
