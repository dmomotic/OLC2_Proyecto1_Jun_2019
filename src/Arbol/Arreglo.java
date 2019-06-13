package Arbol;

import java.util.LinkedList;

public class Arreglo extends Simbolo{
    
    public int dimensiones;
    public LinkedList<Integer> tamaños_dimensiones;
    
    public Arreglo(Tipo tipo, String id, Object valor) {
        super(tipo, id, valor);
    }
    
    public Arreglo(Tipo tipo, String id, Object valor, int dimensiones)
    {
        super(tipo, id, valor);
        this.dimensiones = dimensiones;
    }
    
    public Arreglo(Tipo tipo, String id, int dimensiones) {
        super(tipo, id);
        this.dimensiones = dimensiones;
    }
    
    public Arreglo(Tipo tipo, String id, int dimensiones, LinkedList<Integer> tamaños_dimensiones){
        super(tipo, id);
        this.dimensiones = dimensiones;
        this.tamaños_dimensiones = tamaños_dimensiones;
    }
    
    public void inicializar(){
        //Para declaraciones sin asignacion
        if(tamaños_dimensiones == null){
            this.valor = new NodoArreglo();
            return;
        }
        //Para declaraciones con asignacion
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
