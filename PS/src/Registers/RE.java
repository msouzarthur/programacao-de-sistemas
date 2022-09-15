package Registers;

public final class RE {
 
    static int value= 0;
    
    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        RE.value = value;
    }
    
    public static void reset(){
        RE.value = 0; 
    }
}
