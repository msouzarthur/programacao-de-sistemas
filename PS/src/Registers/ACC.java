package Registers;

import Main.Register;

//public final class ACC implements Register {
public final class ACC{

    static String value="0000000000000000";
    
    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        ACC.value = value;
    }

}
