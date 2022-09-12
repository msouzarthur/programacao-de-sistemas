package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import javax.swing.JTextPane;

public class STOP extends CompleteBinary implements Instruction{
    Integer numberOpd = 0;
    EndType end;
    String opcode;
    
    public void STOP(){
        this.opcode="0000000000001011";
    }
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        System.exit(0);
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
