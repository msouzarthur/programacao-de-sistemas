package Instructions;

import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class SUB implements Instruction {

    Integer op = 6, numberOpd = 1;
    EndType end;
    String opcode = "0000000000000110";

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd2 != null) {
            Main.Error.showError("o sub possui um argumento a mais");
            return;
        }
        ACC.setValue(ACC.getValue() - opd1);
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
    public String getEndType() {
        return this.end.toString();
    }
}
