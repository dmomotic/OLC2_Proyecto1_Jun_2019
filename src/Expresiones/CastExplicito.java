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
                }
                //Casteo a char
                else if(tipo_destino.isChar())
                {
                    //double
                    if(tipo_dato_a_convertir.isDouble())
                        return (char)((double)val);
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
