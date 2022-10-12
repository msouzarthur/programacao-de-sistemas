package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Macros {

    private static String fileName;
    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> macrosTable = new ArrayList<>();

    public static void readContent(String path) {
        path = "../arquivo2.txt";
        contentTable = Reader.read(path,6);
        /*fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".txt", "").trim();
        File file = new File(path);
        Scanner reader;
        try {
            System.out.println("> lendo arquivo");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                String[] words = l.split(" ");
                String[] row = new String[6];
                if (!words[0].equals("*")) {
                    for (int i = 0; i < words.length; i++) {
                        row[i] = words[i];
          if (words[i].contains("start")) {
                            programName.add(words[i + 1]);
                        }
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
        }*/
        System.out.println("> estrutura do programa");
        print(contentTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");
    }

    public static List<String[]> macroReader(List<String[]> content) {
        for (int r = 0; r < content.size(); r++) {
            for (int w = 0; w < content.get(r).length; w++) {
                if (content.get(r)[w] != null && content.get(r)[w].contains("macro")) {
                    macroReader(content.subList(r, content.size() - 1));
                }
                if (content.get(r)[w] != null && content.get(r)[w].contains("mend")) {
                    System.out.println(content.get(r)[w]);
                    return content;
                }
                macrosTable.add(content.get(r));

            }
        }
        return null;
    }

    public static void print(List<String[]> target, String header) {
        System.out.println(header);
        System.out.println(" -----------------------------------------------");
        for (String[] r : target) {
            System.out.print("|");
            for (String r1 : r) {
                System.out.print(r1 + "\t");
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------------------------------");
    }

    public static void process(String path) {
        //estrutura o programa lido
        readContent(path);
        //processa as macros
        System.out.println("> lendo macros");
        macroReader(contentTable);
    }
}
