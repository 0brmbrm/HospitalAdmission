import java.awt.Image;
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
        
        
       
        ImageIcon registerIcon = new ImageIcon("icons/reg.png");
        ImageIcon viewIcon = new ImageIcon("icons/log.png");
        
       
        JButton button1 = new JButton("Register Patient");
        if (registerIcon.getIconWidth() > 0) {
            // Resize icon if needed
            Image img = registerIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            button1.setIcon(new ImageIcon(img));
            button1.setIconTextGap(10);
            button1.setHorizontalTextPosition(SwingConstants.RIGHT);
        }
        button1.setBounds(150,50,200,50);
        add(button1);

        JButton button2 = new JButton("View Record");
        if (viewIcon.getIconWidth() > 0) {
            
            Image img = viewIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            button2.setIcon(new ImageIcon(img));
            button2.setIconTextGap(10);
            button2.setHorizontalTextPosition(SwingConstants.RIGHT);
        }
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