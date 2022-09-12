package Registers;

import Main.Register;

//public final class RE implements Register {
public final class RE {
 
    static String value="0000000000000000";
    
    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        RE.value = value;
    }

}
