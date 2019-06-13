package Arbol;

import java.util.LinkedList;

public class NodoArreglo {
    public LinkedList<NodoArreglo> hijos;
    public Object valor;

    public NodoArreglo(LinkedList<NodoArreglo> hijos, Object valor) {
        this.hijos = hijos;
        this.valor = valor;
    }
    
    public NodoArreglo(){
        this.hijos = new LinkedList<>();
        this.valor = null;
    }
    
    public NodoArreglo(Object valor){
        this.valor = valor;
    }
    
    public void inicializarNodo(int cant_dimensiones, int dim_actual, LinkedList<Integer> tam_dims, Tipo tipo)
    {
        if(dim_actual>cant_dimensiones){
            return;
        }
        for(int i=0; i<tam_dims.get(dim_actual-1); i++){
            NodoArreglo arr = new NodoArreglo();
            if(tipo.isInt())
                arr.valor = 0;
            else if(tipo.isDouble())
                arr.valor = 0.0;
            else if(tipo.isString())
                arr.valor = "";
            else if(tipo.isChar())
                arr.valor = 'a';
            else if(tipo.isBoolean())
                arr.valor = false;
            this.hijos.add(arr);
            arr.inicializarNodo(cant_dimensiones, dim_actual+1, tam_dims, tipo);
        }
    }
    
    /**
     * Método que configura cierto valor en una celda específica del arreglo
     * @param cantIndices Cantidad de indices que se reciben para el acceso al arreglo
     * @param indiceActual Indice que se está analizando en la propagación actual
     * @param indices Lista de los indices con los que se accederá al arreglo para asignar el valor
     * @param val Valor que se le quiere asignar a cierta celda del arreglo
     * @param id Identificador del arreglo
     */
    public void setValor(int cantIndices, int indiceActual, LinkedList<Integer> indices, Object val, String id){
        int valIndiceActual=indices.get(indiceActual-1);
        if(valIndiceActual<this.hijos.size() && valIndiceActual>=0){
            NodoArreglo arr=this.hijos.get(valIndiceActual);
            if(indiceActual==cantIndices){
                arr.valor=val;
            }else{
                arr.setValor(cantIndices, indiceActual+1, indices, val, id);
            }
        }else{
            System.out.println("La asignación al arreglo "+id+" no puede "
                    + "realizarse porque uno o más de los indices exceden "
                    + "los límites del arreglo.");
        }
    }
    
    /**
     * Método que recoge cierto valor en una celda específica del arreglo y 
     * devuelve nulo cuando no lo encuentra
     * @param cantIndices Cantidad de indices que se reciben para el acceso al arreglo
     * @param indiceActual Indice que se está analizando en la propagación actual
     * @param indices Lista de los indices con los que se accederá al arreglo para asignar el valor
     * @param id Identificador del arreglo
     * @return El valor almacenado por la celda específica o null en caso no lo encuentre
     */
    Object getValor(int cantIndices, int indiceActual, LinkedList<Integer> indices, String id) {
        int valIndiceActual=indices.get(indiceActual-1);
        if(valIndiceActual<this.hijos.size() && valIndiceActual>=0){
            NodoArreglo arr=this.hijos.get(valIndiceActual);
            if(indiceActual==cantIndices){
                return arr.valor;
            }else{
                return arr.getValor(cantIndices, indiceActual+1, indices, id);
            }
        }else{
            System.out.println("El acceso al arreglo "+id+" no puede "
                    + "realizarse porque uno o más de los indices exceden "
                    + "los límites del arreglo.");
        }
        return null;
    }
    
}
