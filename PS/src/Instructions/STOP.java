package Instructions;

import Main.Instruction;
import javax.swing.JTextPane;

public class STOP implements Instruction {

    Integer op = 11, numberOpd = 0;
    EndType end;
    String opcode = "0000000000001011";

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        System.exit(0);
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
