package Instrucciones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Nodo;
import java.util.LinkedList;

public class Bloque extends Instruccion{

    LinkedList<Nodo> instrucciones;

    public Bloque(LinkedList<Nodo> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(instrucciones!=null)
        {
            Entorno nuevo = new Entorno(e);
            for(Nodo n: instrucciones)
            {
                if(n instanceof Instruccion)
                    ((Instruccion) n).ejecutar(nuevo);
                else if(n instanceof Expresion)
                    ((Expresion) n).getValor(nuevo);
            }
        }
        else
        {
            System.out.println("Error!! al ejecutar las instrucciones del bloque");
        }
        return null;
    }
    
}
