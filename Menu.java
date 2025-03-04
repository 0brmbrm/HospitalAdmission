import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame {
    private RoomManager roomManager;
    private PatientManager patientManager;

    public Menu() {
        this(new PatientManager());
    }

    public Menu(PatientManager patientManager) {
        this.roomManager = new RoomManager();
        this.patientManager = patientManager;
        
        setTitle("Hospital Admission");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        setLayout(null);
        
        JButton button1 = new JButton("Register Patient");
        button1.setBounds(150,50,200,50);
        add(button1);

        JButton button2 = new JButton("View Record");
        button2.setBounds(150,130,200,50);
        add(button2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register registerFrame = new Register(roomManager, patientManager);
                registerFrame.setVisible(true);  
                dispose();  
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRecord recordFrame = new ViewRecord(patientManager);
                recordFrame.setVisible(true); 
                dispose();  
            }
        });
        
        setLocationRelativeTo(null);
    }
}

