package Registers;

public final class RE {
 
    static Integer value= 0;
    
    public static int getValue() {
        return value;
    }

    public static String getText(){
        if(RE.value>0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(RE.value)));
        return Integer.toBinaryString(RE.value).substring(16,32);
    }
    
    public static void setValue(Integer value) {
        RE.value = value;
    }
    
    public static void reset(){
        RE.value = 0; 
    }
}
