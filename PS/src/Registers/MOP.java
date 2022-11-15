package Registers;

/**
 * Classe que representa o registrador com o modo de operação.
 */
public final class MOP {

    static Integer value = 0;

    public static Integer getValue() {
        return value;
    }

	/**
	 * Método retorna o valor do acumulador em hexadecimal
	 * @return valor em hexadecimal
	 */
    public static String getText() {
        if (MOP.getValue() >= 0) {
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(MOP.getValue())));
        }
        return Integer.toBinaryString(MOP.getValue()).substring(16, 32);
    }

    public static void setValue(Integer value) {
        MOP.value = value;
    }

    public static void reset() {
        MOP.value = 0;
    }
}
