package Instrucciones.Condicionales;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Nodo;
import CambioFlujo.Break;
import CambioFlujo.Return;
import java.util.LinkedList;

public class Case extends Instruccion{
    
    Expresion valor;
    LinkedList<Nodo> instrucciones;
    boolean isDefault;

    public Case(int linea, Expresion valor, LinkedList<Nodo> instrucciones) {
        this.linea = linea;
        this.valor = valor;
        this.instrucciones = instrucciones;
    }
    
    public Case(int linea, LinkedList<Nodo> instrucciones, boolean isDefault) {
        this.linea = linea;
        this.instrucciones = instrucciones;
        this.isDefault = isDefault;
    }

    @Override
    public Object ejecutar(Entorno e) {
        Entorno nuevo = new Entorno(e);
        for(Nodo n: instrucciones){
            if(n instanceof Instruccion)
            {
                Object aux = ((Instruccion) n).ejecutar(nuevo);
                //Validacion de instruccion Break
                if(aux instanceof Break){
                    return aux;
                }
            }
            else if(n instanceof Expresion)
            {
                Object aux = ((Expresion) n).getValor(nuevo);
                //Validacion de instruccion Return
                if(aux instanceof Return){
                    return aux;
                }
            }
        }
        return null;
    }
    
}
