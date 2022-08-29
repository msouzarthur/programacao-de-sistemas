/**
 * @author arthur souza
 * @author hector fernandes
 * @author rafael grimmler
 * @author willian do espirito santo
 * @author matheus cardoso
 * @author leonardo marotta
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap; 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner (new FileReader("nome do arquivo.txt")); //Leitura de arquivos
        while (in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
        }        
        HashMap<String,String> variables = new HashMap<String, String>(); //Manipulação das tabelas
        variables.put("teste","testando"); //adiciona na tabela
        
    }
}
