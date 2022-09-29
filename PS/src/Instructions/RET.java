package Instructions;
import Main.*;
import Registers.PC;
import Registers.SP;
import javax.swing.JTextPane;

public class RET implements Instruction{
    Integer op = 9, numberOpd = 0;
    EndType end;
    String opcode="0000000000001001";;
    
    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if(opd1!= null || opd2!=null){
            Main.Error.showError("o ret possui argumentos a mais");
            return;
        }
        PC.setValue(Memory.stackPop());
        SP.previousValue();
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