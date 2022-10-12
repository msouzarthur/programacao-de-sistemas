package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    private static List<String[]> contentTable = new ArrayList<>();
 
    public static List<String[]> read(String path, int wordCount) {
        File file = new File(path);
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                if (l.length() > 80) {
                    Error.showError("> linha de código com comprimento maior que o suportado");
                }
                String[] words = l.split(" ");
                String[] row = new String[wordCount];
                if (!words[0].equals("*")) {
                    for (int i = 0; i < words.length; i++) {
                        row[i] = words[i];
                    }
                    contentTable.add(row);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            Error.showError("> erro ao ler arquivo");
        }
        for (String[] r : contentTable) {
            if (r[0].length() == 0) {
                r[0] = null;
            }
        }
        return contentTable;
    }
}
