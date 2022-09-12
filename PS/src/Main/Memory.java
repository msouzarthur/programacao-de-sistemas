package Main;

import java.util.List;
import java.util.ArrayList;


public final class Memory {
    //2 - 10 de pilha
    //11 - 69 de instruções
    //70 - 99 de dados
    private static List<String> memory = new ArrayList<>();
   
    public static String memoryGet(Integer address){
        return memory.get(address);
    }
    
    public static List<String> memoryGetAll(){
        return memory;
    }
    
    public static void memorySet(Integer address, String content){
        if(address<100){
            memory.add(address, content);
        }
    }
    
    public static void memoryInit(){
        for(int i = 0; i<100; i++){
            memory.add(null);
        }
    }
    
}
