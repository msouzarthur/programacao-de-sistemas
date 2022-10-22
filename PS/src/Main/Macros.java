package Main;

import java.util.ArrayList;
import java.util.List;

public class Macros {

    private static String fileName;
    private static int start, stop;
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

    public static String getEnd(String target, int start) {
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
        int nivel = 0, macrosCount = 1;
        String[] row;
        for (int r = 0; r < contentTable.size(); r++) {
            row = new String[6];
            if (contentTable.get(r)[1] != null) {
                if (contentTable.get(r)[1].equals("macro")) {
                    row[0] = Integer.toString(macrosCount);
                    row[1] = contentTable.get(r + 1)[1];
                    row[2] = Integer.toString(r + 1);
                    row[3] = getEnd(contentTable.get(r + 1)[1], r + 1);
                    row[4] = Integer.toString(nivel);
                    if (nivel > 0) {
                        row[5] = "aninhad";
                    } else {
                        row[5] = "normal";
                    }
                    Macro m = new Macro(contentTable.get(r + 1));
                    m.setInit(r + 1);
                    m.setEnd(Integer.parseInt(getEnd(contentTable.get(r + 1)[1], r + 1)));
                    m.setContent(contentTable.subList(m.getInit(), m.getEnd()));
                    macros.add(m);
                    macrosDef.add(row);
                    nivel += 1;
                    macrosCount += 1;
                }

                if (nivel > 0) {
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
    //PROBLEMA TÁ AQUI
    public static void expandMacros() {
        //Ta causando looping infinito
        Macro m;
        String[] call;
        //cria a copia do codigo
        List<String[]> newCode = codeTable;
        //percorre a tabela do codigo
        for (int r = 0; r < codeTable.size(); r++) {
            call = codeTable.get(r);
            //se a linha lida não é nula e é uma macro
            if (call[1] != null && isMacro(call[1])) {
                //identifica e pega a macro
                m = findMacro(call[1]);
                //atualiza as variaveis da macro de acordo com a chamada
                //acho que esse changeVar não tá 100% 
                m.changeVar(contentTable.get(m.getInit()));
                //tem que copiar o conteudo da macro com as variaveis atualizadas pra copia do codigo
                //a expansao tem que substituir a linha de chamada da macro
                for (String[] rr : m.getContent()) {
                    System.out.println("quatro");
                    newCode.add(r, rr);
                }
            }
        }
        codeTable = newCode;
    }

    public static boolean isMacro(String name) {
        for (Macro m : macros) {
            if (name.equals(m.getName())) {
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

    public static void process(String path) {
        //estrutura o programa lido
        readContent(path);
        //System.out.println("> conteudo lido");
        //print(contentTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");

        //processa as macros
        processMacros();
        //System.out.println("> definições das macros");
        //print(macrosDef, "|macro\tname\tstart\tend\tlevel\ttype\t|");

        //expande as macros
        expandMacros();
        System.out.println("code");
        print(codeTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");

    }
}
