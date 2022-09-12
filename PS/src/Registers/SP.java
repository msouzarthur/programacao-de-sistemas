package Registers;

public final class SP {

    static String value="0000000000000000";
    
    public static String getValue() {
        return value;
    }
    
    public static void setValue(String value) {
        SP.value = value;
    }

}
