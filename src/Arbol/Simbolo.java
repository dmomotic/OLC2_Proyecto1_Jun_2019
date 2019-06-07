package Arbol;

public class Simbolo {
    
    public enum TipoS{
        INT,CHAR,STRING,DOUBLE,BOOLEAN,NULL
    }

    public Tipo tipo;
    public String id;
    public Object valor;
    
    public Simbolo(Tipo tipo, String id, Object valor){
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
    }
    
    public Simbolo(Tipo tipo, String id){
        this.tipo = tipo;
        this.id = id;
    }
    
}
