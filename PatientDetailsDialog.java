import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PatientDetailsDialog extends JDialog {
    
    public PatientDetailsDialog(Frame parent, Patient patient) {
        super(parent, "Patient Details", true);
        
        setSize(500, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 50, 400, 500);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            
        Font boldFont = new Font("SansSerif", Font.BOLD, 14);
        Font normalFont = new Font("SansSerif", Font.PLAIN, 14);
        
        

        JLabel guardianLabel = new JLabel("Guardian:");
        guardianLabel.setFont(boldFont);
        guardianLabel.setBounds(10, 310, 100, 20);
        panel.add(guardianLabel);
        
        JLabel guardianValue = new JLabel(patient.getGuardianName());
        guardianValue.setFont(normalFont);
        guardianValue.setBounds(120, 310, 300, 20);
        panel.add(guardianValue);

        JLabel guardianContactLabel = new JLabel("Guardian Contact:");
        guardianContactLabel.setFont(boldFont);
        guardianContactLabel.setBounds(10, 340, 150, 20);
        panel.add(guardianContactLabel);
        
        JLabel guardianContactValue = new JLabel(patient.getGuardianContact());
        guardianContactValue.setFont(normalFont);
        guardianContactValue.setBounds(160, 340, 300, 20);
        panel.add(guardianContactValue);

        JLabel relationshipLabel = new JLabel("Relationship:");
        relationshipLabel.setFont(boldFont);
        relationshipLabel.setBounds(10, 370, 100, 20);
        panel.add(relationshipLabel);
        
        JLabel relationshipValue = new JLabel(patient.getRelationship());
        relationshipValue.setFont(normalFont);
        relationshipValue.setBounds(120, 370, 300, 20);
        panel.add(relationshipValue);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(boldFont);
        statusLabel.setBounds(10, 400, 100, 20);
        panel.add(statusLabel);
        
        JLabel statusValue = new JLabel(patient.isDischarged() ? "Discharged" : "Admitted");
        statusValue.setFont(normalFont);
        statusValue.setBounds(120, 400, 300, 20);
        panel.add(statusValue);
        
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(180, 450, 100, 30);
        panel.add(closeButton);
        
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(parent);
    }
}

