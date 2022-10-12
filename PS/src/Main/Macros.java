package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Macros {

    private static String fileName;
    private static int macrosCount, start, stop;
    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> codeTable = new ArrayList<>();
    private static List<String[]> macrosTable = new ArrayList<>();
    private static List<String[]> macrosEscope = new ArrayList<>();

    public static void readContent(String path) {
        macrosCount = 0;
        path = "../arquivo2.txt";
        fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".txt", "").trim();

        contentTable = Reader.read(path, 6);

        for (String[] r : contentTable) {
            for (String w : r) {
                if (w != null && w.equals("macro")) {
                    macrosCount += 1;
                }
            }
        }

        print(contentTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");
        System.out.println("> macros contadas: " + macrosCount);

        for (int r = 0; r < contentTable.size(); r++) {
            for (int w = 0; w < contentTable.get(r).length; w++) {
                String[] row = new String[2];
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("macro")) {
                    row[0] = contentTable.get(r)[1];
                    row[1] = Integer.toString(r);
                    macrosEscope.add(row);
                }
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("mend")) {
                    row[0] = contentTable.get(r)[1];
                    row[1] = Integer.toString(r);
                    macrosEscope.add(row);
                }
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("start")) {
                    start = r+1;
                }
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("stop")) {
                    stop = r;
                }
            }
        }
        codeTable = contentTable.subList(start, stop);
        print(macrosEscope, "escope");
        print(codeTable, "code");
        
    }

    public static List<String[]> macroReader(List<String[]> content) {
        List<String[]> array = null;
        for (int r = 0; r < content.size(); r++) {
            for (int w = 0; w < content.get(r).length; w++) {
                
            }
        }
        return null;
    }

    public static void print(List<String[]> target, String header) {
        System.out.println(header);
        System.out.println(" -----------------------------------------------");
        for (String[] r : target) {
            System.out.print("|");
            for (String w : r) {
                System.out.print(w + "\t");
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
        print(macrosTable, "");

    }
}
