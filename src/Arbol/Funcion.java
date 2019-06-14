package Arbol;

import java.util.LinkedList;

public class Funcion extends Simbolo{
    
    public TipoAcceso acceso;
    public LinkedList<Nodo> instrucciones;
    public LinkedList<Simbolo> parametros;
    
    public Funcion(TipoAcceso acceso, Tipo tipo, String id, LinkedList<Simbolo> parametros, LinkedList<Nodo> instrucciones) {
        super(tipo, id);
        this.acceso = acceso;
        this.instrucciones = instrucciones;
        this.parametros = parametros;
    }
    
    public Funcion(TipoAcceso acceso, Tipo tipo, String id, LinkedList<Nodo> instrucciones) {
        super(tipo, id);
        this.acceso = acceso;
        this.instrucciones = instrucciones;
    }
    
    public Funcion(Tipo tipo, String id, LinkedList<Nodo> instrucciones) {
        super(tipo, id);
        //Asignar tipo de acceso por defecto
        this.instrucciones = instrucciones;
    }
    
    public Funcion(Tipo tipo, String id, LinkedList<Simbolo> parametros, LinkedList<Nodo> instrucciones) {
        super(tipo, id);
        //Asignar tipo de acceso por defecto
        this.instrucciones = instrucciones;
        this.parametros = parametros;
    }
    
    
    
    
    
    
    
}
