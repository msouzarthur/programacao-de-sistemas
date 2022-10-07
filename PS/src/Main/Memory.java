package Main;

import Registers.PC;
import Registers.SP;
import java.util.List;
import java.util.ArrayList;

public final class Memory {

    private static List<Integer> memory = new ArrayList<>(100);

    public static Integer memoryGet(Integer address) {
        return memory.get(address);
    }

    public static List<Integer> memoryGetAll() {
        return memory;
    }

    public static void memorySet(Integer address, Integer content) {
        if (address < 100) {
            memory.add(address, content);
        }
    }

    public static Integer memorySize() {
        return memory.size();
    }

    public static void memoryInit() {
        for (int i = 0; i < 100; i++) {
            memory.add(null);
        }
    }

    public static void memoryReset() {
        for (int i = 0; i < memory.size(); i++) {
            memory.set(i, null);
        }
    }

    public static void stackPush(Integer value) {
        memory.set(SP.getValue(), value);
        SP.nextValue();
    }

    public static Integer stackPop() {
        Integer value = Memory.memoryGet(SP.getValue());
        Memory.memorySet(PC.getValue(), null);
        SP.previousValue();
        return value;
    }
}
