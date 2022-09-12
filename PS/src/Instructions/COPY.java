package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import javax.swing.JTextPane;

public class COPY extends CompleteBinary implements Instruction{

    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd1==null || opd2==null){
            Main.Error.showError("o copy está sem argumentos");
            return;
        }
        opd1 = opd2;
    }
    Integer numberOpd = 2;
    @Override
    public Integer numberOpd() {
        return numberOpd;
    }
    EndType end;
    @Override
    public void setEndType(EndType end) {
        this.end = end;
    }

    @Override
    public String getEndType() {
        return this.end.toString();
    }
}