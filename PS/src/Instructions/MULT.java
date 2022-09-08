package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import javax.swing.JTextPane;

public class MULT extends CompleteBinary implements Instruction{
    
    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o erro possui um argumento a mais");
            return;
        }
        String aux = Integer.toBinaryString(Integer.parseInt(target.getValue(),2) * Integer.parseInt(opd1,2));
        target.setValue(completeBinary(aux));
    }

}