package Main;

import Registers.SP;
import java.util.List;
import java.util.ArrayList;

public final class Memory {

    private static List<Integer> memory = new ArrayList<>(500);

	/**
	 * Método retorna o valor armazenado na posição de memória
	 * @param address endereço de memória
	 * @return valor armazenado na posição de memória
	 */
    public static Integer memoryGet(Integer address) {
        return memory.get(address);
    }

	/**
	 * Método retorna toda a memória implementada
	 * @return memória implementada
	 */
    public static List<Integer> memoryGetAll() {
        return memory;
    }

	/**
	 * Método usado para armazenar um valor na memória em uma posição específica
	 * @param address endereço de memória
	 * @param content conteúdo a ser armazenado
	 */
    public static void memorySet(Integer address, Integer content) {
        if (address < memory.size()) {
            memory.set(address, content);
        }
    }

    public static Integer memoryGetPos() {
        for (int i = 2; i < 500; i++) {
            if (memory.get(i) != null) {
                return i;
            }
        }
        return -1;
    }

    public static Integer memoryDataInit() {
        for (int i = 3; i < 500; i++) {
            if (memory.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    public static Integer memorySize() {
        return memory.size();
    }

    public static void memoryInit() {
        for (int i = 0; i < 500; i++) {
            memory.add(null);
        }
    }

    public static void memoryReset() {
        for (int i = 0; i < memory.size(); i++) {
            memory.set(i, null);
        }
    }

	/**
	 * Método armazena um valor na pilha do sistema
	 * @param value valor a ser armazenado
	 */
    public static void stackPush(Integer value) {
        if (Memory.memoryGet(SP.getValue() - 1) == null) {
            memory.set(SP.getValue(), value);
            SP.nextValue();
        }
    }

	/**
	 * Método retorna o valor armazenado no topo da pilha do sistema
	 * @return valor armazenado
	 */
    public static Integer stackPop() {
        SP.previousValue();
        if (SP.getValue() < memory.size()) {
            Integer value;
            value = Memory.memoryGet(SP.getValue());
            Memory.memorySet(SP.getValue(), null);
            return value;
        } else {
            IO.showError("> não há nada na pilha");
            return -1;
        }
    }
}
