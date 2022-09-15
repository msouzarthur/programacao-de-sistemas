package Registers;

public final class MOP{

    static String value="00000000";

    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        MOP.value = value.substring(8, 16);
    }
    public static void reset(){
        MOP.value = "00000000";
    }
}
