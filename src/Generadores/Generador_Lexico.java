package Generadores;

import java.io.File;

public class Generador_Lexico 
{
    public static void main(String[] args) 
    {
        String path="src/Analizadores/Lexico.jflex";
        generarLexer(path);
    } 
    
    public static void generarLexer(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
}
