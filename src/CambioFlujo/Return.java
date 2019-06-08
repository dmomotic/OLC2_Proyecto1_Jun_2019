package CambioFlujo;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;

public class Return extends Expresion{

    public Expresion valor;
    public Object val;
    
    public Return(int linea, Expresion valor){
        this.linea = linea;
        this.valor = valor;
    }
    
    public Return(int linea){
        this.linea = linea;
    }
    
    @Override
    public Object getValor(Entorno e) {
        if(valor!=null){
            Object aux = valor.getValor(e);
            if(aux!=null){
                val = aux;
            }
        }
        return this;
    }

    @Override
    public Tipo getTipo(Entorno e) {
        if(valor!=null)
            return valor.getTipo(e);
        return new Tipo(Simbolo.TipoS.NULL);
    }
    
}
