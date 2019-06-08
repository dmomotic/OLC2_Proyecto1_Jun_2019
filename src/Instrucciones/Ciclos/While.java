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

public class While extends Instruccion{

    Expresion condicion;
    LinkedList<Nodo> instrucciones;

    public While(int linea, Expresion condicion, LinkedList<Nodo> instrucciones) {
        this.linea = linea;
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(condicion!=null){
            Object val = condicion.getValor(e);
            Tipo t = condicion.getTipo(e);
            if(t.isBoolean())
            {
                if(val!=null)
                {
                    //Ejecucion del ciclo while
                    while((boolean)condicion.getValor(e)){
                        Entorno nuevo = new Entorno(e);
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
                    }
                }
                else
                {
                    System.out.println("Error!! No se puede ejecutar el while ya que al evaluar su expresion, retorno " 
                            + "null en linea: " + linea);
                }
            }
            else
            {
                System.out.println("Error!! No se puede ejecutar el while ya que su expresion retorna un tipo " + t.get()
                        + " en la linea: " + linea); 
            }
        }
        else
        {
            System.out.println("Error!! No se puede ejecutar el while ya que su expresion es NULL en linea: " + linea);
        }
        return null;
    }
    
}
