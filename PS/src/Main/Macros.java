package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Macros {

    private static String fileName;
    private static int macrosCount;
    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> codeTable = new ArrayList<>();
    private static List<String[]> macrosTable = new ArrayList<>();
    private static ArrayList<Macro> macros = new ArrayList<>();

    public static void readContent(String path) {
       
        fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".txt", "").trim();
        contentTable = Reader.read(path, 6);
    }

    public static String[] saveMacro(String[] def, int end) {
        String[] row = new String[4];
        //contagem 
        row[0] = Integer.toString(macrosCount);
        //nome
        row[1] = def[1];
        //comeco
        row[2] = Integer.toString(end);
        //fim
        row[3] = getFinal(end);
        return row;
    }

    public static String getFinal(int start) {
        int nivel = 0;
        for (int r = start + 1; r < contentTable.size(); r++) {
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
        return null;
    }

    public static void processMacros() {
        int nivel = 0;
        String[] mRow, row;
        Macro macro;
        List<String[]> macroRow = new ArrayList<>();
        for (int r = 0; r < contentTable.size(); r++) {
            row = contentTable.get(r);
            if (row[1].equals("macro")) {
                if (nivel == 0) {
                    macrosCount += 1;

                    mRow = saveMacro(contentTable.get(r + 1), r);
                    macrosTable.add(mRow);

                    macro = new Macro(contentTable.get(r + 1));
                    macro.setStart(r);
                    macro.setEnd(Integer.parseInt(getFinal(r)));
                    macro.setOrgContent(contentTable.subList(macro.getStart() + 2, macro.getEnd()));
                    macros.add(macro);
                }
                nivel += 1;
            }
            if (row[1].equals("mend")) {
                nivel -= 1;
            }
            if (nivel == 0) {
                if (!row[1].equals("mend")) {
                    int subNivel = 0;
                    if (isMacro(row[1])) {
                        Macro m = getMacro(row[1]);
                        m.changeVar(row);
                        macroRow = m.getNewContent();
                        for (int mr = 0; mr < macroRow.size(); mr++) {
                            if (macroRow.get(mr)[1].equals("macro")) {
                                int index = 0;
                                subNivel += 1;
                                macrosCount += 1;
                                index = contentTable.indexOf(macroRow.get(mr));

                                mRow = saveMacro(macroRow.get(mr + 1), index);
                                macrosTable.add(mRow);

                                macro = new Macro(contentTable.get(index + 1));
                                macro.setStart(index);
                                macro.setEnd(Integer.parseInt(getFinal(index)));
                                macro.setOrgContent(contentTable.subList(macro.getStart() + 2, macro.getEnd()));
                                macros.add(macro);
                            }
                            if (macroRow.get(mr)[1].equals("mend")) {
                                subNivel -= 1;
                            }
                            if (subNivel == 0 && !macroRow.get(mr)[1].equals("mend")) {
                                if (isMacro(macroRow.get(mr)[1])) {
                                    macro = getMacro(macroRow.get(mr)[1]);
                                    macro.expand(macroRow.get(mr));
                                    for (String[] mmRow : macro.getNewContent()) {
                                        codeTable.add(mmRow);
                                    }
                                } else {
                                    codeTable.add(macroRow.get(mr));
                                }
                            }
                        }
                    } else {
                        codeTable.add(row);
                    }
                }
            }
        }
    }

    public static boolean isMacro(String name) {
        for (String[] r : macrosTable) {
            if (r[1].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Macro getMacro(String name) {
        for (Macro m : macros) {
            if (isMacro(name) && m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public static void toASM() {
        try (FileWriter writer = new FileWriter("MASMAPRG.asm")) {
            for (int r = 0; r < codeTable.size(); r++) {
                for (int w = 0; w < codeTable.get(r).length - 2; w++) {
                    writer.write(codeTable.get(r)[w] + " ");
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            Error.showError("> erro ao salvar .asm");
        }
    }

    public static void process(String path) {
        System.out.println("> processando macros "+path);
        readContent(path);

        System.out.println("> código lido");
        Reader.print(contentTable, "|label\tcommand\topd1\topd2\topd3\topd4\t|");

        processMacros();

        System.out.println("> informacao das macros " + macrosCount);
        Reader.print(macrosTable, "|id\tname\tstart\tend\t|");

        System.out.println("> código expandido");
        Reader.print(codeTable, "|label\tcommand\topd1\topd2\topd3\topd4\t|");

        toASM();
        System.out.println("> macros processadas");
    }
}
