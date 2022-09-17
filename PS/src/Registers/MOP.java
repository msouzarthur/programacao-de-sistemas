package Registers;

public final class MOP{

    static Integer value=0;

    public static int getValue() {
        return value;
    }
    
    public static String getText(){
        if(MOP.value>=0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(MOP.value)));
        return Integer.toBinaryString(MOP.value).substring(16,32);
    }
        
    public static void setValue(Integer value) {
        MOP.value = value;
    }
    
    public static void reset(){
        MOP.value = 0;
    }
}
