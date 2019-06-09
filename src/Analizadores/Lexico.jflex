/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones

package Analizadores;

import java_cup.runtime.*;


%%
/*----------------------------------------------------------------------------
--------------------- 2da. Area: Opciones y Declaraciones
----------------------------------------------------------------------------*/

%{
    String cadena="";
%}

//-------> Directivas
%public
%class Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//-------> Expresiones Regulares
digito = [0-9]
numero = {digito}+
decimal = {digito}+(".")({digito}+)?
letra = [a-zA-ZñÑ]
identificador = ({letra}|"_")({letra}|{digito}|"_")*
caracter = "'"[a-zA-ZñÑ0-9]"'"

//-------> Estados
%state COMENT_SIMPLE
%state COMENT_MULTI
%state CADENA

%%
/*-------------------------------------------------------------------
--------------------- 3ra. y ultima area: Reglas Lexicas
-------------------------------------------------------------------*/

//-------> Comentarios

<YYINITIAL> "/*"                {yybegin(COMENT_MULTI);}
<COMENT_MULTI> "*/"             {yybegin(YYINITIAL);}
<COMENT_MULTI> .                {}
<COMENT_MULTI> [ \t\r\n\f]      {}

"//"                            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> [^"\n"]         {}
<COMENT_SIMPLE> "\n"            {yybegin(YYINITIAL);}

//-------> Cadenas
<YYINITIAL> "\""                {yybegin(CADENA);}
<CADENA> [^\"]                  {cadena += yytext();}
<CADENA> [\"]                   {String temp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(Simbolos.cadena, yycolumn, yyline, temp);}


/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                 PALABRAS RESERVADAS
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

<YYINITIAL> "int"      {   return new Symbol(Simbolos.rint, yycolumn, yyline, yytext());}
<YYINITIAL> "double"      {   return new Symbol(Simbolos.rdouble, yycolumn, yyline, yytext());}
<YYINITIAL> "char"      {   return new Symbol(Simbolos.rchar, yycolumn, yyline, yytext());}
<YYINITIAL> "boolean"      {   return new Symbol(Simbolos.rboolean, yycolumn, yyline, yytext());}
<YYINITIAL> "String"      {   return new Symbol(Simbolos.rstring, yycolumn, yyline, yytext());}
<YYINITIAL> "true"      {   return new Symbol(Simbolos.rtrue, yycolumn, yyline, yytext());}
<YYINITIAL> "false"      {   return new Symbol(Simbolos.rfalse, yycolumn, yyline, yytext());}
<YYINITIAL> "println"      {   return new Symbol(Simbolos.rprintln, yycolumn, yyline, yytext());}
<YYINITIAL> "while"      {   return new Symbol(Simbolos.rwhile, yycolumn, yyline, yytext());}
<YYINITIAL> "if"      {   return new Symbol(Simbolos.rif, yycolumn, yyline, yytext());}
<YYINITIAL> "else"      {   return new Symbol(Simbolos.relse, yycolumn, yyline, yytext());}
<YYINITIAL> "break"      {   return new Symbol(Simbolos.rbreak, yycolumn, yyline, yytext());}
<YYINITIAL> "continue"      {   return new Symbol(Simbolos.rcontinue, yycolumn, yyline, yytext());}
<YYINITIAL> "return"      {   return new Symbol(Simbolos.rreturn, yycolumn, yyline, yytext());}
<YYINITIAL> "switch"      {   return new Symbol(Simbolos.rswitch, yycolumn, yyline, yytext());}
<YYINITIAL> "case"      {   return new Symbol(Simbolos.rcase, yycolumn, yyline, yytext());}
<YYINITIAL> "default"      {   return new Symbol(Simbolos.rdefault, yycolumn, yyline, yytext());}
<YYINITIAL> "do"      {   return new Symbol(Simbolos.rdo, yycolumn, yyline, yytext());}
<YYINITIAL> "for"      {   return new Symbol(Simbolos.rfor, yycolumn, yyline, yytext());}
<YYINITIAL> "print"      {   return new Symbol(Simbolos.rprint, yycolumn, yyline, yytext());}
<YYINITIAL> "read_file"      {   return new Symbol(Simbolos.rreadfile, yycolumn, yyline, yytext());}
<YYINITIAL> "write_file"      {   return new Symbol(Simbolos.rwritefile, yycolumn, yyline, yytext());}
<YYINITIAL> "str"      {   return new Symbol(Simbolos.rstr, yycolumn, yyline, yytext());}
<YYINITIAL> "toDouble"      {   return new Symbol(Simbolos.rtodouble, yycolumn, yyline, yytext());}
<YYINITIAL> "toInt"      {   return new Symbol(Simbolos.rtoint, yycolumn, yyline, yytext());}
<YYINITIAL> "toChar"      {   return new Symbol(Simbolos.rtochar, yycolumn, yyline, yytext());}



/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                           SIMBOLOS
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

<YYINITIAL> "="         {return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}
<YYINITIAL> ";"         {return new Symbol(Simbolos.ptocoma, yycolumn, yyline, yytext());}
<YYINITIAL> ","         {return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}
<YYINITIAL> "+"         {return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}
<YYINITIAL> "-"         {return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}
<YYINITIAL> "*"         {return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}
<YYINITIAL> "/"         {return new Symbol(Simbolos.div, yycolumn, yyline, yytext());}
<YYINITIAL> "("         {return new Symbol(Simbolos.parizq, yycolumn, yyline, yytext());}
<YYINITIAL> ")"         {return new Symbol(Simbolos.parder, yycolumn, yyline, yytext());}
<YYINITIAL> "."         {return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());}
<YYINITIAL> "["         {return new Symbol(Simbolos.corizq, yycolumn, yyline, yytext());}
<YYINITIAL> "]"         {return new Symbol(Simbolos.corder, yycolumn, yyline, yytext());}
<YYINITIAL> "{"         {return new Symbol(Simbolos.llavizq, yycolumn, yyline, yytext());}
<YYINITIAL> "}"         {return new Symbol(Simbolos.llavder, yycolumn, yyline, yytext());}
<YYINITIAL> ":"         {return new Symbol(Simbolos.dosptos, yycolumn, yyline, yytext());}
<YYINITIAL> "^"         {return new Symbol(Simbolos.potencia, yycolumn, yyline, yytext());}
<YYINITIAL> "++"         {return new Symbol(Simbolos.masmas, yycolumn, yyline, yytext());}
<YYINITIAL> "--"         {return new Symbol(Simbolos.menosmenos, yycolumn, yyline, yytext());}
<YYINITIAL> "=="         {return new Symbol(Simbolos.igualque, yycolumn, yyline, yytext());}
<YYINITIAL> ">"         {return new Symbol(Simbolos.mayque, yycolumn, yyline, yytext());}
<YYINITIAL> "<"         {return new Symbol(Simbolos.menque, yycolumn, yyline, yytext());}
<YYINITIAL> ">="         {return new Symbol(Simbolos.mayigualque, yycolumn, yyline, yytext());}
<YYINITIAL> "<="         {return new Symbol(Simbolos.menigualque, yycolumn, yyline, yytext());}
<YYINITIAL> "!="         {return new Symbol(Simbolos.difque, yycolumn, yyline, yytext());}
<YYINITIAL> "&&"         {return new Symbol(Simbolos.and, yycolumn, yyline, yytext());}
<YYINITIAL> "||"         {return new Symbol(Simbolos.or, yycolumn, yyline, yytext());}
<YYINITIAL> "!"         {return new Symbol(Simbolos.not, yycolumn, yyline, yytext());}
<YYINITIAL> "?"         {return new Symbol(Simbolos.pregunta, yycolumn, yyline, yytext());}
<YYINITIAL> "+="         {return new Symbol(Simbolos.masigual, yycolumn, yyline, yytext());}
<YYINITIAL> "*="         {return new Symbol(Simbolos.porigual, yycolumn, yyline, yytext());}
<YYINITIAL> "-="         {return new Symbol(Simbolos.menosigual, yycolumn, yyline, yytext());}
<YYINITIAL> "/="         {return new Symbol(Simbolos.divigual, yycolumn, yyline, yytext());}
<YYINITIAL> "'"         {return new Symbol(Simbolos.comilla, yycolumn, yyline, yytext());}

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                               OTROS (EXPRESIONES REGULARES)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

<YYINITIAL> {identificador}         { return new Symbol(Simbolos.id, yycolumn, yyline, yytext()); }
<YYINITIAL> {numero}                { return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}
<YYINITIAL> {decimal}                { return new Symbol(Simbolos.decimal, yycolumn, yyline, yytext());}
<YYINITIAL> {caracter}                { return new Symbol(Simbolos.caracter, yycolumn, yyline, yytext());}
[ \t\r\n\f]                         {/* ignore white space. */ }
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}

