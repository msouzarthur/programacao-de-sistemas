package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import javax.swing.JTextPane;

public class RET extends CompleteBinary implements Instruction{
    
    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
        if(opd1!= null || opd2!=null){
            Main.Error.showError("o ret possui argumentos a mais");
            return;
        }
        
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