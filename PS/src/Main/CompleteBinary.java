package Main;

public final class CompleteBinary {

	/**
	 * Tranforma um número em formato de String em um binário em formato de String
	 * @param number numero em formato de String
	 * @return binário em forma de String
	 */
    public static String completeBinary(String number) {
        String complete = "";
        Integer left = 16 - number.length();
        for (int i = 0; i < left; i++) {
            complete += "0";
        }
        return complete + number;
    }

	/**
	 * Tranforma String em inteiro
	 * @param cod número que será transformado em String
	 * @return String do número passado
	 */
    public static Integer toInt(String cod) {
        if (cod != null) {
            return Integer.parseInt(cod, 2);
        }
        return null;
    }

	/**
	 * Chama os métodos responsáveis por tranformar o número em binário.
	 * @param number número que será convertido.
	 * @return retorna um binário de 16 bits
	 */
    public static String toBin(Integer number) {
        if (number != null) {
            String bin = Integer.toBinaryString(number);
            String complete = "";
            Integer left = 16 - bin.length();
            for (int i = 0; i < left; i++) {
                complete += "0";
            }
            return complete + bin;
        }
        return null;
    }
}
