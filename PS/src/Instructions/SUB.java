package Instructions;
import Main.CompleteBinary;
import Main.Register;
import Main.Instruction;
import javax.swing.JTextPane;

public class SUB extends CompleteBinary implements Instruction{
    
    @Override
    public void runInstruction(JTextPane outCode, Register target, String opd1, String opd2) {
        if(opd2!= null){
            Main.Error.showError("o sub possui um argumento a mais");
            return;
        }
        System.out.print("numero do acc: "+target.getValue());
        System.out.println(Integer.parseInt(target.getValue(),2));
        System.out.println(Integer.parseInt(opd1,2));
        String aux = Integer.toBinaryString(Integer.parseInt(target.getValue(),2) - Integer.parseInt(opd1,2));
        target.setValue(completeBinary(aux));
    }

}