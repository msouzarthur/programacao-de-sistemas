package Main;

import java.util.ArrayList;
import java.util.List;

public class Macros {

    private static String fileName;
    private static int macrosCount, start, stop;
    //arquivo de entrada
    private static List<String[]> contentTable = new ArrayList<>();
    //arquivo de saída pro montador
    private static List<String[]> codeTable = new ArrayList<>();
    //arquivo de definição das macros
    private static List<String[]> macrosTable = new ArrayList<>();
    private static List<List<String[]>> macrosDef = new ArrayList<>();

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
    }

    public static void processMacros() {
        int nivel = 0;
        for (int r = 0; r < contentTable.size(); r++) {
            if (contentTable.get(r)[1] != null && contentTable.get(r)[1].equals("macro")) {
                nivel += 1;
            }

            if (nivel > 0) {
                macrosTable.add(contentTable.get(r));
            }

            if (contentTable.get(r)[1] != null && contentTable.get(r)[1].equals("mend")) {
                start = r + 1;
                nivel -= 1;
            }

            if (contentTable.get(r)[1] != null && contentTable.get(r)[1].equals("stop")) {
                stop = r;
            }
        }
        System.out.println("> macros");
        print(macrosTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");
    }

    /*
|null	macro	null	null	null	null	|
|null	scale	&rp	null	null	null	|
|null	macro	null	null	null	null	|
|null	multsc	&a	&b	&c	null	|
|null	load	&a	null	null	null	|
|null	mult	&b	null	null	null	|
|null	shiftr	&rp	null	null	null	|
|null	store	&c	null	null	null	|
|null	mend	null	null	null	null	|
|null	macro	null	null	null	null	|
|null	divsc	&a	&b	&c	null	|
|null	load	&a	null	null	null	|
|null	div	&b	null	null	null	|
|null	shiftl	&rp	null	null	null	|
|null	store	&c	null	null	null	|
|null	mend	null	null	null	null	|
|null	mend	null	null	null	null	|
|null	macro	null	null	null	null	|
|&lab	discr	&a	&b	&c	&d	|
|&lab	multsc	&a	&c	temp1	null	|
|null	multsc	temp1	@4	temp1	null	|
|null	multsc	&a	&b	temp2	null	|
|null	sub	temp1	null	null	null	|
|null	store	&d	null	null	null	|
|null	mend	null	null	null	null	|
     */
 /*public static int isMacro(String target) {
        for (String[] r : macrosEscope) {
            if (r[0].equals(target)) {
                //r -> [                       ]
                //w
                return Integer.parseInt(r[1]);
            }
        }
        return -1;
    }
     */
 /*    public static List<String[]> macroReader(List<String[]> content) {
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
     */
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
        processMacros();
        //System.out.println("> lendo macros");
        //macroReader(codeTable);
        //System.out.println("> conteudo lido");
        //print(contentTable, "|label\tcomando\targ1\targ2\targ3\targ4\t|");

        //print(macrosTable, "");
    }
}
