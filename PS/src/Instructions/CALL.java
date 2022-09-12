package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import javax.swing.JTextPane;

public class CALL extends CompleteBinary implements Instruction{
    Integer numberOpd = 1;
    Instruction end;
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o call possui um argumento a mais");
            return;
        }
    }

    @Override
    public Integer numberOpd() {
        return numberOpd;
    }

    @Override
    public String getEndType() {
        return this.end.toString();
    }

    @Override
    public void setEndType(EndType end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}