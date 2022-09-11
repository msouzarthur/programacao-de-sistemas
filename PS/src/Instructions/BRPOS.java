package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import Main.Register;
import javax.swing.JTextPane;

public class BRPOS extends CompleteBinary implements Instruction{

    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
    
    }
    Integer numberOpd = 1;
    @Override
    public Integer numberOpd() {
        return numberOpd;
    }
}
