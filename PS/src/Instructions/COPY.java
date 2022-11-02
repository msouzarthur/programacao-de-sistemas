package Instructions;

import Main.Instruction;
import javax.swing.JTextPane;

public class COPY implements Instruction {

    Integer op = 13, numberOpd = 2;
    EndType end;
    String opcode = "0000000000001101";

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd1 == null || opd2 == null) {
            Main.Error.showError("> copy está sem argumentos");
            return;
        }
        opd1 = opd2;
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
