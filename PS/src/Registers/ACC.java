package Registers;

public final class ACC{

    static int value=0;
    
    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        ACC.value = value;
    }
    
    public static void reset(){
        ACC.value = 0; 
    }

}
