package Arbol;

public class Tipo {
    public Simbolo.TipoS tp;
    public String tr;
    
    public Tipo(Simbolo.TipoS tipo){
        this.tp = tipo;
    }
    
    public Tipo(String tipo){
        this.tr = tipo;
    }
    
    public boolean isChar(){
        return tp.equals(Simbolo.TipoS.CHAR);
    }
    
    public boolean isInt(){
        return tp.equals(Simbolo.TipoS.INT);
    }
    
    public boolean isNull(){
        return tp.equals(Simbolo.TipoS.NULL);
    }
    
    public boolean isNumeric(){
        return tp.equals(Simbolo.TipoS.CHAR) || tp.equals(Simbolo.TipoS.INT);
    }
    
    public boolean isDouble(){
        return tp.equals(Simbolo.TipoS.DOUBLE);
    }
    
    public boolean isBoolean(){
        return tp.equals(Simbolo.TipoS.BOOLEAN);
    }
    
    public boolean isString(){
        return tp.equals(Simbolo.TipoS.STRING);
    }
    
    public boolean isPrimitivo(){
        return tp == null;
    }
    
    public Object get(){
        return tp!=null?tp:tr;
    }
}
