package Registers;

import Main.Memory;

/**
 * Classe que representa o registrador de ponteiro de pilha.
 */
public final class SP {

    static Integer value = Memory.memorySize() - 1;

    public static Integer getValue() {
        return value;
    }

    public static void setValue(Integer value) {
        SP.value = value;
    }

	/**
	 * Método que altera o valor do registrador para a próxima posição de memória
	 * válida.
	 */
    public static void nextValue() {
        if (SP.getValue() > 2 && SP.getValue() < Memory.memorySize() && Memory.memoryGet(SP.getValue() - 1) == null) {
            SP.value -= 1;
        } else {
            Memory.memorySet(1, 1);
            Main.IO.showError("stackoverflow");
            reset();
        }
    }

	/**
	 * Método retorna o valor do acumulador em hexadecimal
	 * @return valor em hexadecimal
	 */
    public static String getText() {
        if (SP.getValue() >= 0) {
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(SP.getValue())));
        }
        return Integer.toBinaryString(SP.getValue()).substring(16, 32);
    }

	/**
	 * Método que altera o valor do registrador para a posição anterior da pilha.
	 */
    public static void previousValue() {
        if (SP.getValue() > 2 && SP.getValue() < Memory.memorySize()) {
            SP.value += 1;
        } else {
            Main.IO.showError("> posicao de pilha inacessivel");
            reset();
        }
    }

    public static void reset() {
        SP.value = 0;
    }
}
