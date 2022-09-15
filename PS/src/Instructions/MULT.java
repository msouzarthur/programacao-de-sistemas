package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class MULT implements Instruction{
    Integer op = 14, numberOpd = 1;
    EndType end;
    String opcode = "0000000000001110";
    
    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if(opd2!=null){
            Main.Error.showError("o mult possui um argumento a mais");
            return;
        }
        ACC.setValue(ACC.getValue()*opd1);
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