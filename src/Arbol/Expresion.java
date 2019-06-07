package Arbol;

public abstract class Expresion extends Nodo{
    public abstract Object getValor(Entorno e);
    public abstract Tipo getTipo(Entorno e);
}
