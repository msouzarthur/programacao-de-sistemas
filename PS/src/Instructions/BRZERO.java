package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.ACC;
import Registers.PC;
import javax.swing.JTextPane;

public class BRZERO implements Instruction{
    Integer numberOpd = 1;
    EndType end;
    String opcode;
    
    public void BRZERO(){
        this.opcode = "0000000000000100";
    }
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o brneg possui um argumento a mais");
            return;
        }
        if(CompleteBinary.toInt(ACC.getValue())==0 && CompleteBinary.toInt(opd1)>12 && CompleteBinary.toInt(opd1)<100){
            PC.setValue(opd1);
        }
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
