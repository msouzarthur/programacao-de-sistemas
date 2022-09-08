package Main;

import java.util.List;
import java.util.ArrayList;


public final class Memory {
    
    private static final List<String> memory = new ArrayList<>();

    public static String get(Integer address){
        return memory.get(address);
    }
    
    public static List<String> getAll(){
        return memory;
    }
    
    public static void set(Integer address, String content){
        memory.set(address, content);
    }
    
    public Memory(){
        for(int i = 0; i<100; i++){
            memory.add(null);
        }
    }
    
}
