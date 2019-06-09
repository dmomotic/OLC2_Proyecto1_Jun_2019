package Instrucciones;

import Expresiones.CastImplicito;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Simbolo;
import Arbol.Tipo;
import java.util.LinkedList;

public class Declaracion extends Instruccion{

    public Tipo tipo;
    public LinkedList<String> variables;
    public Expresion valor;

    public Declaracion(int linea, Tipo tipo, LinkedList<String> variables, Expresion valor) {
        this.linea = linea;
        this.tipo = tipo;
        this.variables = variables;
        this.valor = valor;
    }
    
    public Declaracion(int linea, Tipo tipo, LinkedList<String> variables) {
        this.linea = linea;
        this.tipo = tipo;
        this.variables = variables;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        for(String id: variables){
            //Si no existe la variable en los entornos
            if(e.get(id)==null)
            {
                //Registro el id en el entorno
                Simbolo simbolo = new Simbolo(tipo, id); 
                e.set(id, simbolo);
                //Si es la ultima variable de la lista, le asigno el valor si es diferente de null
                if(variables.getLast().equals(id))
                {
                    //Asignacion de valor a simbolo
                    if(valor!=null)
                    {
                        Object val = valor.getValor(e);
                        //Si el valor no es null 
                        if(val!=null)
                        {
                            //Lo asigno solo si los tipos son iguales
                            Object tipo_asignado = tipo.get();
                            Object tipo_a_asignar = valor.getTipo(e).get(); 
                            if(tipo_asignado.equals(tipo_a_asignar)){
                                simbolo.valor = val;
                            }
                            else
                            {
                                //Si los tipos no son iguales realizo las validaciones para el casteo implicito
                                CastImplicito ci = new CastImplicito(linea, tipo, valor.getTipo(e), val);
                                if(!ci.getTipo(e).isNull())
                                {
                                    simbolo.valor = ci.getValor(e);
                                }
                                //Si no cumple con las condiciones de casteo implicito
                                else
                                {
                                    System.out.println("Error!! No se puede asignar un tipo de dato: " + tipo_a_asignar 
                                        + " a la variable: " + id + " de tipo: " + tipo_asignado 
                                        + " en la linea: " + linea);
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error!! No se pudo capturar el valor expresion de la linea: " 
                                    + linea + " con id: " + id);
                            return null;
                        }
                    }
                }
            }
            else
            {
                System.out.println("Error!! Ya existe una variable con el identificador: " + id +" linea: " + linea);
            }
        }
        return null;
    }
    
}
