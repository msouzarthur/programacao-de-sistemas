package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import Main.Register;
import javax.swing.JTextPane;

public class BR extends CompleteBinary implements Instruction{
    EndType end;
    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o br possui um argumento a mais");
            return;
        }
        target.setValue(opd1);
    }
    
    Integer numberOpd = 1;
    @Override
    public Integer numberOpd() {
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
