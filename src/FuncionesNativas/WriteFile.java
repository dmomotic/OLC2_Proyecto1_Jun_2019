package FuncionesNativas;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Instruccion;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class WriteFile extends Instruccion {

    Expresion ruta;
    Expresion contenido;

    public WriteFile(int linea, Expresion ruta, Expresion contenido) {
        this.linea = linea;
        this.ruta = ruta;
        this.contenido = contenido;
    }

    @Override
    public Object ejecutar(Entorno e) {
        if (ruta != null) {
            if (contenido != null) {
                if (ruta.getTipo(e).isString()) {
                    Object path_aux = ruta.getValor(e);
                    if (path_aux != null) {
                        String path = path_aux.toString();
                        FileWriter fichero = null;
                        PrintWriter pw = null;
                        try {
                            fichero = new FileWriter(Paths.get(path).toAbsolutePath().toString());          
                            pw = new PrintWriter(fichero);

                            Object cont = contenido.getValor(e);
                            if(cont!=null)
                            {
                                pw.write(cont.toString());
                                System.out.println("write_file: " + Paths.get(path).toAbsolutePath().toString());
                            }
                        } catch (IOException ex) {
                        } finally {
                            try {
                                // Nuevamente aprovechamos el finally para 
                                // asegurarnos que se cierra el fichero.
                                if (null != fichero) {
                                    fichero.close();
                                }
                            } catch (IOException e2) {
                            }
                        }
                    } else {
                        System.out.println("Error!! en funcion write_file al evaluar funcion de la ruta, linea: " + linea);
                    }
                } else {
                    System.out.println("Error!! la ruta ingresada no es valida en write_file, linea: " + linea);
                }
            } else {
                System.out.println("Error!! en la funcion write_file el contenido a escribir es null, linea: " + linea);
            }
        } else {
            System.out.println("Error!! en la funcion write_file la ruta es null, linea: " + linea);
        }
        return null;
    }

}
