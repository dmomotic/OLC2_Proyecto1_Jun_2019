package Instrucciones;

import Arbol.Entorno;
import Arbol.Funcion;
import Arbol.Instruccion;
import Arbol.Nodo;
import Arbol.Simbolo;
import Arbol.Tipo;
import Arbol.TipoAcceso;
import Expresiones.Identificador;
import java.util.LinkedList;

public class DeclaracionFuncion extends Instruccion{

    TipoAcceso tipo_acceso;
    Tipo tipo_funcion;
    Identificador id;
    LinkedList<Simbolo> parametros;
    LinkedList<Nodo> instrucciones;

    public DeclaracionFuncion(int linea, TipoAcceso tipo_acceso, Tipo tipo_funcion, Identificador id, LinkedList<Simbolo> parametros, LinkedList<Nodo> instrucciones) {
        this.linea = linea;
        this.tipo_acceso = tipo_acceso;
        this.tipo_funcion = tipo_funcion;
        this.id = id;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
    }
    
    public DeclaracionFuncion(int linea, TipoAcceso tipo_acceso, Tipo tipo_funcion, Identificador id, LinkedList<Nodo> instrucciones) {
        this.linea = linea;
        this.tipo_acceso = tipo_acceso;
        this.tipo_funcion = tipo_funcion;
        this.id = id;
        this.instrucciones = instrucciones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(id==null)
        {
            System.out.println("Error!! el identificador es null, al declarar una funcion en linea: " + linea);
            return null;
        }
        
        if(tipo_funcion==null)
        {
            System.out.println("Error!! el tipo en la funcion: " + id.valor + " es null, en linea: " + linea);
            return null;
        }
        
        if(instrucciones==null)
        {
            System.out.println("Error!! las instrucciones en la fucnion: " + id.valor + " son null, en linea: " + linea);
            return null;
        }
        
        //Si ya existe la funcion en el entorno es un error
        if(e.get(id.valor)!=null)
        {
            System.out.println("Error!! ya existe una funcion con nombre: " + id.valor + " en este ambito, linea: " + linea);
            return null;
        }
        
        Funcion f;
        //Funcion con parametros
        if(parametros!=null)
        {
            f = new Funcion(tipo_acceso, tipo_funcion, id.valor, parametros, instrucciones);
            
        }
        //Funcion sin parametros
        else
        {
            f = new Funcion(tipo_acceso, tipo_funcion, id.valor, instrucciones);
        }
        e.set(id.valor,f);
        
        return null;
    }
    
}
