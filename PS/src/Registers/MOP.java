package Registers;

public final class MOP{

    static Integer value = 0;

    public static Integer getValue() {
        return value;
    }
    
    public static String getText(){
        if(MOP.getValue()>=0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(MOP.getValue())));
        return Integer.toBinaryString(MOP.getValue()).substring(16,32);
    }
        
    public static void setValue(Integer value) {
        MOP.value = value;
    }
    
    public static void reset(){
        MOP.value = 0;
    }
}
