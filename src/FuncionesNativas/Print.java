package FuncionesNativas;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;

public class Print extends Instruccion{

    Expresion valor;
    
    public Print(int linea, Expresion valor){
        this.linea = linea;
        this.valor = valor;
    }

    @Override
    public Object ejecutar(Entorno e) {
        Object val = valor.getValor(e);
        if(val!=null)
        {
            System.out.print(val.toString());
        }
        else
        {
            System.out.println("Error!! al ejecutar println() en linea: " + linea);
        }
        return null;
    }
    
}
