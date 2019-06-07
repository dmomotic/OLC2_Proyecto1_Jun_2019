package Instrucciones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Simbolo;
import Expresiones.Identificador;

public class Asignacion extends Instruccion{
    
    Identificador id;
    Expresion valor;
    
    public Asignacion(int linea, Identificador id, Expresion valor){
        this.linea = linea;
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Object ejecutar(Entorno e) {
        Simbolo s = e.get(id.valor);
        //Si existe la variable
        if(s!=null && valor!=null)
        {
            //Verifico que los tipos sean iguales para asignar
            if(s.tipo.get().equals(valor.getTipo(e).get()))
            {
                Object val = valor.getValor(e);
                if(val!=null){
                    s.valor = val;
                }
                else{
                    System.out.println("Error!! al realizar asigancion en variable: " + id.valor 
                            + " porque no se obtuvo el valor de la expresion en linea: " + linea);
                }
            }
            //De lo contrario no realizo la asignacion ya que es un error de tipos
            else
            {
                System.out.println("Error!! No se puede asigar un tipo: " + valor.getTipo(e).get() + " a un tipo " 
                        + s.tipo.get() + " en la variable: " + id.valor + " en linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! No se encuentra el valor o la variable en la asignacion de: " + id.valor 
                    + " en linea: " + linea);
        }
        return null;
    }
    
}
