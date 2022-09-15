package Registers;

public final class MOP{

    static int value=0;

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        MOP.value = value;
    }
    
    public static void reset(){
        MOP.value = 0;
    }
}
