package Arbol;

import java.util.LinkedList;

public class Arreglo extends Simbolo{
    
    int dimensiones;
    LinkedList<Integer> tamaños_dimensiones;
    
    public Arreglo(Tipo tipo, String id, Object valor) {
        super(tipo, id, valor);
    }
    
    public Arreglo(Tipo tipo, String id) {
        super(tipo, id);
    }
    
    public Arreglo(Tipo tipo, String id, int dimensiones, LinkedList<Integer> tamaños_dimensiones){
        super(tipo, id);
        this.dimensiones = dimensiones;
        this.tamaños_dimensiones = tamaños_dimensiones;
    }
    
    public void inicializar(){
        NodoArreglo raiz = new NodoArreglo();
        raiz.inicializarNodo(dimensiones, 1, tamaños_dimensiones,tipo);
        this.valor = raiz;
    }
    
    public void set(LinkedList<Integer> indices, Object val)
    {
        ((NodoArreglo)valor).setValor(indices.size(), 1, indices, val, id);
    }
    
    public Object get(LinkedList<Integer> indices)
    {
        return ((NodoArreglo)valor).getValor(indices.size(), 1, indices, id);
    }
    
}
