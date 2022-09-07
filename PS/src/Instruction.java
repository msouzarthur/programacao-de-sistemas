public class Instruction {
    private String opcode;
    private String opd1;
    private String opd2;
    
    public Instruction(String opcode, String opd1, String opd2){
        this.opcode = opcode;
        this.opd1 = opd1;
        this.opd2 = opd2;
    } 
    
    public void runInstruction(Register acc, Error error){
        String op = (String) opcode.subSequence(12,16);
        switch(op){
            case "0000":
                //BR
                System.out.println("achou br");
                break;
            case "0001":
                //BRPOS
                System.out.println("achou brpos");
                break;
            case "0010": //ADD: ACC <- OPD1
                if(opd1==null || opd1.length()!=16 || opd2!=null){
                    error.setError("erro ao fazer add");
                    break;
                }
                Integer calc = Integer.parseInt(acc.getValue(),2) + Integer.parseInt(opd1,2);
                String aux = Integer.toBinaryString(calc);
                acc.setValue(completeBinary(aux));
                break;
            case "0011":
                //LOAD
                break;
            case "0100":
                //BRZERO
                break;
            case "0101":
                //BRNEG
                break;
            case "0110":
                break;
            case "0111":
                break;
            case "1000":
                break;
            case "1001":
                break;
            case "1010":
                break;
            case "1011":
                break;
            case "1100":
                break;
            case "1101":
                break;
            case "1110":
                break;
            case "1111":
                break;
            default:
                System.out.println("ERRO DE OPCODE");
        }
    }
    
    public String completeBinary(String number){
        String complete = "";
        Integer left = 16 - number.length()-1;
        for(int i = 0; i < left; i++){
            complete+="0";
        }
        return complete + number;
    }
}
