package Main;

import Registers.PC;
import Registers.SP;
import java.util.List;
import java.util.ArrayList;

public final class Memory {
    
    private static List<Integer> memory = new ArrayList<>(500);

    public static Integer memoryGet(Integer address) {
        return memory.get(address);
    }

    public static List<Integer> memoryGetAll() {
        return memory;
    }

    public static void memorySet(Integer address, Integer content) {
        if (address < memory.size()) {
            memory.set(address, content);
        }
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

    public static void stackPush(Integer value) {
        System.out.println(SP.getValue());
        System.out.println("tamanho "+memory.size());
        memory.set(SP.getValue(), value);
        SP.nextValue();
    }

    public static Integer stackPop() {
        SP.previousValue();
        if (SP.getValue() < memory.size()) {
            Integer value;
            value = Memory.memoryGet(SP.getValue());
            Memory.memorySet(SP.getValue(), null);
            return value;
        }
        else{
            Error.showError("> não há nada na pilha");
            return -1;
        }
    }
}
