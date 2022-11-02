package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    private static List<String[]> contentTable = new ArrayList<>();

    public static List<String[]> read(String path, int wordCount) {
        File file = new File(path);
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                if (l.length() > 80) {
                    Error.showError("> linha de código com comprimento maior que o suportado");
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
            Error.showError("> erro ao ler arquivo");
        }
        for (String[] r : contentTable) {
            if (r[0].length() == 0) {
                r[0] = null;
            }
        }
        return contentTable;
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
                    Error.showError("> linha de código com comprimento maior que o suportado");
                }
                for (int w = 0; w < wordCount; w++) {
                    row[w] = words[w];
                }
                contentTable.add(row);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            Error.showError("> erro ao ler arquivo");
        }
        return contentTable;
    }
}
