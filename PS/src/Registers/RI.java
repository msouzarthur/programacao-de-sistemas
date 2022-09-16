package Registers;

public final class RI {

    static Integer value = 0;

    public static int getValue() {
        return value;
    }

    public static String getText(){
        if(RI.value>0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(RI.value)));
        return Integer.toBinaryString(RI.value).substring(16,32);
    }
    
    public static void setValue(Integer value) {
        RI.value = value;
    }
    public static void reset(){
        RI.value = 0; 
    }
}
