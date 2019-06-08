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

public class DoWhile extends Instruccion{

    LinkedList<Nodo> instrucciones;
    Expresion valor;
    
    public DoWhile(int linea, LinkedList<Nodo> instrucciones, Expresion valor){
        this.linea = linea;
        this.instrucciones = instrucciones;
        this.valor = valor;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(valor!=null){
            Object val = valor.getValor(e);
            Tipo tipo = valor.getTipo(e);
            if(val!=null)
            {
                if(tipo.isBoolean()){
                    //Ejecucion do while
                    do{
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
                    }while((boolean)valor.getValor(e));
                }
                else
                {
                    System.out.println("Error!! al evaluar la expresion en do while no retorna un tipo booleano, linea: " 
                            + valor.linea);
                }
            }
            else
            {
                System.out.println("Error!! al evaluar la expresion en do while retorno null, linea: " + valor.linea);
            }
        }
        else
        {
            System.out.println("Error!! al ejecutar do while, el valor de su expresion es null, linea: " + linea);
        }
        return null;
    }
    
}
