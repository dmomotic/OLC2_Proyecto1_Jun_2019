package Instrucciones;

import Arbol.Arreglo;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.CastImplicito;
import Expresiones.Identificador;
import java.util.LinkedList;

public class AsignacionArreglo extends Instruccion{

    Identificador id;
    LinkedList<Expresion> indices;
    Expresion valor;

    public AsignacionArreglo(int linea, Identificador id, LinkedList<Expresion> indices, Expresion valor) {
        this.linea = linea;
        this.id = id;
        this.indices = indices;
        this.valor = valor;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        Object o = e.get(id.valor);
        if(o!=null)
        {
            if(o instanceof Arreglo){
                Object val = valor.getValor(e);
                if(val==null)
                {
                    System.out.println("Error!! al calcular el valor para asignacion a arreglo: " + id.valor + ", linea: " + linea);
                    return null;
                }
                if(((Arreglo) o).tipo.get().equals(valor.getTipo(e).get()))
                {
                    ((Arreglo) o).set(getListaDeIndices(e), val);
                }
                else
                {
                    //Si los tipos no son iguales realizo las validaciones para el casteo implicito
                    CastImplicito ci = new CastImplicito(linea, ((Arreglo) o).tipo, valor.getTipo(e), val);
                    if(!ci.getTipo(e).isNull())
                    {
                        ((Arreglo) o).set(getListaDeIndices(e), ci.getValor(e));
                    }
                    else
                    {
                        //Si no cumple con las condiciones de casteo implicito
                        System.out.println("Error!! No se puede asigar un tipo: " + valor.getTipo(e).get() 
                                + " a un tipo " + ((Arreglo) o).tipo.get() + " en la variable: " + id.valor 
                                + " en linea: " + linea);
                    }
                }
            }
            else
            {
                System.out.println("Error!! la variable: " + id.valor + " no es un arreglo, linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! no se puede acceder al id: " + id.valor + ", linea: " + linea);
        }
        return null;
    }
    
    private LinkedList<Integer> getListaDeIndices(Entorno e){
        LinkedList<Integer> tamaños_de_dimensiones = new LinkedList<>();
        for(Expresion exp: indices)
        {
            Object val = exp.getValor(e);
            if(val!=null)
            {
                Tipo t = exp.getTipo(e);
                if(t.isInt())
                {
                    tamaños_de_dimensiones.add((int)val);
                }
                else
                {
                    //Si los tipos no son iguales realizo las validaciones para el casteo implicito
                    CastImplicito ci = new CastImplicito(linea, t, new Tipo(Simbolo.TipoS.INT), val);
                    if(ci.getTipo(e).isInt())
                    {
                        tamaños_de_dimensiones.add((int)ci.getValor(e));
                    }
                    else
                    {
                        System.out.println("Error!! al calcular el tamaño de las dimensiones del arreglo, no se retorno "
                            + " un tipo de dato valido, linea: " + linea);
                    }
                }
            }
            else
            {
                System.out.println("Error!! al calcular tamañao de las dimensiones del arreglo, el valor retornado al " 
                        + " evaluar la expresion es null, linea: " + linea);
            }
        }
        return tamaños_de_dimensiones;
    }
    
}
