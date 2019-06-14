package Arbol;

import java.util.HashMap;

public class Entorno {
    public Entorno padre;
    public HashMap <String,Simbolo> tabla;
    
    public Entorno(){
        padre=null;
        tabla = new HashMap<>();
    }
    
    public Entorno(Entorno padre){
        this.padre = padre;
        this.tabla = new HashMap<>();
    }
    
    public Simbolo get(String id){
        for(Entorno e=this; e!=null; e=e.padre){
            Simbolo encontrado = e.tabla.get(id);
            if(encontrado!=null){
                return encontrado;
            }
        }
        return null;
    }
    
    public Entorno getGlobal(){
        Entorno e = this;
        while(e.padre != null){
            e=e.padre;
        }
        return e;
    }
    
    public void set(String id, Simbolo simbolo){
        this.tabla.put(id, simbolo);
    }
}
