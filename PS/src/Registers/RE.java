package Registers;

public final class RE {
 
    static Integer value= 0;
    
    public static Integer getValue() {
        return value;
    }

    public static String getText(){
        if(RE.getValue()>=0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(RE.getValue())));
        return Integer.toBinaryString(RE.getValue()).substring(16,32);
    }
    
    public static void setValue(Integer value) {
        RE.value = value;
    }
    
    public static void reset(){
        RE.value = 0; 
    }
}
