package Main;

import java.util.ArrayList;
import java.util.List;

/*
LIGADOR RELOCADOR
VAI CONTAR ONDE TERMINA O CÓDIGO E COMEÇA DADOS
VAI PEGAR TODAS AS REFERENCIAS A UM ENDEREÇO E VER SE ELE TA OCUPADO
SE TÁ OCUPADO, SEPARA UM ESPAÇO NOVO E MUDA TODAS AS REFERENCIAS
ARRUMA OS ENDEREÇOS E MANDA PRO CARREGADOR
*/

public class Linker {
    
    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> symbolTable = new ArrayList<>();
    
    public static void link(){
        String contentHeader = Reader.header("./MASMAPRG.lst", 4);
        //me diz a posição de onde acaba a seção de instruções
        //usando esse valor, já posso inserir dados de memória
        int contentAddresses = Integer.parseInt(contentHeader.split(" ")[2]);
        String symbolHeader =  Reader.header("./simbolos.lst", 3);
        int symbolAddresses = Integer.parseInt(symbolHeader.split(" ")[2]);
        
        System.out.println(contentAddresses);
        contentTable = Reader.read("./MASMAPRG.lst", 4);
        symbolTable = Reader.read("./simbolos.lst",3);
        System.out.println("linker");
        Reader.print(contentTable,"conteudo");
        Reader.print(symbolTable, "simbolos");
        for(int r=0;r<contentTable.size();r++){
            //for(int w=0;w<contentTable.get(r).length();w++{
                
            //}
        }
    }
}
