package Main;

import java.util.ArrayList;
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
        path = "../arquivopdf.txt";
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

        System.out.println("> conteudo lido");
        print(contentTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");
        System.out.println("> macros identificadas: " + macrosCount);
        int nivel = 0;
        for (int r = 0; r < contentTable.size(); r++) {
            for (int w = 0; w < contentTable.get(r).length; w++) {
                String[] row = new String[3];
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("macro")) {
                    nivel += 1;
                    row[0] = contentTable.get(r + 1)[1];
                    row[1] = Integer.toString(r + 1);
                    row[2] = Integer.toString(nivel);
                    macrosEscope.add(row);
                }
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("mend")) {
                    row[0] = contentTable.get(r)[1];
                    row[1] = Integer.toString(r);
                    row[2] = Integer.toString(nivel);
                    nivel -= 1;
                    macrosEscope.add(row);
                }
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("mend")) {
                    start = r + 1;
                }
                if (contentTable.get(r)[w] != null && contentTable.get(r)[w].equals("stop")) {
                    stop = r;
                }
            }
        }
        codeTable = contentTable.subList(start, stop);
        print(macrosEscope, "|macro\tpos\tnivel\t|");
        System.out.println("> trecho de codigo");
        print(codeTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");

    }

    public static int isMacro(String target) {
        for (String[] r : macrosEscope) {
            if (r[0].equals(target)) {
                //r -> [                       ]
                //w
                return Integer.parseInt(r[1]);
            }
        }
        return -1;
    }

    public static List<String[]> macroReader(List<String[]> content) {
        int pos = -1;
        for (int r = 0; r < content.size(); r++) {
            //a linha que a gente pegou já foi definida   e  não é definicao 
            pos = isMacro(content.get(r)[1]);
            if (pos != -1 && !content.get(r)[1].equals("mend") && !content.get(r - 1)[1].equals("macro")) {
                //substituir a chamada pela macro
                //[1] é o nome da macro
                //[2,3,4,5] são os argumentos

                System.out.println("achei um " + content.get(r)[1] + " " + r + " "+pos);
                //expandir a macro

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
        macroReader(codeTable);
        
        print(macrosTable, "");

    }
}
