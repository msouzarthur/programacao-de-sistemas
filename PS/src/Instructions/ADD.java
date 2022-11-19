package Instructions;

import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class ADD implements Instruction {

    Integer op = 02, numberOpd = 1;
    String opcode = "0000000000000010";
    EndType end;

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd1 == null) {
            Main.IO.showError("> add tem um argumento a menos");
            return;
        } else if (opd2 != null) {
            Main.IO.showError("> add tem um argumento a mais");
            return;
        }
        ACC.setValue(ACC.getValue() + opd1);
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
