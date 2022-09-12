package Main;

import javax.swing.JTextPane;

public interface Instruction {
    public enum EndType{
        D   ("000"),
        IN1 ("001"),
        IN2 ("010"),
        IM  ("100");
        private String type;
        private EndType(String type){
            this.type = type;
        }
        @Override
        public String toString(){
            return type;
        }
    };
    Integer numberOpd();
    String completeBinary(String number);
    void setEndType(EndType end);
    String getEndType();
    void runInstruction(JTextPane outCode, Register target, String opd1, String opd2);
}