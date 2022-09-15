package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.ACC;
import javax.swing.JTextPane;

public class ADD implements Instruction{
    Integer numberOpd = 1;
    String opcode;
    EndType end;
    
    public void ADD(){
        this.opcode="0000000000000010";
    }
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd1 == null){
            Main.Error.showError("o add possui um argumento a menos");
            return;
        }
        if(opd2!=null){
            Main.Error.showError("o add possui um argumento a mais");
            return;
        }
        String aux = Integer.toBinaryString(Integer.parseInt(ACC.getValue(),2) + Integer.parseInt(opd1,2));
        ACC.setValue(CompleteBinary.completeBinary(aux));
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