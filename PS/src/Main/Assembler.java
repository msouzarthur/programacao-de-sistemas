package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assembler {

    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> symbolTable = new ArrayList<>();
    private static String programName;

    public void readContent(String path) {
        path = "C:\\Users\\arthu\\Desktop\\Programação de Sistemas\\arquivo.txt";
        File file = new File(path);
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                if (l.length() > 80) {
                    Error.showError("linha de código com comprimento maior que o suportado");
                }
                String[] words = l.split(" ");
                String[] row = new String[4];

                for (int i = 0; i < words.length; i++) {
                    row[i] = words[i];
                    if (words[i].contains("start")) {
                        programName = words[i + 1];
                    }
                }
                contentTable.add(row);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problema ao ler arquivo");
        }
        for (String[] r : contentTable) {
            if (r[0].length() == 0) {
                r[0] = null;
            }
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

    void assembleProgram() {
        for (String[] r : contentTable) {
            for (int y = 0; y < r.length; y++) {
                if (y > 0 && r[y] != null) {
                    int address = getAddress(r[y]);
                    if (address != -1) {
                        r[y] = Integer.toString(address);
                    }
                }
            }
        }
        System.out.println("> programa " + programName + " montado");
        print(contentTable, "|label\tcomando\topd1\topd2\t|");
    }

    void toObj() {
        //implementar
    }

    void toLst() throws IOException {
        FileWriter writer = new FileWriter("file.lst");
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
        writer.close();
    }

    void assemble(String path) {
        System.out.println("> lendo código .asm");
        readContent(path);
        //fim do primeiro passo
        System.out.println("> montando programa");
        assembleProgram();
        //fim do segundo passo
        System.out.println("> salvando arquivo obj");
        toObj();

        System.out.println("> salvando arquivo lst");
        try {
            toLst();
        } catch (IOException ex) {
            System.out.println("Problema ao salvar arquivo");
        }
    }
}
