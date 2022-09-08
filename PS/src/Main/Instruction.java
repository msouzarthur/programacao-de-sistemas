package Main;

import javax.swing.JTextPane;

public interface Instruction {
    public enum EndType{
        D("DIRETO"),IN("INDIRETO"),IM("IMEDIATO");
        private String type;
        private EndType(String type){
            this.type = type;
        }
        @Override
        public String toString(){
            return type;
        }
    };
    String completeBinary(String number);
    void runInstruction(JTextPane outCode, Register target, String opd1, String opd2);
}