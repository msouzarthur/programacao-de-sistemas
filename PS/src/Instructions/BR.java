package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.PC;
import javax.swing.JTextPane;

public class BR extends CompleteBinary implements Instruction{
    Integer numberOpd = 1;
    EndType end;
    String opcode;
    
    public void BR(){
        this.opcode = "0000000000000000";
    }
    
    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o br possui um argumento a mais");
            return;
        }
        //converter pra decimal
        if(toInt(opd1)>=12 && toInt(opd1)<100){
            System.out.println(toInt(opd1));
            PC.setValue(opd1);
        }
        else{
            Main.Error.showError("endereco nao acessivel");
            return;
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
