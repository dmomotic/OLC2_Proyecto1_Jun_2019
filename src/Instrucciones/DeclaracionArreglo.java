package Instrucciones;

import Arbol.Arreglo;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.CastImplicito;
import java.util.LinkedList;

public class DeclaracionArreglo extends Instruccion{

    //Obligatorios
    Tipo tipo_declarado;
    LinkedList<String> variables;
    int numero_dimensiones;
    //Utilizados en la instanciacion de un arreglo
    Tipo tipo_asignado;
    LinkedList<Expresion> tamaños_dimensiones;

    public DeclaracionArreglo(int linea, Tipo tipo_declarado, LinkedList<String> variables, int numero_dimensiones, Tipo tipo_asignado, LinkedList<Expresion> tamaños_dimensiones) {
        this.linea = linea;
        this.tipo_declarado = tipo_declarado;
        this.variables = variables;
        this.numero_dimensiones = numero_dimensiones;
        this.tipo_asignado = tipo_asignado;
        this.tamaños_dimensiones = tamaños_dimensiones;
    }
    
    public DeclaracionArreglo(int linea, Tipo tipo_declarado, LinkedList<String> variables, int numero_dimensiones) {
        this.linea = linea;
        this.tipo_declarado = tipo_declarado;
        this.variables = variables;
        this.numero_dimensiones = numero_dimensiones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(tipo_declarado!=null && variables!=null){
            //Declaraciones tipo int arreglo[][][] = new int[5+3][2*1][3-5];
            if(tipo_asignado != null && tipo_declarado.get().equals(tipo_asignado.get()))
            {
                if(tamaños_dimensiones != null)
                {
                    //Valido que el tamaño de dimensiones coincida
                    if(tamaños_dimensiones.size()!=numero_dimensiones)
                    {
                        System.out.println("Error!! Los tamaños de las dimensiones en el arreglo no coinciden, linea: " 
                                + linea);
                        return null;
                    }
                    //Recorro la lista de ids
                    for(String id: variables)
                    {
                        //Si no existe la variable en el entorno
                        if(e.get(id)==null)
                        {   
                            //Si es la ultima variable de la lista, le asigno el valor
                            if(variables.getLast().equals(id))
                            {
                                //Registro el arreglo en el entorno
                                Arreglo a = new Arreglo(tipo_asignado, id, numero_dimensiones, getTamañosDeDimensiones(e));
                                a.inicializar();
                                e.set(id, a);
                            }
                            else
                            {
                                //Registro el id en el entorno
                                Simbolo simbolo = new Simbolo(tipo_declarado, id); 
                                e.set(id, simbolo);
                            }
                        }
                        //Si ya existe la variable en el entorno
                        else
                        {
                            System.out.println("Error!! no se puede declarar la variable: " + id 
                                    + " porque ya existe en este entorno, linea:  " + linea);
                        }
                    }
                }
                else
                {
                    System.out.println("Error!! el tamaño de las dimensiones del arreglo es null, linea: " + linea);
                }
            }
            else
            {
                System.out.println("Error!! el tipo que se le asigna al arreglo durante su instanciacion es invalido, linea: " 
                        + linea);
            }
        }
        else
        {
            System.out.println("Error!! en la declaracion del arreglo, ya que l tipo declarado o su id es null, linea: " 
                    + linea);
        }
        return null;
    }
    
    private LinkedList<Integer> getTamañosDeDimensiones(Entorno e){
        LinkedList<Integer> tamaños_de_dimensiones = new LinkedList<>();
        for(Expresion exp: tamaños_dimensiones)
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
