package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import Main.VirtualMachine; 
import javax.swing.JTextPane;

public class WRITE extends CompleteBinary implements Instruction{
 
    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o write possui argumento a mais");
            return;
        }
        outCode.setText(opd1);
    }
}