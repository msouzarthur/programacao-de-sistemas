package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assembler {
    
    private static List<String[]> contentTable = new ArrayList<>();
    private static List<String[]> symbolTable = new ArrayList<>();
    private static String programName;
    private static Integer address;
    public void readContent(String path) {
        path = "C:\\Users\\arthu\\Desktop\\Programação de Sistemas\\arquivo.txt";
        File file = new File(path);
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String l = reader.nextLine();
                String[] words = l.split(" ");
                String[] row = new String[4];
                               
                for(int i = 0;i<words.length;i++){
                    row[i] = words[i];
                    if(words[i].contains("start"))
                        programName = words[i+1];
                }
                contentTable.add(row);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problema ao ler arquivo");
        }
        
        for(String[] r : contentTable){
            if(r[0].length()==0)
                r[0] = null;
        }
        
        //remover no fim do código
        System.out.println("assembler");
        System.out.println("programa lido: "+programName);
        System.out.println("|label\tcomando\topd1\topd2\t|");
        System.out.println("----------------------------------");
        for(String[] r:contentTable){
            System.out.print("|");
            for (String r1 : r) {
                System.out.print(r1 + "\t");
            }
            System.out.println("|");
        }
        System.out.println("----------------------------------");
        symbolTable();
    }
    
    void symbolTable(){
        int i = 0;
        boolean isData = false;
        for(String[] line : contentTable){
            if(!line[1].equals("start") && !line[1].equals("end")){
                for(int j=0;j<line.length;j++){
                   if(line[0] != null && j==0){
                       String[] row = new String[3];
                       row[0] = line[0];
                       row[1] = null;
                       row[2] = Integer.toString(i);
                       symbolTable.add(row);
                   }
                   if(line[j] != null && !isData){
                       i+=1;
                   }else if(isData && j == 1) i+=1;
                   if(line[1].equals("stop")) isData = true;
               }   
            }
        }
        //remover no fim do código
        System.out.println("symbol table:\n|symbol\tvalor\tend\t|");
        System.out.println("-------------------------");
        for(String[] r:symbolTable){
            System.out.print("|");
            for (String r1 : r) {
                System.out.print(r1 + "\t");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }
    
    int getAddress(String target){
        for(String[] r:symbolTable){
            if(r[0].equals(target)){
                return Integer.parseInt(r[2]);
            }
        }
        return -1;
    }
    
    void assembleProgram(){
        for(String[] r : contentTable){
            for(int y=0;y<r.length;y++){
                if(y>0 && r[y]!=null){
                    int address = getAddress(r[y]);
                    if(address != -1){
                        r[y] = Integer.toString(address);
                        //System.out.println("achei "+r[y]+" "+address);
                    }
                }
            }
        }
        
        ///////////////
        System.out.println("assembler");
        System.out.println("programa lido: "+programName);
        System.out.println("|label\tcomando\topd1\topd2\t|");
        System.out.println("----------------------------------");
        for(String[] r:contentTable){
            System.out.print("|");
            for (String r1 : r) {
                System.out.print(r1 + "\t");
            }
            System.out.println("|");
        }
        System.out.println("----------------------------------");
        /////////////////
    }
    
    void assemble(String path) {
        //Li o conteudo        
        readContent(path);
        //fim do primeiro passo
        assembleProgram();
    }
}
