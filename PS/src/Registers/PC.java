package Registers;

public final class PC {
    
    static int value = 0;
    
    public static int getValue() {
        return value;
    }
    
    public static void setValue(int value) {
        PC.value = value;
    }
    
    public static void reset(){
        PC.value = 0; 
    }
    
}
