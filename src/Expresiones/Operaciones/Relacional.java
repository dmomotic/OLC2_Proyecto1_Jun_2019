package Expresiones.Operaciones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.Operacion;

public class Relacional extends Operacion{
    
    public Relacional(int linea, Expresion opizq, TipoO operacion, Expresion opder) {
        super(linea, opizq, operacion, opder);
    }
    
    @Override
    public Object getValor(Entorno e) {
        if(opizq!=null && opder!=null)
        {
            Object val1 = opizq.getValor(e);
            Object val2 = opder.getValor(e);
            Tipo t1 = opizq.getTipo(e);
            Tipo t2 = opder.getTipo(e);
            Tipo tipo = getTipoDominante(e);
            switch(operacion){
                case MENQUE:
                    if(tipo.isDouble()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Double.parseDouble(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Double.parseDouble(val2.toString());
                        return Double.parseDouble(a.toString()) < Double.parseDouble(b.toString());
                    }
                    else if(tipo.isNumeric()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Integer.parseInt(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Integer.parseInt(val2.toString());
                        return (int)a < (int)b;
                    }
                    else{
                        System.out.println("Error!! No se puede efectuar la opearcion relacional MENOR QUE " 
                                + " con tipos de dato: " + opizq.getTipo(e).get() + " y " + opder.getTipo(e).get() 
                                + " en linea: " + linea);
                    }
                    break;
                case MAYQUE:
                    if(tipo.isDouble()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Double.parseDouble(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Double.parseDouble(val2.toString());
                        return Double.parseDouble(a.toString()) > Double.parseDouble(b.toString());
                    }
                    else if(tipo.isNumeric()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Integer.parseInt(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Integer.parseInt(val2.toString());
                        return (int)a > (int)b;
                    }
                    else{
                        System.out.println("Error!! No se puede efectuar la opearcion relacional MAYOR QUE " 
                                + " con tipos de dato: " + opizq.getTipo(e).get() + " y " + opder.getTipo(e).get() 
                                + " en linea: " + linea);
                    }
                    break;
                    
                case MENIGUALQUE:
                    if(tipo.isDouble()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Double.parseDouble(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Double.parseDouble(val2.toString());
                        return Double.parseDouble(a.toString()) <= Double.parseDouble(b.toString());
                    }
                    else if(tipo.isNumeric()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Integer.parseInt(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Integer.parseInt(val2.toString());
                        return (int)a <= (int)b;
                    }
                    else{
                        System.out.println("Error!! No se puede efectuar la opearcion relacional MENOR IGUAL QUE " 
                                + " con tipos de dato: " + opizq.getTipo(e).get() + " y " + opder.getTipo(e).get() 
                                + " en linea: " + linea);
                    }
                    break;
                    
                case MAYIGUALQUE:
                    if(tipo.isDouble()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Double.parseDouble(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Double.parseDouble(val2.toString());
                        return Double.parseDouble(a.toString()) >= Double.parseDouble(b.toString());
                    }
                    else if(tipo.isNumeric()){
                        Object a = t1.get().equals(Simbolo.TipoS.CHAR)?(Character)val1:Integer.parseInt(val1.toString());
                        Object b = t2.get().equals(Simbolo.TipoS.CHAR)?(Character)val2:Integer.parseInt(val2.toString());
                        return (int)a >= (int)b;
                    }
                    else{
                        System.out.println("Error!! No se puede efectuar la opearcion relacional MAYOR IGUAL QUE " 
                                + " con tipos de dato: " + opizq.getTipo(e).get() + " y " + opder.getTipo(e).get() 
                                + " en linea: " + linea);
                    }
                    break;
                default:
                    System.out.println("Error!! Al realizar operacion: " + operacion + " como operacion relacional " 
                            + " en linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! Al realizar operacion relacional: " + operacion 
                    + " al menos uno de los operandos es null en linea: " +  linea);
        }
        return false;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return new Tipo(Simbolo.TipoS.BOOLEAN);
    }
    
    public Tipo getTipoDominante(Entorno e){
        if(opizq!=null && opder!=null)
        {
            Tipo t1 = opizq.getTipo(e);
            Tipo t2 = opder.getTipo(e);
            if(t1!=null && t2!=null)
            {
                if(t1.isString() || t2.isString()){
                    return new Tipo(Simbolo.TipoS.NULL);
                }
                else if(t1.isBoolean() || t2.isBoolean()){
                    return new Tipo(Simbolo.TipoS.NULL);
                }
                else if(t1.isDouble() || t2.isDouble()){
                    return new Tipo(Simbolo.TipoS.DOUBLE);
                }
                else if(t1.isNumeric() || t2.isNumeric())
                {
                    return new Tipo(Simbolo.TipoS.INT);
                }
            }
        }
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
