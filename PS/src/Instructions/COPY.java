package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import Main.VirtualMachine; 
import javax.swing.JTextPane;

public class COPY extends CompleteBinary implements Instruction{

    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
        if(opd1==null || opd2==null){
            Main.Error.showError("o copy está sem argumentos");
            return;
        }
        opd1 = opd2;
    }
    
}