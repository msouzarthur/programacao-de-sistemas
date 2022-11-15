package Main;

import java.util.ArrayList;
import java.util.List;

/*
CARREGADOR ABSOLUTO 
SÓ ESCREVE NA MEMÓRIA
 */
public class Loader {

    private static List<String[]> contentTable = new ArrayList<>();

	/**
	 * Carrega na memória o conteúdo do arquivo
	 * @param path caminho do arquivo
	 */
    public static void load(String path) {
        System.out.println("# CARREGADOR #");
        System.out.println("> carregando arquivo");
        contentTable = Reader.read(path, 4);
        Reader.print(contentTable, "|label\tcomando\topd1\topd2\t|");
        //pegar entrada de dado do usuário
        int memRow = 2;
        for (int r = 0; r < contentTable.size(); r++) {
            for (int w = 0; w < contentTable.get(r).length; w++) {
                if (contentTable.get(r)[w] != null) {
                    if (!contentTable.get(r)[w].equals("null")) {
                        Memory.memorySet(memRow, Integer.parseInt(contentTable.get(r)[w]));
                        memRow += 1;
                    }
                }
            }
        }
        System.out.println("> arquivo carregado");
    }

}
