package Registers;

public final class RI {

    static int value = 0;

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        RI.value = value;
    }
    public static void reset(){
        RI.value = 0; 
    }
}
