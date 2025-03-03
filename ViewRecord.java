import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewRecord extends JFrame {
    public ViewRecord(Patient patient) {
        setTitle("Patient Record");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 5, 5));

        addField("Name", patient.getSurname() + ", " + patient.getFirstName() + " " + patient.getMiddleName());
        addField("Birth Date", patient.getBirthDate());
        addField("Gender", patient.getGender());
        addField("Contact", patient.getContactNumber());
        addField("Email", patient.getEmail());
        addField("Address", patient.getAddress());
        addField("Guardian", patient.getGuardianName());
        addField("Guardian Contact", patient.getGuardianContact());
        addField("Relationship", patient.getRelationship());
        addField("Assigned Room", patient.getAssignedRoom() != null ? patient.getAssignedRoom().getType() : "Not assigned");

        JButton closeButton = new JButton("Close");
        add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addField(String label, String value) {
        add(new JLabel(label + ":"));
        add(new JLabel(value));
    }
}