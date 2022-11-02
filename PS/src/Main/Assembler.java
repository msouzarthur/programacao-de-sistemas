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
        path = "../arquivo.txt";
        fileName = path.substring(path.lastIndexOf('/') + 1);
        fileName = fileName.replace(".txt", "").trim();
        
        contentTable = Reader.read(path, 4);
        programName = contentTable.get(0)[2];
        
        if (!contentTable.get(contentTable.size() - 1)[1].equals("end")) {
            Error.showError("> diretiva end não encontrada");
        }
        System.out.println("> estrutura do programa " + programName);
        print(contentTable, "|label\tcomando\topd1\topd2\t|");
        symbolTable();
    }

    void print(List<String[]> target, String header) {
        System.out.println(header);
        System.out.println(" -------------------------------");
        for (String[] r : target) {
            System.out.print("|");
            for (String r1 : r) {
                System.out.print(r1 + "\t");
            }
            System.out.println("|");
        }
        System.out.println(" -------------------------------");
    }

    void symbolTable() {
        System.out.println("> montando tabela de simbolos");
        int i = 0;
        boolean isData = false;
        for (String[] line : contentTable) {
            if (!line[1].equals("start") && !line[1].equals("end")) {
                for (int j = 0; j < line.length; j++) {
                    if (line[0] != null && j == 0) {
                        String[] row = new String[3];
                        row[0] = line[0];
                        row[1] = null;
                        row[2] = Integer.toString(i);
                        symbolTable.add(row);
                    }
                    if (line[j] != null && !isData) {
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
        print(symbolTable, "|symbol\tvalor\tend\t|");
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
                if (r[2] != null && r[2].contains(",I")) {
                    r[2] = r[2].replace(",I", "");
                    address += 32;
                }
                if (r[3] != null && r[3].contains(",I")) {
                    r[3] = r[3].replace(",I", "");
                    address += 64;
                }
                if (r[2] != null && r[2].contains("#")) {
                    r[2] = r[2].replace("#", "");
                    address += 128;
                }
                if (r[2] != null && r[2].contains("@")) {
                    r[2] = r[2].replace("@", "");
                }
                if (r[3] != null && r[3].contains("@")) {
                    r[3] = r[3].replace("@", "");
                }

                r[1] = Integer.toString(getOpcode(r[1]) + address);

                //simbolos -> codigo
                for (int i = 2; i < 4; i++) {
                    int position = getAddress(r[i]);
                    if (r[i] != null && position != -1) {
                        r[i] = Integer.toString(position);
                    } else if (r[i] != null) {
                        Error.showError("> simbolo não definido " + r[i]);
                        return;
                    }
                }
                assembledTable.add(r);
            }
            if (a == 1) {
                start = 1;
            }
        }
        System.out.println("> programa " + programName + " montado");
        print(assembledTable, "|label\tcomando\topd1\topd2\t|");
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
                Error.showError("> instrução não reconhecida " + opd);
                return -1;
        }
    }

    void toObj() throws IOException {
        try (FileWriter writer = new FileWriter(fileName + ".obj")) {
            for (String[] str : assembledTable) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
        }
    }

    void toLst() throws IOException {
        try (FileWriter writer = new FileWriter(fileName + ".lst")) {
            writer.write("conteudo do programa" + System.lineSeparator());
            for (String[] str : contentTable) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
            writer.write("tabela de simbolos" + System.lineSeparator());
            for (String[] str : symbolTable) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
            writer.write("programa montado" + System.lineSeparator());
            for (String[] str : assembledTable) {
                for (String s : str) {
                    writer.write(s + " ");
                }
                writer.write(System.lineSeparator());
            }
        }
    }

    void assemble(String path) {
        System.out.println("> lendo código .asm");
        readContent(path);
        //fim do primeiro passo
        System.out.println("> montando programa");
        assembleProgram();
        //fim do segundo passo
        System.out.println("> salvando arquivo obj");
        try {
            toObj();
            System.out.println("> arquivo obj salvo");
        } catch (IOException ex) {
            Error.showError("> problema ao salvar arquivo obj");
        }
        System.out.println("> salvando arquivo lst");
        try {
            toLst();
            System.out.println("> arquivo lst salvo");
        } catch (IOException ex) {
            Error.showError("> problema ao salvar arquivo lst");
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }
}
