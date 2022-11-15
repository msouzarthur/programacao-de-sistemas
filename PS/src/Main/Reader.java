package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    private static List<String[]> contentTable = new ArrayList<>();

	/**
	 * Método que lê o arquivo e retorna uma lista de strings com os dados do arquivo
	 * @param path caminho absoluto do arquivo
	 * @param wordCount quantidade de palavras por linha
	 * @return lista de strings com os dados do arquivo
	 */
    public static List<String[]> read(String path, int wordCount) {
        contentTable = new ArrayList<>();
        File file = new File(path);
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                if (l.length() > 80) {
                    IO.showError("> linha de código com comprimento maior que o suportado");
                }
                l = l.replaceAll(",", " ");
                l = l.replaceAll("&", "");
                String[] words = l.split(" ");
                String[] row = new String[wordCount];
                if (!words[0].equals("*")) {
                    for (int i = 0; i < words.length; i++) {
                        row[i] = words[i];
                    }
                    contentTable.add(row);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            IO.showError("> erro ao ler arquivo");
        }
        for (int r = 0; r < contentTable.size(); r++) {
            for (int w = 0; w < contentTable.get(r).length; w++) {
                if (contentTable.get(r)[w] == null || contentTable.get(r)[w].equals("null") || contentTable.get(r)[w].length() == 0) {
                    contentTable.get(r)[w] = null;
                }
            }
        }
        return contentTable;
    }

	/**
	 * Método que retorna o header do arquivo lido
	 * @param path caminho absoluto do arquivo
	 * @param wordCount quantidade de palavras por linha
	 * @return header do arquivo lido contendo a quantidade de linhas e tamanho
	 * que ocupará na memória 
	 */
    public static String header(String path, int wordCount){
        String head = new String();
        File file = new File(path);
        Scanner reader;
        try{
            reader = new Scanner(file);
            head = reader.nextLine();
        }catch (FileNotFoundException e) {
            IO.showError("> erro ao ler arquivo");
        }
        return head;
    }

    public static void print(List<String[]> target, String header) {
        System.out.println(header);
        System.out.print(" -");
        for (char h : header.toCharArray()) {
            System.out.print("-");
        }
        System.out.println("-----");
        for (String[] r : target) {
            System.out.print("|");
            for (String r1 : r) {
                System.out.print(r1 + "\t");
            }
            System.out.println("|");
        }
        System.out.print(" -");
        for (char h : header.toCharArray()) {
            System.out.print("-");
        }
        System.out.println("-----");
    }

	/**
	 * Método responsável por ler o conteúdo em assembly do arquivo
	 * @param path caminho absoluto do arquivo
	 * @param wordCount quantidade de palavras por linha
	 * @return tabela de conteúdo
	 */
    public static List<String[]> readASM(String path, int wordCount) {
        contentTable = new ArrayList<>();
        File file = new File(path);
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                String[] words = l.split(" ");
                String[] row = new String[wordCount];
                if (l.length() > 80) {
                    IO.showError("> linha de código com comprimento maior que o suportado");
                }
                for (int w = 0; w < wordCount; w++) {
                    row[w] = words[w];
                }
                contentTable.add(row);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            IO.showError("> erro ao ler arquivo");
        }
        return contentTable;
    }
}
