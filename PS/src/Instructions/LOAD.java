package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class LOAD extends CompleteBinary implements Instruction{
    Integer numberOpd = 1;
    EndType end;
    String opcode;
    
    public void LOAD(){
        this.opcode="0000000000000011";
    }
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o div possui um argumento a mais");
            return;
        }
        String aux = Integer.toBinaryString(Integer.parseInt(ACC.getValue(),2) / Integer.parseInt(opd1,2));
        ACC.setValue(completeBinary(aux));
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