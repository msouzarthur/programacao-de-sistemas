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
            Main.Error.showError("o call possui um argumento a menos");
            return;
        }
        if (opd2 != null) {
            Main.Error.showError("o call possui um argumento a mais");
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
    public String getEndType() {
        return this.end.toString();
    }

    @Override
    public void setEndType(EndType end) {
        this.end = end;
    }
}
