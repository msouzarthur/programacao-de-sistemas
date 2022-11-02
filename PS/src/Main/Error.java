package Main;

import javax.swing.JOptionPane;

public final class Error {

    //implementar pop-up
    public static void showError(String error){
        //System.out.println("ERRO: " + error);
        JOptionPane.showMessageDialog(null,"ERRO: " + error);
    }
}
