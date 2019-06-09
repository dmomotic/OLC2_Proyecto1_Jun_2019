package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;

public class CastImplicito extends Expresion{
    
    Tipo tipo_asignado;
    Tipo tipo_a_asignar;
    Object valor;

    public CastImplicito(int linea, Tipo tipo_asignado, Tipo tipo_a_asignar, Object valor) {
        this.linea = linea;
        this.tipo_asignado = tipo_asignado;
        this.tipo_a_asignar = tipo_a_asignar;
        this.valor = valor;
    }
    
    @Override
    public Object getValor(Entorno e) {
        if(valor!=null){
            //Casteo a double
            if(tipo_asignado.isDouble())
            {
                //entero
                if(tipo_a_asignar.isInt())
                    return (int)valor + 0.0;
                //char
                else if(tipo_a_asignar.isChar())
                    return (int)((char)valor) + 0.0;
            }
            //Casteo a int
            else if(tipo_asignado.isInt())
            {
                //char
                if(tipo_a_asignar.isChar())
                    return (int)((char)valor);
            }
            //Casteo a char
            else if(tipo_asignado.isChar())
            {
                //int 
                if(tipo_a_asignar.isInt())
                    return (char)((int)valor);
            }
        }
        else
        {
            System.out.println("Error!! al realizar cast implicito ya que el valor enviado es null, linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        if(tipo_asignado!=null)
        {
            //Casteo a doble
            if(tipo_asignado.isDouble()){
                if(tipo_a_asignar.isInt())
                    return new Tipo(Simbolo.TipoS.INT);
                else if(tipo_a_asignar.isChar())
                    return new Tipo(Simbolo.TipoS.CHAR);
            }
            //Casteo a int
            else if(tipo_asignado.isInt()){
                if(tipo_a_asignar.isChar())
                    return new Tipo(Simbolo.TipoS.CHAR);
            }
            //Casteo a char
            else if(tipo_asignado.isChar()){
                if(tipo_a_asignar.isInt())
                    return new Tipo(Simbolo.TipoS.INT);
            }
        }
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
