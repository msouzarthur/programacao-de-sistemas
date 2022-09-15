package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import javax.swing.JTextPane;

public class WRITE implements Instruction{
    Integer op = 8, numberOpd = 1;
    EndType end;
    String opcode = "0000000000001000";
    
    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if(opd2!=null){
            Main.Error.showError("o write possui argumento a mais");
            return;
        }
        Main.Error.showError("o write não foi implementado ainda");
        return;
        //outCode.setText(opd1);
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