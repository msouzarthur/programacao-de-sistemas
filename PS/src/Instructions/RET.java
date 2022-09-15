package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.PC;
import Registers.SP;
import javax.swing.JTextPane;

public class RET implements Instruction{
    Integer numberOpd = 0;
    EndType end;
    String opcode;
    
    public void RET(){
        this.opcode="0000000000001001";
    }
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd1!= null || opd2!=null){
            Main.Error.showError("o ret possui argumentos a mais");
            return;
        }
        PC.setValue(SP.pop());
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