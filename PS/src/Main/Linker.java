package Main;

import java.io.FileWriter;
import java.io.IOException;
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

	/**
	 * Método responsável por realocar os endereços da memória de forma correta
	 * @param newEnd novo endereço de memória
	 */
    public static void realoc(int newEnd) {
        List<String[]> newContentTable = new ArrayList<>();

        for (String[] r : contentTable) {
            String[] clone = new String[r.length];
            System.arraycopy(r, 0, clone, 0, r.length);
            newContentTable.add(clone);
        }

        for (int r = 0; r < newContentTable.size(); r++) {
            int opcTarget = Integer.parseInt(newContentTable.get(r)[1]);
            int opdTarget = 0;
            if (opcTarget != 9 && opcTarget != 11) {
                opdTarget = Integer.parseInt(newContentTable.get(r)[2]);

                if (opcTarget <= 127) {
                    newContentTable.get(r)[2] = Integer.toString(opdTarget + newEnd);
                }
            }
        }
        save(newContentTable);
        Reader.print(newContentTable, "> conteudo linkado");
    }
	/**
	 * Gera o arquivo de saída .hpx
	 * @param list 
	 */
    public static void save(List<String[]> list) {
        System.out.println("> salvando arquivo hpx");
        try (FileWriter writer = new FileWriter("./saida/linkedCode.hpx")) {
            for (String[] str : list) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            IO.showError("> problema ao salvar arquivo hpx");
        }
    }

	/**
	 * Método responsável por executar a ação de ligador
	 */
    public static void link() {
        System.out.println("# LIGADOR #");
        System.out.println("> ligando arquivos");
        String contentHeader = Reader.header("./saida/MASMAPRG.lst", 4);
        int memPos = Integer.parseInt(contentHeader.split(" ")[2]);
        String symbolHeader = Reader.header("./saida/simbolos.lst", 3);
        int symbolAddresses = Integer.parseInt(symbolHeader.split(" ")[2]);

        contentTable = Reader.read("./saida/MASMAPRG.lst", 4);
        symbolTable = Reader.read("./saida/simbolos.lst", 3);

        int ref;
        int newRef = memPos + 1;
        for (int r = 0; r < symbolTable.size(); r++) {
            ref = Integer.parseInt(symbolTable.get(r)[2]);
            if (ref < newRef) {
                realoc(newRef - ref);
                break;
            }
        }
        System.out.println("> ligação concluida");
    }
}
