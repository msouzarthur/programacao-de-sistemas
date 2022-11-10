package Instructions;

import Main.Instruction;
import Registers.ACC;
import Registers.PC;
import javax.swing.JTextPane;

public class BRZERO implements Instruction {

    Integer op = 4, numberOpd = 1;
    EndType end;
    String opcode;

    public void BRZERO() {
        this.opcode = "0000000000000100";
    }

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd2 != null) {
            Main.IO.showError("o brneg possui um argumento a mais");
            return;
        }
        if (ACC.getValue() == 0 && opd1 > 12 && opd1 < 100) {
            PC.setValue(opd1);
        }
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
