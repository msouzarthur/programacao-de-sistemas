package Instructions;
import Main.CompleteBinary;
import Main.Instruction;
import Registers.PC;
import javax.swing.JTextPane;

public class BRNEG implements Instruction{
    Integer op = 5, numberOpd = 1;
    String opcode = "0000000000000101";
    EndType end;

    @Override
    public void runInstruction(JTextPane outCode, Integer opd1, Integer opd2) {
        if(opd2!=null){
            Main.Error.showError("o brneg possui um argumento a mais");
            return;
        }
        //PEGAR ACC EM QUALQUER LUGAR
        if(opd1>=12 && opd1<100){
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
