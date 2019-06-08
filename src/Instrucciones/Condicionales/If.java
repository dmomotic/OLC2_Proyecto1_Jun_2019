package Instrucciones.Condicionales;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Nodo;
import CambioFlujo.Break;
import java.util.LinkedList;

public class If extends Instruccion{

    Expresion condicion;
    LinkedList<Nodo> instrucciones;
    LinkedList<If> else_ifs;
    If _else;

    public If(int linea, Expresion condicion, LinkedList<Nodo> instrucciones, LinkedList<If> else_ifs, If _else) {
        this.linea = linea;
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.else_ifs = else_ifs;
        this._else = _else;
    }
    
    public If(int linea, Expresion condicion, LinkedList<Nodo> instrucciones) {
        this.linea = linea;
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }
    
    public If(int linea, Expresion condicion, LinkedList<Nodo> instrucciones, LinkedList<If> else_ifs) {
        this.linea = linea;
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.else_ifs = else_ifs;
    }
    
    public If(int linea, Expresion condicion, LinkedList<Nodo> instrucciones, If _else) {
        this.linea = linea;
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this._else = _else;
    }
    
    public If(int linea, LinkedList<Nodo> instrucciones){
        this.linea = linea;
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(condicion!=null){
            //Bandera para saber si ya se ejecuto algun if, para que no evalue el resto
            boolean ejecutado = false;
            Object val_cond = condicion.getValor(e);
            //Verifico las acciones para el If
            if((boolean)val_cond){
                Entorno nuevo = new Entorno(e);
                for(Nodo n: instrucciones){
                    if(n instanceof Instruccion){
                        //Ejecucion de instrucciones
                        Object aux = ((Instruccion) n).ejecutar(nuevo);
                        //Validacion de instruccion Break
                        if(aux instanceof Break){
                            return (Break)aux;
                        }
                    }
                    else if(n instanceof Expresion){
                        ((Expresion) n).getValor(nuevo);
                    }
                }
            }
            else
            {
                //Verifico las acciones para lista de else if
                if(else_ifs!=null){
                    for(If _if: else_ifs){
                        Object val = _if.condicion.getValor(e);
                        if((boolean)val){
                            Entorno nuevo = new Entorno(e);
                            for(Nodo n:_if.instrucciones){
                                if(n instanceof Instruccion){
                                    //Ejecucion de instrucciones
                                    Object aux = ((Instruccion) n).ejecutar(nuevo);
                                    //Validacion de instruccion Break
                                    if(aux instanceof Break){
                                        return (Break)aux;
                                    }
                                }
                                else if(n instanceof Expresion){
                                    ((Expresion) n).getValor(nuevo);
                                }
                            }
                            ejecutado = true;
                            break;
                        }
                    }
                }
                //Verifico las acciones para el else
                if(_else!=null && !ejecutado){
                    Entorno nuevo = new Entorno(e);
                    for(Nodo n:_else.instrucciones){
                        if(n instanceof Instruccion){
                            //Ejecucion de instrucciones
                            Object aux = ((Instruccion) n).ejecutar(nuevo);
                            //Validacion de instruccion Break
                            if(aux instanceof Break){
                                return (Break)aux;
                            }
                        }
                        else if(n instanceof Expresion){
                            ((Expresion) n).getValor(nuevo);
                        }
                    }  
                }
            }
        }
        else
        {
            System.out.println("Error!! La condicion es null en el if de la linea: " + linea);
        }
        return null;
    }
    
}
