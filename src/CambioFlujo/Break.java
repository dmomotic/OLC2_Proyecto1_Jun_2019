package CambioFlujo;

import Arbol.Entorno;
import Arbol.Instruccion;

public class Break extends Instruccion{

    public Break(int linea){
        this.linea = linea;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        return this;
    }  
}
