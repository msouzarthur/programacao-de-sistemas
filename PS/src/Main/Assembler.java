package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler {
    private static ArrayList<String[]> lista = new ArrayList<>();

    //String[][] conteudo = new String[20][20];
    public void readContent(String path, Integer position) {
        
        File file = new File(path);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] listaa = new String[4];
                String line = reader.nextLine();
                for(String a : listaa)
                    a = null;
            
                //substituir o label por null
                //|label | opc | opd | opd |
                //|null  | opc | ?opd!null | ?opd!null |
            
                if(line.length()<=80){
                    
                    String[] e = line.split(" ");
                    for(int i=0;i<e.length;i++){
                        
                        e[i].replace(" ","");
                        
                        if(e[i]!=" " && e[i]!=null && e[i]!="\n")
                            listaa[i] = e[i];
                        //System.out.println(e[i]);
                            if(e[i]==" ")
                                System.out.println("achou");
                        
                    }
                    lista.add(listaa);
                    for(int i=0;i<listaa.length;i++){
                        System.out.println(listaa[i]);
                    }
                }
                else
                    System.out.println("cai");
                
            }
            reader.close();    
            
        } catch (FileNotFoundException e) {
            System.out.println("Problema ao ler arquivo");
            e.printStackTrace();
        }    
        
    }
}
