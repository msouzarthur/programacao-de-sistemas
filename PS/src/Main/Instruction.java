package Main;

import javax.swing.JTextPane;

public interface Instruction {

    public enum EndType {
        DIRECT("000"),
        INDIRECT1("001"),
        INDIRECT2("010"),
        IMMEDIATE("100");
        private String type;

        private EndType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    };

    int numberOpd();

    void setEndType(EndType end);

    EndType getEndType();

    void runInstruction(JTextPane outCode, Integer opd1, Integer opd2);

}
