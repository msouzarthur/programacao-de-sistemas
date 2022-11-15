package Registers;

/**
 * Classe que representa o registrador de endereço de memória.
 */
public final class RE {

    static Integer value = 0;

    public static Integer getValue() {
        return value;
    }

	/**
	 * Método retorna o valor do acumulador em hexadecimal
	 * @return valor em hexadecimal
	 */
    public static String getText() {
        if (RE.getValue() >= 0) {
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(RE.getValue())));
        }
        return Integer.toBinaryString(RE.getValue()).substring(16, 32);
    }

    public static void setValue(Integer value) {
        RE.value = value;
    }

    public static void reset() {
        RE.value = 0;
    }
}
