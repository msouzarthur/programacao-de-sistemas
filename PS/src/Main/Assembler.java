package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assembler {
    
    public void readContent(String path, Integer position) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                if(reader.nextLine().length()<=80){
                    String data = reader.nextLine();
                    System.out.println(data);
                }
            }
            reader.close();    
        } catch (FileNotFoundException e) {
            System.out.println("Problema ao ler arquivo");
            e.printStackTrace();
        }    
        
    }
}
