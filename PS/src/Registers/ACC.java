package Registers;

public final class ACC {

    static Integer value = 0;

    public static Integer getValue() {
        return value;
    }

    public static String getText() {
        if (ACC.getValue() >= 0) {
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(ACC.getValue())));
        }
        return Integer.toBinaryString(ACC.getValue()).substring(16, 32);
    }

    public static void setValue(Integer value) {
        ACC.value = value;
    }

    public static void reset() {
        ACC.value = 0;
    }
}
