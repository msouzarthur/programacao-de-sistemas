package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import javax.swing.JTextPane;

public class READ extends CompleteBinary implements Instruction{
    String opcode;
    Integer numberOpd = 1;
    EndType end;

    public void READ(){
        this.opcode="0000000000001100";
    }
    
    @Override
    public void runInstruction(JTextPane inOutCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o read possui um argumento a mais");
            return; 
        }
        opd1 = inOutCode.getText();
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
