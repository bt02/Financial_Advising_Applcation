import GUI.BudgetGUI;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //Set color scheme/look of GUI
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BudgetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Launching frames
        new BudgetGUI();
    }
}
