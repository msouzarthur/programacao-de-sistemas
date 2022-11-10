package Instructions;

import Main.Instruction;
import Registers.PC;
import javax.swing.JTextPane;

public class BR implements Instruction {

    Integer op = 0, numberOpd = 1;
    EndType end;
    String opcode;

    public void BR() {
        this.opcode = "0000000000000000";
    }

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd2 != null) {
            Main.IO.showError("> br possui um argumento a mais");
        }
        //converter pra decimal
        if (opd1 >= 12 && opd1 < 100) {
            PC.setValue(opd1);
        } else {
            Main.IO.showError("> endereco nao acessivel");
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
