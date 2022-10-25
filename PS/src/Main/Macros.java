package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Macros {

    private static String fileName;
    private static int start, stop, macrosCount = 1;
    private static List<String[]> contentTable = new ArrayList<>();
    private static List<Macro> macros = new ArrayList<>();
    private static List<String[]> codeTable = new ArrayList<>();
    private static List<String[]> macrosTable = new ArrayList<>();
    private static List<String[]> macrosDef = new ArrayList<>();

    public static void readContent(String path) {
        //leitura do arquivo
        path = "../arquivopdf.txt";
        fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".txt", "").trim();

        contentTable = Reader.read(path, 6);
    }

    //scale não tem nada, spo define a multsc
    //label não vai ser usado nesse caso
    //no discr a gente expande o mult
    public static String getEnd(int start) {
        int nivel = 0;
        for (int r = start; r < contentTable.size(); r++) {
            if (contentTable.get(r)[1] != null) {
                if (contentTable.get(r)[1].equals("macro")) {
                    nivel += 1;
                }
                if (contentTable.get(r)[1].equals("mend")) {
                    if (nivel == 0) {
                        return Integer.toString(r);
                    }
                    nivel -= 1;
                }
            }
        }
        return null;
    }

    public static void processMacros() {
        int nivel = 0;
        Macro m;
        String[] row;
        for (int r = 0; r < contentTable.size(); r++) {
            row = new String[6];
            if (contentTable.get(r)[1] != null) {
                if (contentTable.get(r)[1].equals("macro")) {
                    row[0] = Integer.toString(macrosCount);
                    row[1] = contentTable.get(r + 1)[1];
                    row[2] = Integer.toString(r + 1);
                    row[3] = getEnd(r + 1);
                    if (nivel == 0) {
                        macrosDef.add(row);
                        macrosCount += 1;
                        m = new Macro(contentTable.get(r + 1));
                        m.setContent(contentTable.subList(Integer.parseInt(row[2]), Integer.parseInt(row[3])));
                        m.setInit(r + 1);
                        macros.add(m);
                    }
                    nivel += 1;
                } else if (nivel == 0 && isMacro(contentTable.get(r)[1])) {
                    //expandir
                    expand(contentTable.get(r), nivel);

                } else if (nivel == 0) {
                    macrosTable.add(contentTable.get(r));
                }

                if (contentTable.get(r)[1].equals("mend")) {
                    nivel -= 1;
                }

                if (contentTable.get(r)[1].equals("stop")) {
                    stop = r;
                }
                if (nivel == 0 && !contentTable.get(r)[1].equals("mend")) {
                    codeTable.add(contentTable.get(r));
                }
            }
        }
    }

    public static void expand(String[] call, int nivel) {
        Macro macro = findMacro(call[1]);
        Macro m;
        String[] row = new String[6];
        int count = 0;
        for (String[] r : macro.getContent()) {
            if (r[1].equals("macro")) {
                row[0] = Integer.toString(macrosCount);
                row[1] = macro.getContent().get(count + 1)[1];
                row[2] = Integer.toString(macro.getInit() + count + 1);
                row[3] = getEnd(macro.getInit() + count + 1);

                if (nivel == 0) {
                    macrosDef.add(row);
                    macrosCount += 1;
                    m = new Macro(r);
                    m.setContent(contentTable.subList(Integer.parseInt(row[2]), Integer.parseInt(row[3])));
                    m.setInit(count + 1);
                    macros.add(m);
                }

                nivel += 1;
            }
            count += 1;
        }
    }

    public static void expandMacros() {
        Macro m;
        String[] call;
        List<String[]> newCode = new ArrayList<>();
        for (int r = 0; r < codeTable.size(); r++) {
            call = codeTable.get(r);
            if (call[1] != null && isMacro(call[1])) {
                m = findMacro(call[1]);
                m.changeVar(call);
                for (String[] rr : m.getNewContent()) {
                    if (!rr[1].equals(call[1])) {
                        newCode.add(rr);
                    }
                }
            } else {
                newCode.add(call);
            }
        }
        codeTable = newCode;
    }

    public static boolean isMacro(String name) {
        for (String[] m : macrosDef) {
            if (name.equals(m[1])) {
                return true;
            }
        }
        return false;
    }

    public static Macro findMacro(String name) {
        for (Macro m : macros) {
            if (name.equals(m.getName())) {
                return m;
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

    public static void toASM() {
        try (FileWriter writer = new FileWriter("MASMAPRG.asm")) {
            for (String[] str : codeTable) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(Macros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void process(String path) {
        //estrutura o programa lido
        readContent(path);
        System.out.println("> conteudo lido");
        print(contentTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");

        //processa as macros
        processMacros();
        System.out.println("> definições das macros");
        print(macrosDef, "|macro\tname\tstart\tend\tlevel\ttype\t|");

        //expande as macros
        System.out.println("> codigo expandido");
        print(codeTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");

        toASM();
    }
}
