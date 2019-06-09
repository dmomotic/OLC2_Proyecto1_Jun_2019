package FuncionesNativas;

import Arbol.Entorno;
import Arbol.Expresion;
import Arbol.Simbolo;
import Arbol.Tipo;
import Excepciones.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile extends Expresion {

    Expresion ruta;

    public ReadFile(int linea, Expresion ruta) {
        this.linea = linea;
        this.ruta = ruta;
    }

    @Override
    public Object getValor(Entorno e) {
        if (ruta != null) {
            Object path_aux = ruta.getValor(e);
            if (path_aux != null && ruta.getTipo(e).isString()) {
                String path = path_aux.toString();
                File f = new File(Paths.get(path).toAbsolutePath().toString());
                if (f != null) {
                    FileReader fr = null;
                    try {
                        fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String contenido = "";
                        String cont_linea;
                        while ((cont_linea = br.readLine()) != null) {
                            contenido += cont_linea + "\n";
                        }
                        fr.close();
                        return contenido;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        if (fr != null) {
                            try {
                                fr.close();
                            } catch (IOException ex1) {
                                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                        }
                    }
                }
            } else {
                System.out.println("Error!! al obtener la ruta de la expresion en funcion read_file, linea: " + linea);
            }
        } else {
            System.out.println("Error!! la ruta de la funcion read_file es null, linea: " + linea);
        }
        return new FileNotFoundException();
    }

    @Override
    public Tipo getTipo(Entorno e) {
        return new Tipo(Simbolo.TipoS.STRING);
    }

}
