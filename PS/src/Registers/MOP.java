package Registers;

import Main.Register;

//public class MOP implements Register{
public final class MOP{

    static String value="0000000000000000";

    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        MOP.value = value;
    }

}
