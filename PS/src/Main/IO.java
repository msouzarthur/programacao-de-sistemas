package Main;

import javax.swing.JOptionPane;

public final class IO {

    public static void showError(String target) {
        JOptionPane.showMessageDialog(null, "> ERRO: " + target);
    }
    
    public static void write(String target){
        JOptionPane.showMessageDialog(null, "> MENSAGEM: " + target);
    }
    
    public static String read(){
        return JOptionPane.showInputDialog("> DIGITE O CONTEÚDO: ");
    }
}
