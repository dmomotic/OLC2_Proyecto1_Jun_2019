package Instrucciones;

import Arbol.Arreglo;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.NodoArreglo;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.CastImplicito;
import Expresiones.Identificador;
import java.util.LinkedList;

public class InicializacionArreglo extends Instruccion{

    Identificador id;
    Tipo tipo_a_asignar;
    LinkedList<Expresion> tamaños_dimensiones;
    //Utilizado para la asignacion de arreglos con llaves
    LinkedList<Object> valores;

    public InicializacionArreglo(int linea, Identificador id, LinkedList<Object> valores){
        this.linea = linea;
        this.id = id;
        this.valores = valores;
    }
    
    public InicializacionArreglo(int linea, Identificador id, Tipo tipo_a_asignar, LinkedList<Expresion> tamaños_dimensiones) {
        this.linea = linea;
        this.id = id;
        this.tipo_a_asignar = tipo_a_asignar;
        this.tamaños_dimensiones = tamaños_dimensiones;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        Object o = e.get(id.valor);
        if(o==null)
        {
            System.out.println("Error!! no se puede encontrar la variable: " + id.valor +", linea: " + linea);
            return null;
        }
        
        if(!(o instanceof Arreglo))
        {
            System.out.println("Error!! la variable: " + id.valor + " no es de tipo arreglo para realizar la asignacion, linea: " 
                    + linea);
            return null;
        }
        
        //Para asignaciones con corchetes
        if(tamaños_dimensiones!=null && valores == null){
            LinkedList<Integer> lst_tam_dim = getTamañosDeDimensiones(e);
            if(((Arreglo)o).dimensiones != lst_tam_dim.size())
            {
                System.out.println("Error!! la cantidad de dimensiones no coinciden en la asignacion del arreglo: " + id.valor
                    + ", linea: " + linea);
                return null;
            }
            ((Arreglo)o).tamaños_dimensiones = lst_tam_dim;
            ((Arreglo)o).inicializar();
        }

        //Para asignaciones con llaves
        else if(tamaños_dimensiones==null && valores !=null){
            if(estoyBalanceado(valores))
            {
                LinkedList<Integer> tams_dims_en_arbol = new LinkedList<>();
                setTamañosDeDimensionesEnArbol(valores, tams_dims_en_arbol);
                if(tams_dims_en_arbol.size() == ((Arreglo)o).dimensiones){
                    NodoArreglo raiz = new NodoArreglo();
                    recorrer(valores, e, raiz);
                    Arreglo arr = new Arreglo(id.getTipo(e), id.valor, raiz,tams_dims_en_arbol.size());
                    e.set(id.valor, arr);
                }
                else
                {
                    System.out.println("Error!! no se puede asignar el arbol porque las cantidad de dimensiones enviada: " 
                            + tams_dims_en_arbol + ", no coinciden con la cantidad de dimensiones del arreglo: " + ((Arreglo)o).dimensiones
                            + ", linea: " + linea);
                }
            }
            else
            {
                System.out.println("Error!! el arbol no se puede asignar ya que creo que no esta balanceado, linea: " + linea);;
            }
        }
        return null;
    }
    
    private LinkedList<Integer> getTamañosDeDimensiones(Entorno e){
        LinkedList<Integer> tamaños_de_dimensiones = new LinkedList<>();
        for(Expresion exp: tamaños_dimensiones)
        {
            Object val = exp.getValor(e);
            if(val!=null)
            {
                Tipo t = exp.getTipo(e);
                if(t.isInt())
                {
                    tamaños_de_dimensiones.add((int)val);
                }
                else
                {
                    //Si los tipos no son iguales realizo las validaciones para el casteo implicito
                    CastImplicito ci = new CastImplicito(linea, t, new Tipo(Simbolo.TipoS.INT), val);
                    if(ci.getTipo(e).isInt())
                    {
                        tamaños_de_dimensiones.add((int)ci.getValor(e));
                    }
                    else
                    {
                        System.out.println("Error!! al calcular el tamaño de las dimensiones del arreglo, no se retorno "
                            + " un tipo de dato valido, linea: " + linea);
                    }
                }
            }
            else
            {
                System.out.println("Error!! al calcular tamañao de las dimensiones del arreglo, el valor retornado al " 
                        + " evaluar la expresion es null, linea: " + linea);
            }
        }
        return tamaños_de_dimensiones;
    }
    
    private boolean aux_estoyBalanceado(LinkedList<Object> vals){
        for(int i=0; i<vals.size(); i++){
            if(i>0 && vals.get(i) instanceof LinkedList && vals.get(i-1) instanceof LinkedList)
            {
                if(((LinkedList)vals.get(i)).size() != ((LinkedList)vals.get(i-1)).size() )
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean estoyBalanceado(LinkedList<Object> vals){
        for(Object o: vals)
        {
            if(o instanceof LinkedList)
            {
                if(aux_estoyBalanceado(vals))
                {
                    return estoyBalanceado(((LinkedList)o));
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void setTamañosDeDimensionesEnArbol(LinkedList<Object> vals, LinkedList<Integer>dimensiones){
        dimensiones.add(vals.size());
        if(vals.getFirst() instanceof LinkedList)
        {
            setTamañosDeDimensionesEnArbol((LinkedList)vals.getFirst(), dimensiones);
        }
    }
    
    public void recorrer(LinkedList<Object> vals, Entorno e, NodoArreglo actual)
    {
        for(Object o: vals)
        {
            if(o instanceof LinkedList)
            {
                actual.hijos.add(new NodoArreglo());
                recorrer((LinkedList)o, e, actual.hijos.getLast());
            }
            else
            {
                if(o instanceof Expresion)
                {
                    Tipo tipo_dato = ((Expresion) o).getTipo(e);
                    Object valor_dato = ((Expresion) o).getValor(e);
                    //Si el tipo del arreglo y el tipo de dato a asignar son iguales
                    if(id.getTipo(e).get().equals(tipo_dato.get()))
                    {
                        actual.hijos.add(new NodoArreglo(valor_dato));
                    }
                    else
                    {
                        //Si no son iguales verifico si se es un cast implicito
                        CastImplicito ci = new CastImplicito(linea, id.getTipo(e), tipo_dato, valor_dato);
                        if(!ci.getTipo(e).isNull())
                        {
                            actual.hijos.add(new NodoArreglo(ci.getValor(e)));
                        }
                        else
                        {
                            System.out.println("Error!! no se puede asignar un tipo de dato: " + tipo_dato.get() 
                                    + " a un arreglo tipo: " + id.getTipo(e).get() + ", linea: " + linea);
                        }
                    }
                }
            }
        }
    }
   
}
