package Main;

import java.util.List;
import java.util.ArrayList;


public final class Memory {
    //2 - 10 de pilha
    //11 - 69 de instruções
    //70 - 99 de dados
    private static List<Integer> memory = new ArrayList<>();
   
    public static Integer memoryGet(Integer address){
        return memory.get(address);
    }
    
    public static List<Integer> memoryGetAll(){
        return memory;
    }
    
    public static void memorySet(Integer address, Integer content){
        if(address<100){
            memory.add(address, content);
        }
    }
    
    public static void memoryInit(){
        for(int i = 0; i<100; i++){
            memory.add(null);
        }
    }
    public static void memoryReset(){
        for(int i=0;i<memory.size();i++){
            memory.set(i, null);
        }
    }
    
}
