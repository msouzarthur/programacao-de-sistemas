package Main;

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
        path = "../arquivopdf.txt";
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
        int call = 0;
        String[] mRow, row;
        List<String[]> macroRow = new ArrayList<>();
        //percorre o codigo
        for (int r = 0; r < contentTable.size(); r++) {
            row = contentTable.get(r);
            //achou definicao de macro
            if (row[1].equals("macro")) {
                if (nivel == 0) {
                    macrosCount += 1;

                    mRow = saveMacro(contentTable.get(r + 1), r);
                    macrosTable.add(mRow);

                    Macro macro = new Macro(contentTable.get(r + 1));
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
                        //preciso expandir ela
                        Macro m = getMacro(row[1]);
                        m.changeVar(row);
                        macroRow = m.getNewContent();
                        for (int mr = 0; mr < macroRow.size(); mr++) {
                            if (macroRow.get(mr)[1].equals("macro")) {
                                subNivel += 1;
                                macrosCount += 1;

                                mRow = saveMacro(macroRow.get(mr + 1), contentTable.indexOf(macroRow.get(mr)));
                                macrosTable.add(mRow);
                            }
                            if (macroRow.get(mr)[1].equals("mend")) {
                                subNivel -= 1;
                            }
                            if (subNivel == 0 && !macroRow.get(mr)[1].equals("mend")) {
                                System.out.println("aaa " + macroRow.get(mr)[1]);
                                if (isMacro(macroRow.get(mr)[1])) {
                                    System.out.println("sim " + macroRow.get(mr)[1]);
                                    //expandir a macro do macroRow.get(mr)[1]
                                    
                                    
                                    //Macro macroCall = getMacro(macroRow.get(mr)[1]);
                                    //System.out.println("voltou "+macroCall.getName());
                                    //mm.changeVar(macroRow.get(mr));
                                    //List<String[]> mmr = mm.getNewContent();
                                    //for(String[] mmmr : mmr){
                                    //    codeTable.add(mmmr);
                                    //}
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
        print(contentTable, "> code");
        processMacros();
        print(codeTable, "> expanded code");
        //processa as macros
        print(macrosTable, "> macros");
    }
}/*
if (nivel == 0) {
                if (!row[1].equals("mend")) {
                    if (isMacro(row[1])) {
                        Macro m = getMacro(row[1]);
                        m.changeVar(row);
                        for (String[] rr : m.getNewContent()) {
                            if (rr[1].equals("macro")) {
                                if (nivel == 0) {
                                    macrosCount += 1;

                                    mRow = saveMacro(contentTable.get(r + 1), r);
                                    macrosTable.add(mRow);

                                    Macro macro = new Macro(contentTable.get(r + 1));
                                    macro.setStart(r);
                                    macro.setEnd(Integer.parseInt(getFinal(r)));
                                    System.out.println(macro.getName());
                                    System.out.println(macro.getStart());
                                    System.out.println(macro.getEnd());
                                    macro.setOrgContent(contentTable.subList(macro.getStart(), macro.getEnd()));
                                    macros.add(macro);
                                }
                                nivel += 1;
                            }
                            if (rr[1].equals("mend")) {
                                nivel -= 1;
                            } else {
                                codeTable.add(rr);
                            }
                        }
                    }
                }
            } else {
                codeTable.add(row);
subNivel += 1;
                                
                                mRow = saveMacro(contentTable.get(r + 1), r);
                                macrosTable.add(mRow);
                                
                                Macro nm = new Macro(macroRow.get(mr + 1));
                                m.setStart(mr);
                                m.setEnd(Integer.parseInt(getFinal(mr+1)));
                                m.setOrgContent(contentTable.subList(m.getStart() + 2, m.getEnd()));
                                macros.add(m);
            }*/
