package Registers;

/**
 * Classe que representa o registrador acumulador.
 */
public final class ACC {

    static Integer value = 0;

    public static Integer getValue() {
        return value;
    }

	/**
	 * Método retorna o valor do acumulador em hexadecimal
	 * @return valor em hexadecimal
	 */
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
