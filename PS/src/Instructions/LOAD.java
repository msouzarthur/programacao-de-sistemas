package Instructions;

import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class LOAD implements Instruction {

    Integer op = 03, numberOpd = 1;
    EndType end;
    String opcode = "0000000000000011";

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd2 != null) {
            Main.Error.showError("o load possui um argumento a mais");
            return;
        }
        ACC.setValue(opd1);
    }

    @Override
    public int numberOpd() {
        return numberOpd;
    }

    @Override
    public void setEndType(EndType end) {
        this.end = end;
    }

    @Override
    public EndType getEndType() {
        return this.end;
    }
}
