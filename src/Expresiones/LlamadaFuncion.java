package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Funcion;
import Arbol.Instruccion;
import Arbol.Nodo;
import Arbol.Simbolo;
import Arbol.Tipo;
import CambioFlujo.Return;
import java.util.LinkedList;

public class LlamadaFuncion extends Expresion{
    
    Identificador id;
    LinkedList<Expresion> parametros;

    public LlamadaFuncion(int linea, Identificador id, LinkedList<Expresion> parametros) {
        this.linea = linea;
        this.id = id;
        this.parametros = parametros;
    }
    
    public LlamadaFuncion(int linea, Identificador id) {
        this.linea = linea;
        this.id = id;
    }
    
    @Override
    public Object getValor(Entorno e) {
        Simbolo s = e.get(id.valor);
        if(s==null)
        {
            System.out.println("Error!! No existe la funcion: " + id.valor + ", linea: " + linea);
            return null;
        }
        
        if(s instanceof Funcion == false){
            System.out.println("Error!! el id: " + id.valor + " no es de tipo funcion, linea: " + linea);
            return null;
        }
        
        if(((Funcion)s).parametros!=null && parametros!=null && ((Funcion)s).parametros.size() != parametros.size()){
            System.out.println("Error!! la cantidad de parametros enviados en la funcion: " + id.valor 
                    + ", no conciden, linea: " + linea);
            return null;
        }
        
        if(((Funcion)s).parametros==null && parametros != null){
            System.out.println("Error!! la funcion: " + id.valor + " no recibe ningun parametro, linea: " + linea);
            return null;
        }
        
        if(((Funcion)s).parametros!=null && parametros == null){
            System.out.println("Error!! la funcion: " + id.valor + " debe recibir: " + ((Funcion)s).parametros.size() 
                + " parametros, linea: " + linea);
            return null;
        }
        
        //Ejecucion de la funcion 
        //Declaro el nuevo entorno que apunta unicamente al global
        Entorno nuevo = new Entorno(e.getGlobal());
        //Con parametros
        if(parametros!=null){
            //Declaro los parametros como variables locales
            for(int i=0; i<parametros.size(); i++){
                Simbolo p = ((Funcion)s).parametros.get(i);
                Object aux = parametros.get(i).getValor(e);
                nuevo.set(p.id, new Simbolo(p.tipo, p.id, aux));
            }
            /*
            for(Simbolo p: ((Funcion)s).parametros){
                nuevo.set(p.id, new Simbolo(p.tipo, p.id, parametros.removeFirst().getValor(nuevo)));
            }*/

            //Ejecuto las instrucciones
            for(Nodo n: ((Funcion)s).instrucciones){
                if(n instanceof Instruccion)
                {
                    //Verifico si la ejecucion de la instrucciones es un return
                    Object aux = ((Instruccion) n).ejecutar(nuevo);
                    if(aux instanceof Return){
                        //Si es un return ejecuto su expresion y capturo la instancia del Return
                        Object ob = ((Return)aux).getValor(nuevo);
                        //Capturo el valor retornado
                        if(ob instanceof Return){
                            return ((Return) ob).val;
                        }
                    }
                }
                else if(n instanceof Expresion){
                    if(n instanceof Return){
                        Object ob = ((Return)n).getValor(nuevo);
                        //Capturo el valor retornado
                        if(ob instanceof Return){
                            return ((Return) ob).val;
                        }
                    }
                    else{
                        ((Expresion) n).getValor(nuevo);
                    }
                }
            }
        }
        
        return null;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        Simbolo s = e.get(id.valor);
        if(s!=null)
            return s.tipo;
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
