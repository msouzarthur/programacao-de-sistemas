package Instructions;

import Main.Instruction;
import Registers.ACC;
import Registers.PC;
import javax.swing.JTextPane;

public class BRNEG implements Instruction {

    Integer op = 5, numberOpd = 1;
    String opcode = "0000000000000101";
    EndType end;

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if (opd2 != null) {
            Main.IO.showError("> o brneg possui um argumento a mais");
            return;
        }
        
        if (ACC.getValue()< 0 && opd1 >= 12 && opd1 < 100) {
            PC.setValue(opd1);
        } else {
            Main.IO.showError("> endereco nao acessivel");
            return;
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
