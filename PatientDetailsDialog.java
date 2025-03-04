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
        
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(boldFont);
        nameLabel.setBounds(10, 10, 100, 20);
        panel.add(nameLabel);
        
        JLabel nameValue = new JLabel(patient.getSurname() + ", " + patient.getFirstName() + " " + patient.getMiddleName());
        nameValue.setFont(normalFont);
        nameValue.setBounds(120, 10, 300, 20);
        panel.add(nameValue);
        
        JLabel birthLabel = new JLabel("Birth Date:");
        birthLabel.setFont(boldFont);
        birthLabel.setBounds(10, 40, 100, 20);
        panel.add(birthLabel);
        
        JLabel birthValue = new JLabel(patient.getBirthDate());
        birthValue.setFont(normalFont);
        birthValue.setBounds(120, 40, 300, 20);
        panel.add(birthValue);
        
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(boldFont);
        genderLabel.setBounds(10, 70, 100, 20);
        panel.add(genderLabel);
        
        JLabel genderValue = new JLabel(patient.getGender());
        genderValue.setFont(normalFont);
        genderValue.setBounds(120, 70, 300, 20);
        panel.add(genderValue);
        
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(boldFont);
        contactLabel.setBounds(10, 100, 150, 20);
        panel.add(contactLabel);
        
        JLabel contactValue = new JLabel(patient.getContactNumber());
        contactValue.setFont(normalFont);
        contactValue.setBounds(160, 100, 300, 20);
        panel.add(contactValue);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(boldFont);
        emailLabel.setBounds(10, 130, 100, 20);
        panel.add(emailLabel);
        
        JLabel emailValue = new JLabel(patient.getEmail());
        emailValue.setFont(normalFont);
        emailValue.setBounds(120, 130, 300, 20);
        panel.add(emailValue);
        
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(boldFont);
        addressLabel.setBounds(10, 160, 100, 20);
        panel.add(addressLabel);
        
        JLabel addressValue = new JLabel(patient.getAddress());
        addressValue.setFont(normalFont);
        addressValue.setBounds(120, 160, 300, 20);
        panel.add(addressValue);
        
        
        JLabel guardianLabel = new JLabel("Guardian:");
        guardianLabel.setFont(boldFont);
        guardianLabel.setBounds(10, 190, 100, 20);
        panel.add(guardianLabel);
        
        JLabel guardianValue = new JLabel(patient.getGuardianName());
        guardianValue.setFont(normalFont);
        guardianValue.setBounds(120, 190, 300, 20);
        panel.add(guardianValue);
        
        JLabel guardianContactLabel = new JLabel("Guardian Contact:");
        guardianContactLabel.setFont(boldFont);
        guardianContactLabel.setBounds(10, 220, 150, 20);
        panel.add(guardianContactLabel);
        
        JLabel guardianContactValue = new JLabel(patient.getGuardianContact());
        guardianContactValue.setFont(normalFont);
        guardianContactValue.setBounds(160, 220, 300, 20);
        panel.add(guardianContactValue);
        
        JLabel relationshipLabel = new JLabel("Relationship:");
        relationshipLabel.setFont(boldFont);
        relationshipLabel.setBounds(10, 250, 100, 20);
        panel.add(relationshipLabel);
        
        JLabel relationshipValue = new JLabel(patient.getRelationship());
        relationshipValue.setFont(normalFont);
        relationshipValue.setBounds(120, 250, 300, 20);
        panel.add(relationshipValue);
        
       
        JLabel roomLabel = new JLabel("Assigned Room:");
        roomLabel.setFont(boldFont);
        roomLabel.setBounds(10, 280, 150, 20);
        panel.add(roomLabel);
        
        JLabel roomValue = new JLabel(patient.getAssignedRoom() != null ? 
                                      patient.getAssignedRoom().getType() : "Not Assigned");
        roomValue.setFont(normalFont);
        roomValue.setBounds(160, 280, 300, 20);
        panel.add(roomValue);
        
        
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(boldFont);
        statusLabel.setBounds(10, 310, 100, 20);
        panel.add(statusLabel);
        
        JLabel statusValue = new JLabel(patient.isDischarged() ? "Discharged" : "Admitted");
        statusValue.setFont(normalFont);
        statusValue.setBounds(120, 310, 300, 20);
        panel.add(statusValue);
        
      
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(180, 350, 100, 30);
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