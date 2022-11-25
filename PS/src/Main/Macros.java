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

	/**
	 * Método responsável por ler o conteúdo do arquivo e separar em tabelas
	 * @param path caminho absoluto do arquivo
	 */
    public static void readContent(String path) {

        fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".txt", "").trim();
        contentTable = Reader.read(path, 6);
    }

	/**
	 * Método responsável por montar uma tabela auxiliar
	 * @param def definição da macro a ser salva
	 * @param end endereço da inicial macro
	 * @return linha contendo a definição, endereço inicial e final da macro
	 */
    public static String[] saveMacro(String[] def, int end) {
        String[] row = new String[4];
        row[0] = Integer.toString(macrosCount);
        row[1] = def[1];
        row[2] = Integer.toString(end);
        row[3] = getFinal(end);
        return row;
    }

	/**
	 * Método responsável por procurar o final da macro
	 * @param start linha de início da macro
	 * @return posição final da macro
	 */
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

	/**
	 * Método responsável por processar todas as macros e salvar numa estrutura
	 * do tipo Macro. 
	 */
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

	/**
	 * Método responsável por verificar se a linha é uma macro
	 * @param name nome da macro
	 * @return resposta da verificação
	 */
    public static boolean isMacro(String name) {
        for (String[] r : macrosTable) {
            if (r[1].equals(name)) {
                return true;
            }
        }
        return false;
    }

	/**
	 * Método responsável por retornar a macro a partir do nome definido
	 * @param name nome da macro
	 * @return macro
	 */
    public static Macro getMacro(String name) {
        for (Macro m : macros) {
            if (isMacro(name) && m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

	/**
	 * Método responsável por salvar o conteúdo em assembly no arquivo .asm
	 * @param path caminho absoluto do arquivo
	*/
    public static void toASM() {
        try (FileWriter writer = new FileWriter("./saida/MASMAPRG.asm")) {
            System.out.println("> salvando arquivo asm");
            for (int r = 0; r < codeTable.size(); r++) {
                for (int w = 0; w < codeTable.get(r).length - 2; w++) {
                    writer.write(codeTable.get(r)[w] + " ");
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            IO.showError("> erro ao salvar .asm");
        }
    }

	/**
	 * Método que executa todo o processamento das macros
	 * @param path caminho absoluto do arquivo
	 */
    public static void process(String path) {
        System.out.println("# PROCESSADOR DE MACROS #");
        System.out.println("> processando macros");
        System.out.println("> arquivo " + path);
        readContent(path);

        System.out.println("> código lido");
        Reader.print(contentTable, "|label\tcommand\topd1\topd2\topd3\topd4\t|");

        processMacros();

        if (macrosCount > 0) {
            System.out.println("> informacao das macros " + macrosCount);
            Reader.print(macrosTable, "|id\tname\tstart\tend\t|");
        } else {
            System.out.println("> nenhuma macro encontrada");
        }
        System.out.println("> código expandido");
        Reader.print(codeTable, "|label\tcommand\topd1\topd2\topd3\topd4\t|");

        toASM();
    }
}
