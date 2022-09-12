package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import javax.swing.JTextPane;

public class BRPOS extends CompleteBinary implements Instruction{
    String opcode;
    Integer numberOpd = 1;
    EndType end;

    public void BRPOS(){
        this.opcode="0000000000000001";
    }
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o brneg possui um argumento a mais");
            return;
        }
        /*if(ACC>0){
            PC.setValue(opd1);
        }*/
    }
    
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
