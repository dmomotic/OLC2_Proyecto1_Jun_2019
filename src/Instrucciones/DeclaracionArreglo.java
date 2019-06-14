package Instrucciones;

import Arbol.Arreglo;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.NodoArreglo;
import Arbol.Simbolo;
import Arbol.Tipo;
import Expresiones.AccesoArreglo;
import Expresiones.CastImplicito;
import java.util.LinkedList;

public class DeclaracionArreglo extends Instruccion {

    //Obligatorios
    Tipo tipo_declarado;
    LinkedList<String> variables;
    int numero_dimensiones;
    //Utilizados en la instanciacion de un arreglo
    Tipo tipo_asignado;
    LinkedList<Expresion> tamaños_dimensiones;
    //Utilizados en la instanciacion de un arreglo con llaves
    LinkedList<Object> valores;
    //Auxiliar para inidicar que es un acceso a un nodo de un arreglo
    AccesoArreglo acceso_arreglo;

    public DeclaracionArreglo(int linea, Tipo tipo_declarado, LinkedList<String> variables, int numero_dimensiones, AccesoArreglo acceso_arreglo){
        this.linea = linea;
        this.tipo_declarado = tipo_declarado;
        this.variables = variables;
        this.numero_dimensiones = numero_dimensiones;
        this.acceso_arreglo = acceso_arreglo;
        this.acceso_arreglo.es_acceso_a_nodo = true;
    }
    
    public DeclaracionArreglo(int linea, Tipo tipo_declaraado, LinkedList<String> variables, int numero_dimensiones, LinkedList<Object> valores) {
        this.linea = linea;
        this.tipo_declarado = tipo_declaraado;
        this.variables = variables;
        this.numero_dimensiones = numero_dimensiones;
        this.valores = valores;
    }

    public DeclaracionArreglo(int linea, Tipo tipo_declarado, LinkedList<String> variables, int numero_dimensiones, Tipo tipo_asignado, LinkedList<Expresion> tamaños_dimensiones) {
        this.linea = linea;
        this.tipo_declarado = tipo_declarado;
        this.variables = variables;
        this.numero_dimensiones = numero_dimensiones;
        this.tipo_asignado = tipo_asignado;
        this.tamaños_dimensiones = tamaños_dimensiones;
    }

    public DeclaracionArreglo(int linea, Tipo tipo_declarado, LinkedList<String> variables, int numero_dimensiones) {
        this.linea = linea;
        this.tipo_declarado = tipo_declarado;
        this.variables = variables;
        this.numero_dimensiones = numero_dimensiones;
    }

    @Override
    public Object ejecutar(Entorno e) {
        if (tipo_declarado != null && variables != null && valores == null && acceso_arreglo==null) {
            //Declaraciones tipo int arreglo[][][] = new int[5+3][2*1][3-5];
            if (tipo_asignado != null && tipo_declarado.get().equals(tipo_asignado.get())) {
                if (tamaños_dimensiones != null) {
                    //Valido que el tamaño de dimensiones coincida
                    if (tamaños_dimensiones.size() != numero_dimensiones) {
                        System.out.println("Error!! Los tamaños de las dimensiones en el arreglo no coinciden, linea: "
                                + linea);
                        return null;
                    }
                    //Recorro la lista de ids
                    for (String id : variables) {
                        //Si no existe la variable en el entorno
                        if (e.get(id) == null) {
                            //Si es la ultima variable de la lista, le asigno el valor
                            if (variables.getLast().equals(id)) {
                                //Registro el arreglo en el entorno
                                Arreglo a = new Arreglo(tipo_asignado, id, numero_dimensiones, getTamañosDeDimensiones(e));
                                a.inicializar();
                                e.set(id, a);
                            } else {
                                //Registro el id en el entorno
                                Simbolo simbolo = new Simbolo(tipo_declarado, id);
                                e.set(id, simbolo);
                            }
                        } //Si ya existe la variable en el entorno
                        else {
                            System.out.println("Error!! no se puede declarar la variable: " + id
                                    + " porque ya existe en este entorno, linea:  " + linea);
                        }
                    }
                } else {
                    System.out.println("Error!! el tamaño de las dimensiones del arreglo es null, linea: " + linea);
                }
            } 
            //Declaraciones tipo int arreglo[][][];
            else if (tipo_asignado == null && tamaños_dimensiones == null) {
                //Recorro la lista de ids
                for (String id : variables) {
                    //Si no existe la variable en el entorno
                    if (e.get(id) == null) {
                        //Si es la ultima variable de la lista, le asigno el valor
                        if (variables.getLast().equals(id)) {
                            //Registro el arreglo en el entorno
                            Arreglo a = new Arreglo(tipo_declarado, id, numero_dimensiones);
                            a.inicializar();
                            e.set(id, a);
                        } else {
                            //Registro el id en el entorno
                            Simbolo simbolo = new Simbolo(tipo_declarado, id);
                            e.set(id, simbolo);
                        }
                    } //Si ya existe la variable en el entorno
                    else {
                        System.out.println("Error!! no se puede declarar la variable: " + id
                                + " porque ya existe en este entorno, linea:  " + linea);
                    }
                }
            } else {
                System.out.println("Error!! el tipo que se le asigna al arreglo durante su instanciacion es invalido, linea: "
                        + linea);
            }
        } 
        //Declaraciones tipo int a[][]={{1,2},{2,3}};
        else if (tipo_declarado != null && valores != null && variables != null && acceso_arreglo==null) {
            //Recorro la lista de ids
                for (String id : variables) {
                    //Si no existe la variable en el entorno
                    if (e.get(id) == null) {
                        //Si es la ultima variable de la lista, le asigno el valor
                        if (variables.getLast().equals(id)) {
                            if(estoyBalanceado(valores))
                            {       
                                LinkedList<Integer> tams_dims_en_arbol = new LinkedList<>();
                                setTamañosDeDimensionesEnArbol(valores, tams_dims_en_arbol);
                                if(tams_dims_en_arbol.size() == numero_dimensiones){
                                    //Registro el arreglo en el entorno
                                    NodoArreglo raiz = new NodoArreglo();
                                    recorrer(valores, e, raiz);
                                    Arreglo arr = new Arreglo(tipo_declarado, id, raiz);
                                    e.set(id, arr);
                                }
                                else
                                {
                                    System.out.println("Error!! no se puede declarar el arreglo porque el tamaño de dimensiones indicado: " + numero_dimensiones
                                        + " no coincide con el numero de dimensiones del arbol generado por las llaves: " + tams_dims_en_arbol.size() 
                                        + ", linea: " + linea);
                                }
                            }
                            else
                            {
                                System.out.println("Error!! el arbol no se puede asignar ya que creo que no esta balanceado, linea: " + linea);;
                            }
                        } else {
                            //Registro el id en el entorno
                            Simbolo simbolo = new Simbolo(tipo_declarado, id);
                            e.set(id, simbolo);
                        }
                    } //Si ya existe la variable en el entorno
                    else {
                        System.out.println("Error!! no se puede declarar la variable: " + id
                                + " porque ya existe en este entorno, linea:  " + linea);
                    }
                }
           
        } 
        //Declaraciones tipo int a[]=b[exp];
        else if(tipo_declarado!=null && acceso_arreglo!=null){
            //Recorro la lista de ids
                for (String id : variables) {
                    //Si no existe la variable en el entorno
                    if (e.get(id) == null) {
                        //Si es la ultima variable de la lista, le asigno el valor
                        if (variables.getLast().equals(id)) {
                            //Capturo el valor nodo del arreglo del lado derecho
                            Object aux = acceso_arreglo.getValor(e);
                            if(aux!=null && aux instanceof NodoArreglo)
                            {
                                Arreglo arr = new Arreglo(tipo_declarado, id, aux, acceso_arreglo.indices.size());
                                e.set(id, arr);
                            }
                        }
                    }
                }
        }
        else {
            System.out.println("Error!! en la declaracion del arreglo, ya que el tipo declarado o su id es null, linea: "
                    + linea);
        }
        return null;
    }

    private LinkedList<Integer> getTamañosDeDimensiones(Entorno e) {
        LinkedList<Integer> tamaños_de_dimensiones = new LinkedList<>();
        if (valores == null) {
            for (Expresion exp : tamaños_dimensiones) {
                Object val = exp.getValor(e);
                if (val != null) {
                    Tipo t = exp.getTipo(e);
                    if (t.isInt()) {
                        tamaños_de_dimensiones.add((int) val);
                    } else {
                        //Si los tipos no son iguales realizo las validaciones para el casteo implicito
                        CastImplicito ci = new CastImplicito(linea, t, new Tipo(Simbolo.TipoS.INT), val);
                        if (ci.getTipo(e).isInt()) {
                            tamaños_de_dimensiones.add((int) ci.getValor(e));
                        } else {
                            System.out.println("Error!! al calcular el tamaño de las dimensiones del arreglo, no se retorno "
                                    + " un tipo de dato valido, linea: " + linea);
                        }
                    }
                } else {
                    System.out.println("Error!! al calcular tamañao de las dimensiones del arreglo, el valor retornado al "
                            + " evaluar la expresion es null, linea: " + linea);
                }
            }
        }
        return tamaños_de_dimensiones;
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
                    if(tipo_declarado.get().equals(tipo_dato.get()))
                    {
                        actual.hijos.add(new NodoArreglo(valor_dato));
                    }
                    else
                    {
                        //Si no son iguales verifico si se es un cast implicito
                        CastImplicito ci = new CastImplicito(linea, tipo_declarado, tipo_dato, valor_dato);
                        if(!ci.getTipo(e).isNull())
                        {
                            actual.hijos.add(new NodoArreglo(ci.getValor(e)));
                        }
                        else
                        {
                            System.out.println("Error!! no se puede asignar un tipo de dato: " + tipo_dato.get() 
                                    + " a un arreglo tipo: " + tipo_declarado.get() + ", linea: " + linea);
                        }
                    }
                }
            }
        } 
    }
    
    private void setTamañosDeDimensionesEnArbol(LinkedList<Object> vals, LinkedList<Integer>dimensiones){
        dimensiones.add(vals.size());
        if(vals.getFirst() instanceof LinkedList)
        {
            setTamañosDeDimensionesEnArbol((LinkedList)vals.getFirst(), dimensiones);
        }
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
    
}
