package Registers;

public final class PC {
    
    static Integer value = 0;
    
    public static Integer getValue() {
        return value;
    }
    
    public static String getText(){
        if(PC.getValue()>=0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(PC.getValue())));
        return Integer.toBinaryString(PC.getValue()).substring(16,32);
    }
    
    public static void setValue(Integer value) {
        PC.value = value;
    }
    
    public static void reset(){
        PC.value = 0; 
    }
    
}
