package CambioFlujo;

import Arbol.Entorno;
import Arbol.Instruccion;

public class Continue extends Instruccion{

    public Continue(int linea){
        this.linea = linea;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        return this;
    }
    
}
