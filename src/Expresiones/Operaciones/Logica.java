package Expresiones.Operaciones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.Operacion;

public class Logica extends Operacion{

    public Logica(int linea, Expresion opizq, TipoO operacion, Expresion opder) {
        super(linea, opizq, operacion, opder);
    }
    
    public Logica(int linea, Expresion opizq, TipoO operacion) {
        super(linea, opizq, operacion);
    }
    
    @Override 
    public Object getValor(Entorno e) {
        if(opizq!=null && opder!=null)
        {
            Object val1 = opizq.getValor(e);
            Object val2 = opder.getValor(e);
            if(val1!=null && val2!=null){
                Tipo t1 = opizq.getTipo(e);
                Tipo t2 = opder.getTipo(e);
                if(t1.isBoolean() && t2.isBoolean()){
                    switch(operacion){
                        case AND:
                            return (boolean)val1 && (boolean)val2;
                        case OR:
                            return (boolean)val1 || (boolean)val2;
                        case XOR:
                            return (boolean)val1 ^ (boolean)val2;
                        default:
                            System.out.println("Error!! No se puede realizar la operacion logica: " + operacion 
                                    + "en linea: " + linea);
                    }
                }
                else
                {
                    System.out.println("Error!! No se puede realizar la operacion logica: " + operacion 
                            + " con los tipos: " + t1.get() + " y " + t2.get() + " en la linea: " + linea);
                }
            }
            else
            {
                System.out.println("Error!! No se efectuo la operacion logica: " + operacion 
                        + " uno de los operandos retorno null en linea: " + linea);
            }
        }
        else if(opizq!=null && opder==null)
        {
            Object val1 = opizq.getValor(e);
            if(val1!=null)
            {
                Tipo t1 = opizq.getTipo(e);
                if(t1.isBoolean())
                {
                    switch(operacion){
                        case NOT:
                            return !(boolean)val1;
                        default:
                            System.out.println("Error!! No se puede realizar la operacion logica: " + operacion 
                                    + "en linea: " + linea);
                    }
                }
                else
                {
                    System.out.println("Error!! No se puede realizar la opearcion logica: " + operacion 
                            + " porque el valor de la expresion no es tipo bool en linea: " + linea);
                }
            }
            else
            {
                System.out.println("Error!! El valor de la expresion es null al realizar operacion: " + operacion 
                        + " en linea: " + linea);
            }
        }
        return false;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return new Tipo(Simbolo.TipoS.BOOLEAN);
    }
}
