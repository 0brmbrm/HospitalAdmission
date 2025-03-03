import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KinInfo extends JFrame {
    private JTextField guardianNameField, guardianContactField, relationshipField;
    private RoomManager roomManager;
    private Patient patient;

    public KinInfo(RoomManager roomManager, Patient patient) {
        this.roomManager = roomManager;
        this.patient = patient;

        setTitle("Guardian Information");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Guardian's Name:"));
        guardianNameField = new JTextField();
        add(guardianNameField);

        add(new JLabel("Guardian's Contact:"));
        guardianContactField = new JTextField();
        add(guardianContactField);

        add(new JLabel("Relationship to Patient:"));
        relationshipField = new JTextField();
        add(relationshipField);

        JButton nextButton = new JButton("Next");
        add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    updatePatient();
                    new RoomAssignment(roomManager, patient);
                    dispose();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean validateFields() {
        if (guardianNameField.getText().isEmpty() || guardianContactField.getText().isEmpty() || relationshipField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return false;
        }
        return true;
    }

    private void updatePatient() {
        patient.setGuardianName(guardianNameField.getText());
        patient.setGuardianContact(guardianContactField.getText());
        patient.setRelationship(relationshipField.getText());
    }
}