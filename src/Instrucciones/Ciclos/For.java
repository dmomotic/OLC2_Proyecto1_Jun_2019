package Instrucciones.Ciclos;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Nodo;
import Arbol.Tipo;
import CambioFlujo.Break;
import CambioFlujo.Continue;
import CambioFlujo.Return;
import java.util.LinkedList;

public class For extends Instruccion{

    Instruccion dec_asig_inicial;
    Expresion condicion;
    Nodo cambio_for;
    LinkedList<Nodo> instrucciones;

    public For(int linea, Instruccion dec_asig_inicial, Expresion condicion, Nodo cambio_for, LinkedList<Nodo> instrucciones) {
        this.linea = linea;
        this.dec_asig_inicial = dec_asig_inicial;
        this.condicion = condicion;
        this.cambio_for = cambio_for;
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(dec_asig_inicial!=null)
        {
            if(condicion!=null)
            {
                Tipo tipo_condicion = condicion.getTipo(e);
                if(tipo_condicion.isBoolean())
                {
                    if(cambio_for!=null)
                    {
                        //Creo el entorno auxiliar que utilizo para mantener el contador inicial
                        Entorno e_aux = new Entorno(e);
                        //Establezco el contador inicial
                        dec_asig_inicial.ejecutar(e_aux);
                        //Ejecucion de instrucciones en el for
                        while((boolean)condicion.getValor(e_aux)){
                            //Creacion de entorno para las instrucciones dentro del for
                            Entorno nuevo = new Entorno(e_aux);
                            //Ejecucucion de las instrucciones en el for
                            for(Nodo n: instrucciones){
                                if(n instanceof Instruccion){
                                    //Ejecucion de instrucciones
                                    Object aux = ((Instruccion) n).ejecutar(nuevo);
                                    //Validacion de instruccion Break
                                    if(aux instanceof Break){
                                        return null;
                                    }
                                    //Validacion de instruccion Continue
                                    else if(aux instanceof Continue){
                                        break;
                                    }
                                }
                                else if(n instanceof Expresion){
                                    Object aux = ((Expresion) n).getValor(nuevo);
                                    //Validacion de expresion Return
                                    if(aux instanceof Return){
                                        return aux;
                                    }
                                }
                            }
                            //Ejecucion del cambio del contador en el for
                            if(cambio_for instanceof Instruccion)
                                ((Instruccion)cambio_for).ejecutar(e_aux);
                            else if(cambio_for instanceof Expresion)
                                ((Expresion)cambio_for).getValor(e_aux);
                        }
                    }
                    else
                    {
                        System.out.println("Error!! la instruccion de cambio en el for es null, linea: " + linea);
                    }
                }
                else
                {
                    System.out.println("Error!! la condicion que detiene al for no es de tipo boolean, linea: " + linea);
                }
            }
            else
            {
                System.out.println("Error!! la condicion que detiene al for es null, linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! el contador inicial es null en el for, linea: " + linea);
        }
        return null;
    }
    
}
