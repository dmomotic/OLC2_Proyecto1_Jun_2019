package Expresiones;

import Arbol.Arreglo;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;
import java.util.LinkedList;

public class AccesoArreglo extends Expresion{

    Identificador id;
    public LinkedList<Expresion> indices;
    //Auxiliar para identificar si es un acceso al valor o acceso al nodo
    public boolean es_acceso_a_nodo;

    public AccesoArreglo(int linea, Identificador id, LinkedList<Expresion> indices) {
        this.linea = linea;
        this.id = id;
        this.indices = indices;
    }
    
    public AccesoArreglo(int linea, Identificador id, LinkedList<Expresion> indices, boolean es_acceso_a_nodo) {
        this.linea = linea;
        this.id = id;
        this.indices = indices;
        this.es_acceso_a_nodo = es_acceso_a_nodo;
    }
    
    @Override
    public Object getValor(Entorno e) {
        Object o = e.get(id.valor);
        if(o!=null){
            if(o instanceof Arreglo){
                if(!es_acceso_a_nodo){
                    return ((Arreglo) o).get(getListaDeIndices(e));
                }
                else
                {
                    return ((Arreglo) o).getNodo(getListaDeIndices(e));
                }
            }
            else
            {
                System.out.println("Error!! la variable: " + id.valor + " no es un arreglo, linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! No se efecuto el acceso al arreglo: " + id.valor + ", linea: " + linea);
        }
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return this.id.getTipo(e);
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
