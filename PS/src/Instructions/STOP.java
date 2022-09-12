package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import Main.Register;
import javax.swing.JTextPane;

public class STOP extends CompleteBinary implements Instruction{

    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        System.exit(0);
    }
    Integer numberOpd = 0;
    @Override
    public Integer numberOpd() {
        return numberOpd;
    }
    EndType end;
    @Override
    public void setEndType(EndType end) {
        this.end = end;
    }

    @Override
    public String getEndType() {
        return this.end.toString();
    }
}
