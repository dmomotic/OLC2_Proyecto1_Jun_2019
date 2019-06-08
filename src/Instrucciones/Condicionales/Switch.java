package Instrucciones.Condicionales;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Tipo;
import CambioFlujo.Break;
import CambioFlujo.Return;
import java.util.LinkedList;

public class Switch extends Instruccion{

    Expresion valor;
    LinkedList<Case> casos;

    public Switch(int linea, Expresion valor, LinkedList<Case> casos){
        this.linea = linea;
        this.valor = valor;
        this.casos = casos;
    }
    
    @Override
    public Object ejecutar(Entorno e) {
        if(valor!=null)
        {
            Object valor_switch = valor.getValor(e);
            Tipo tipo_switch = valor.getTipo(e);
            //Variable auxiliar para saber si debo ejecutar el default
            boolean ejecutar_default = true;
            if(valor_switch!=null)
            {
                //Ejecucion para todos los case excepto default
                for(Case c: casos){
                    
                    if(c.valor!=null && !c.isDefault)
                    {
                        Object valor_caso = c.valor.getValor(e);
                        Tipo tipo_caso = c.valor.getTipo(e);
                        
                        //Si el tipo de la expresion switch es igual a la del case
                        if(tipo_switch.get().equals(tipo_caso.get()))
                        {
                            //Si el valor del case cumple
                            if(valor_switch.equals(valor_caso)){
                                //Actualizo mi variable para ya no ejecutar el default
                                ejecutar_default = false;
                                //Ejecuto las instrucciones del case
                                Object aux = c.ejecutar(e);
                                //Valido si es la instruccion Break
                                if(aux instanceof Break){
                                    break;
                                }
                                //Valido si es la expresion Return
                                else if(aux instanceof Return){
                                    return aux;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error!! el tipo del caso no es igual al tipo del switch en linea: " + c.linea);
                        }
                    }
                }
                //Ejecucion de default 
                if(getDefault()!=null && ejecutar_default){
                    Case c = (Case)getDefault();
                    //Ejecuto las instrucciones del case
                    Object aux = c.ejecutar(e);
                    //Valido si es la instruccion Break
                    if(aux instanceof Break){
                        return null;
                    }
                    //Valido si es la expresion Return
                    else if(aux instanceof Return){
                        return aux;
                    }
                }
            }
            else
            {
                System.out.println("Error!! la expresion evaluada retorno null en swithc linea: " + linea);
            }
        }
        else
        {
            System.out.println("Error!! en switch porque su expresion inicial es null en linea: " + linea);
        }
        return null;
    }
    
    public Object getDefault(){
        for(Case c: casos){
            if(c.isDefault)
                return c;
        }
        return null;
    }
    
}
