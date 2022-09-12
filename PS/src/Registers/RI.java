package Registers;

import Main.Register;

//public final class RI implements Register {
public final class RI {

    static String value="0000000000000000";
    public static String getValue() {
        return value;
    }
    public static void setValue(String value) {
        RI.value = value;
    }

}
