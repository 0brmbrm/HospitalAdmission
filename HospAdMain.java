import javax.swing.*;

public class HospAdMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                PatientManager patientManager = new PatientManager();
                Menu mainMenu = new Menu(patientManager);
                mainMenu.setVisible(true);
            }
        });
    }    
}

