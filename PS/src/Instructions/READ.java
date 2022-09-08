package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import Main.Register;
import javax.swing.JTextPane;

public class READ extends CompleteBinary implements Instruction{

    @Override
    public void runInstruction(JTextPane inOutCode, Register target, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o read possui um argumento a mais");
            return; 
        }
        opd1 = inOutCode.getText();
    }

}
