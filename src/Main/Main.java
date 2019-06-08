
package Main;

import Analizadores.Lexico;
import Analizadores.Sintactico;
import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import Arbol.Nodo;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //interpretar("entrada.txt");
        
    }
    
    private static void interpretar(String path) {
        File file=new File(path);
        try{
            FileReader fr=new FileReader(file);
            Lexico lex=new Lexico(fr);
            Sintactico miParser=new Sintactico(lex);
            miParser.parse();
            LinkedList<Nodo> arbol = miParser.getAST();
            if(arbol!=null){
                Entorno e = new Entorno();
                for(Nodo n: arbol){
                    if(n instanceof Instruccion){
                        ((Instruccion)n).ejecutar(e);
                    }
                    else if(n instanceof Expresion){
                        ((Expresion)n).getValor(e);
                    }
                }
            }
            else{
                System.out.println("Error!! al obtener arbol");
            }
            System.out.println("\n***************************");
            System.out.println("***  ANALISIS CORRECTO  ***");
            System.out.println("***************************");
	}catch(Exception e){ 
            System.out.println("Error fatal al analizar --  " + e);
        }
    }
    
}
