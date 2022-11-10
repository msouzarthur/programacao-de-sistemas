package Instructions;

import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class STORE implements Instruction {

    Integer op = 7, numberOpd = 1;
    EndType end;
    String opcode = "0000000000000111";

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd2 != null) {
            Main.IO.showError("o store possui um argumento a mais");
        }
        opd1 = ACC.getValue();
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
