package Expresiones;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;

public class Literal extends Expresion{

    public Object valor;
    public Tipo tipo;
    
    public Literal(int linea, Object valor){
        this.linea = linea;
        this.valor = valor;
        if(valor instanceof Integer)
            this.tipo = new Tipo(Simbolo.TipoS.INT);
        else if(valor instanceof Double)
            this.tipo = new Tipo(Simbolo.TipoS.DOUBLE);
        else if(valor instanceof String)
            this.tipo = new Tipo(Simbolo.TipoS.STRING);
        else if(valor instanceof Boolean)
            this.tipo = new Tipo(Simbolo.TipoS.BOOLEAN);
        else if(valor instanceof Character)
            this.tipo = new Tipo(Simbolo.TipoS.CHAR);
    }
    
    @Override
    public Object getValor(Entorno e) {
        return this.valor;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return this.tipo;
    }
}
