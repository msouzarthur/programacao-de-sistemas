package Instructions;

import Main.Memory;
import Main.Instruction;
import Registers.PC;
import javax.swing.JTextPane;

public class CALL implements Instruction {

    Integer op = 15, numberOpd = 1;
    EndType end;
    String opcode;

    public void CALL() {
        this.opcode = "0000000000001111";
    }

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd1 == null) {
            Main.IO.showError("> call tem um argumento a menos");
            return;
        }
        if (opd2 != null) {
            Main.IO.showError("> call tem um argumento a mais");
            return;
        }
        Memory.stackPush(PC.getValue());
        PC.setValue(opd1);
    }

    @Override
    public int numberOpd() {
        return numberOpd;
    }

    @Override
    public EndType getEndType() {
        return this.end;
    }

    @Override
    public void setEndType(EndType end) {
        this.end = end;
    }
}
