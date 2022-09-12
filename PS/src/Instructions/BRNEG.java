package Instructions;

import Main.CompleteBinary;
import Main.Instruction;
import Main.Register;
import Registers.PC;
import javax.swing.JTextPane;

public class BRNEG extends CompleteBinary implements Instruction{

    @Override
    public void runInstruction(JTextPane outCode, String opd1, String opd2) {
        if(opd2!=null){
            Main.Error.showError("o brneg possui um argumento a mais");
            return;
        }
        //PEGAR ACC EM QUALQUER LUGAR
        if(toInt(opd1)>=12 && toInt(opd1)<100){
            System.out.println(toInt(opd1));
            PC.setValue(opd1);
        }
        else{
            Main.Error.showError("endereco nao acessivel");
            return;
        }
        /*if(ACC<0){
            target.setValue(opd1);
        }*/
    }
    Integer numberOpd = 1;
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
