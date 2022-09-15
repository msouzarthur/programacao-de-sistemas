package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import javax.swing.JTextPane;

public class BRPOS implements Instruction{
    Integer op = 1, numberOpd = 1;
    String opcode = "0000000000000001";
    EndType end;
    
    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if(opd2!=null){
            Main.Error.showError("o brneg possui um argumento a mais");
            return;
        }
        /*if(ACC>0){
            PC.setValue(opd1);
        }*/
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
