package Expresiones.Operaciones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.Operacion;

public class Aritmetica extends Operacion{
    
    public Aritmetica(int linea, Expresion opizq, TipoO operacion, Expresion opder) {
        super(linea, opizq, operacion, opder);
    }

    public Aritmetica(int linea, Expresion opizq, TipoO operacion) {
        super(linea, opizq, operacion);
    }
    
    @Override
    public Object getValor(Entorno e) {
        Object val1 = opizq==null?null:opizq.getValor(e);
        Object val2 = opder==null?null:opder.getValor(e);
        if(val1!=null && val2!=null)
        {
            Tipo super_tipo = getTipo(e);
            Tipo t1 = opizq.getTipo(e);
            Tipo t2 = opder.getTipo(e);
            switch(operacion){
                case SUMA:
                    if(super_tipo.isString()){
                        return val1.toString() + val2.toString();
                    }
                    else if(super_tipo.isDouble()){
                        return Double.parseDouble(val1.toString()) + Double.parseDouble(val2.toString());
                    }
                    else if(super_tipo.isNumeric()){
                        return Integer.parseInt(val1.toString()) + Integer.parseInt(val2.toString());
                    }
                    else{
                        System.out.println("Error!! al sumar los tipos: " + t1.get().toString() + " y " 
                        + t2.get().toString() + " en linea: " + linea);
                        return null;
                    }
                case RESTA:
                    if(super_tipo.isDouble()){
                        return Double.parseDouble(val1.toString()) - Double.parseDouble(val2.toString());
                    }
                    else if(super_tipo.isNumeric()){
                        return Integer.parseInt(val1.toString()) - Integer.parseInt(val2.toString());
                    }
                    else{
                        System.out.println("Error!! al restar los tipos: " + t1.get().toString() + " y " 
                        + t2.get().toString() + " en linea: " + linea);
                        return null;
                    }
                case MULTIPLICACION:
                    if(super_tipo.isDouble()){
                        return Double.parseDouble(val1.toString()) * Double.parseDouble(val2.toString());
                    }
                    else if(super_tipo.isNumeric()){
                        return Integer.parseInt(val1.toString()) * Integer.parseInt(val2.toString());
                    }
                    else{
                        System.out.println("Error!! al multiplicar los tipos: " + t1.get().toString() + " y " 
                        + t2.get().toString() + " en linea: " + linea);
                        return null;
                    }    
                case DIVISION:
                    if(super_tipo.isDouble()){
                        if(Double.parseDouble(val2.toString())!=0.0){
                            return Double.parseDouble(val1.toString()) / Double.parseDouble(val2.toString());
                        }
                        else
                        {
                            System.out.println("Error!! La division entre 0 no es valida linea: " + linea);
                            return null;
                        }
                    }
                    else if(super_tipo.isNumeric()){
                        if(Integer.parseInt(val2.toString())!=0){
                            return Integer.parseInt(val1.toString()) / Integer.parseInt(val2.toString());
                        }
                        else
                        {
                            System.out.println("Error!! La division entre 0 no es valida linea: " + linea);
                            return null;
                        }
                    }
                    else{
                        System.out.println("Error!! al dividir los tipos: " + t1.get().toString() + " y " 
                        + t2.get().toString() + " en linea: " + linea);
                        return null;
                    }
                case POTENCIA:
                    if(super_tipo.isDouble()){
                        return Math.pow(Double.parseDouble(val1.toString()), Double.parseDouble(val2.toString()));
                    }
                    else if(super_tipo.isNumeric()){
                        Double val = Math.pow(Double.parseDouble(val1.toString()), Double.parseDouble(val2.toString()));
                        return val.intValue();
                    }
                    else{
                        System.out.println("Erro!! No se puede operar la potencia con los tipos: " + t1.get() 
                                + " y " + t2.get() + " en linea: " + linea);
                    }
                default:
                    System.out.println("Error!! al realizar operacion: " + operacion + " linea: " + linea);
            }
        }
        else if(val1!=null && val2==null)
        {
            switch(operacion){
                case NEGATIVO:
                    Tipo super_tipo = getTipo(e);
                    if(super_tipo.isNumeric())
                        return Integer.parseInt(val1.toString()) * -1;
                    else if(super_tipo.isDouble())
                        return Double.parseDouble(val1.toString()) * -1;
                    else
                        System.out.println("Error!! al realizar operacion: " + operacion 
                                + " con el tipo de dato: " + opizq.getTipo(e) + " en linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! no se puede realizar la operacion: " + operacion 
                    + " con ambos operandos de tipo null en linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        if(opizq!=null && opder!=null)
        {
            Tipo tipo_opizq = opizq.getTipo(e);
            Tipo tipo_opder = opder.getTipo(e);
            if(tipo_opizq.isString() || tipo_opder.isString()){
                return new Tipo(Simbolo.TipoS.STRING);
            }
            else if(tipo_opizq.isBoolean() || tipo_opder.isBoolean()){
                return new Tipo(Simbolo.TipoS.NULL);
            }
            else if(tipo_opizq.isDouble() || tipo_opder.isDouble()){
                return new Tipo(Simbolo.TipoS.DOUBLE);
            }
            else if(tipo_opizq.isNumeric() || tipo_opder.isNumeric()){
                return new Tipo(Simbolo.TipoS.INT);
            }
        }
        else if(opizq!=null)
        {
            Tipo tipo_opizq = opizq.getTipo(e);
            if(tipo_opizq.isDouble())
                return new Tipo(Simbolo.TipoS.DOUBLE);
            else if(tipo_opizq.isNumeric())
                return new Tipo(Simbolo.TipoS.INT);
        }
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
