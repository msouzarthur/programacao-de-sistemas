package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Assembler {

    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> symbolTable = new ArrayList<>();
    private static List<String[]> assembledTable = new ArrayList<>();
    private static String programName, fileName;

    public void readContent(String path) {
        fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".asm", "").trim();

        contentTable = Reader.readASM(path, 4);
        programName = contentTable.get(0)[2];

        if (!contentTable.get(contentTable.size() - 1)[1].equals("end")) {
            IO.showError("> diretiva end não encontrada");
        }
        //System.out.println("> estrutura do programa " + programName);
        //Reader.print(contentTable, "|label\tcomando\topd1\topd2\t|");
        symbolTable();
    }

    void symbolTable() {
        System.out.println("> montando tabela de simbolos");
        int i = 0;
        boolean isData = false;
        for (String[] line : contentTable) {
            if (!line[1].equals("start") && !line[1].equals("end")) {
                for (int j = 0; j < line.length; j++) {
                    if (!line[0].equals("null") && j == 0) {
                        String[] row = new String[3];
                        row[0] = line[0];
                        row[1] = null;
                        row[2] = Integer.toString(i);
                        symbolTable.add(row);
                    }
                    if (!line[j].equals("null") && !isData) {
                        i += 1;
                    } else if (isData && j == 1) {
                        i += 1;
                    }
                    if (line[1].equals("stop")) {
                        isData = true;
                    }
                }
            }
        }
        System.out.println("> tabela de simbolos");
        Reader.print(symbolTable, "|symbol\tvalor\tend\t|");
    }

    int getAddress(String target) {
        for (String[] r : symbolTable) {
            if (r[0].equals(target)) {
                return Integer.parseInt(r[2]);
            }
        }
        return -1;
    }

    //remover coluna de label do codigo montado
    //ver o opd2 imediato do copy
    void assembleProgram() {
        int address, start = 0;
        for (String[] r : contentTable) {
            int a = 0;
            r[0] = null;
            address = 0;
            if (r[1].contains("start")) {
                a = 1;
            }
            if (r[1].contains("stop")) {
                start = 0;
                r[1] = Integer.toString(getOpcode(r[1]) + address);
                assembledTable.add(r);
            }
            if (start == 1) {
                if (!r[2].equals("null")) {
                    if (r[2].contains(",I")) {
                        r[2] = r[2].replace(",I", "");
                        address += 32;
                    }
                    if (r[2].contains("#") || r[2].contains("@")) {
                        r[2] = r[2].replace("#", "");
                        //r[2] = r[2].replace("@", "");
                        address += 128;
                    }
                    /*if (r[2].contains("@")) {
                        r[2] = r[2].replace("@", "");
                        address += 128;
                    }*/
                }
                if (!r[3].equals("null")) {
                    if (r[3].contains(",I")) {
                        r[3] = r[3].replace(",I", "");
                        address += 64;
                    }
                    /*if (r[3].contains("@")) {
                        r[3] = r[3].replace("@", "");
                    }*/
                }

                r[1] = Integer.toString(getOpcode(r[1].trim()) + address);

                //simbolos -> codigo
                for (int i = 2; i < 4; i++) {
                    int position = getAddress(r[i]);
                    if (!r[i].equals("null") && position != -1) {
                        r[i] = Integer.toString(position);
                    } else if (!r[i].equals("null") && !r[i].contains("@")) {
                        IO.showError("> simbolo não definido " + r[i]);
                        return;
                    }
                    if (r[i].contains("@")) {
                        r[i] = r[i].replace("@", "");
                    }
                }
                assembledTable.add(r);
            }
            if (a == 1) {
                start = 1;
            }
        }
        System.out.println("> programa " + programName + " montado");
        Reader.print(assembledTable, "|label\tcomando\topd1\topd2\t|");
    }

    int getOpcode(String opd) {
        opd = opd.trim();
        switch (opd) {
            case "br":
                return 0;
            case "brpos":
                return 1;
            case "add":
                return 2;
            case "load":
                return 3;
            case "brzero":
                return 4;
            case "brneg":
                return 5;
            case "sub":
                return 6;
            case "store":
                return 7;
            case "write":
                return 8;
            case "ret":
                return 9;
            case "div":
                return 10;
            case "stop":
                return 11;
            case "read":
                return 12;
            case "copy":
                return 13;
            case "mult":
                return 14;
            case "call":
                return 15;
            default:
                IO.showError("> instrução não reconhecida " + opd);
                return -1;
        }
    }

    void toObj() throws IOException {
        String fName = "./saida/" + fileName + ".obj";
        try (FileWriter writer = new FileWriter(fName)) {
            for (String[] str : assembledTable) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
        }
    }

    void toLst(List<String[]> list, String fileName) throws IOException {
        String fName = "./saida/" + fileName + ".lst";
        try (FileWriter writer = new FileWriter(fName)) {
            writer.write(setHeader(list));
            for (String[] str : list) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
        }
    }

    String setHeader(List<String[]> list) {
        int lines = list.size();
        int addresses = 1;
        for (String[] r : list) {
            for (String w : r) {
                if (w != null) {
                    if (!w.equals("null")) {
                        addresses += 1;
                    }
                }
            }
        }
        return "* " + lines + " " + addresses + "\n";
    }

    void assemble(String path) {
        System.out.println("# MONTADOR #");
        System.out.println("> montando programa");
        System.out.println("> lendo código .asm");
        readContent(path);

        //fim do primeiro passo
        assembleProgram();

        //fim do segundo passo
        System.out.println("> salvando arquivo obj");
        try {
            toObj();
            System.out.println("> arquivo obj salvo");
        } catch (IOException ex) {
            IO.showError("> problema ao salvar arquivo obj");
        }
        System.out.println("> salvando arquivo lst");
        try {
            toLst(contentTable, "conteudo");
            toLst(symbolTable, "simbolos");
            toLst(assembledTable, "MASMAPRG");
            System.out.println("> arquivo lst salvo");
        } catch (IOException ex) {
            IO.showError("> problema ao salvar arquivo lst");
        }
        System.out.println("> programa montado");
    }
}
