package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Tipo;

public class CastExplicito extends Expresion{

    Tipo tipo_destino;
    Expresion valor;

    public CastExplicito(int linea, Tipo tipo_destino, Expresion valor) {
        this.linea = linea;
        this.tipo_destino = tipo_destino;
        this.valor = valor;
    }
    
    @Override
    public Object getValor(Entorno e) {
        if(valor!=null)
        {
            Object val = valor.getValor(e);
            if(val!=null)
            {
                Tipo tipo_dato_a_convertir = valor.getTipo(e);
                //Validaciones para el casteo explicito
                //Casteo a entero
                if(tipo_destino.isInt())
                {
                    //double
                    if(tipo_dato_a_convertir.isDouble())
                        return (int)((double)val);
                    //string
                    else if(tipo_dato_a_convertir.isString())
                    {
                        if(val.toString().matches("-?\\d+"))
                            return Integer.parseInt(val.toString());
                        else
                        {
                            System.out.println("Error!! Number Format Exception se intento convertir a entero una expresion invalida, linea: " + linea);
                            return new Excepciones.NumberFormatException(linea);
                        }   
                    }
                    //char
                    else if(tipo_dato_a_convertir.isChar())
                        return (int)((char)val);
                    //boolean
                    else if(tipo_dato_a_convertir.isBoolean())
                        return (boolean)val==true?1:0;
                    else
                    {
                        System.out.println("Error!! No se puede convertir un tipo: " + tipo_dato_a_convertir.get() 
                            + " a INT en el cast explicito, linea: " + linea);
                    }
                }
                //Casteo a char
                else if(tipo_destino.isChar())
                {
                    //double
                    if(tipo_dato_a_convertir.isDouble())
                        return (char)((double)val);
                    //string
                    else if(tipo_dato_a_convertir.isString())
                        return val.toString().charAt(0);
                    //int
                    else if(tipo_dato_a_convertir.isInt())
                        return (char)((int)val);
                    else
                    {
                        System.out.println("Error!! No se puede convertir un tipo: " + tipo_dato_a_convertir.get() 
                            + " a CHAR en el cast explicito, linea: " + linea);
                    }
                }
                //Casteo a string con funcion str()
                else if(tipo_destino.isString())
                {
                    return val.toString();
                }
                //Casteo a double
                else if(tipo_destino.isDouble())
                {
                    //int
                    if(tipo_dato_a_convertir.isInt())
                        return (double)((int)val);
                    //char
                    else if(tipo_dato_a_convertir.isChar())
                        return (double)((int)((char)val));
                    //string
                    else if(tipo_dato_a_convertir.isString())
                        if(val.toString().matches("-?\\d+(\\.\\d+)?"))
                            return Double.parseDouble(val.toString());
                        else
                        {
                            System.out.println("Error!! Number Format Exception se intento convertir a double una expresion invalida, linea: " + linea);
                            return new Excepciones.NumberFormatException(linea);
                        }  
                            
                    else{
                        System.out.println("Error!! no se puede castear un tipo: " + tipo_dato_a_convertir.get() 
                                + " en la funcion toDouble(), linea: " + linea);
                    }
                }
            }
            else
            {
                System.out.println("Error!! al capturar valor para la expresion en el cast explicito, linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! al realizar cast explicito porque la expresion enviada es null, linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return tipo_destino;
    }
    
}
