package Main;

import javax.swing.JTextPane;

public interface Instruction {

    /**
     * Enum com os tipos de endereçamentos
     */
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

    /**
     * Método que retorna a quantidade de operandos que a instrução necessita.
     *
     * @return numero de operandos
     */
    int numberOpd();

    /**
     * Método que define o tipo de endereçamento que a instrução irá usar.
     *
     * @param end tipo de endereçamento
     */
    void setEndType(EndType end);

    /**
     * Método que retorna o tipo de endereçamento que a instrução irá usar.
     *
     * @return tipo de endereçamento
     */
    EndType getEndType();

    /**
     * Método que executa a instrução.
     *
     * @param outCode -
     * @param opd1 operando 1
     * @param opd2 operando 2
     */
    void runInstruction(JTextPane outCode, Integer opd1, Integer opd2);

}
