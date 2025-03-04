import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RoomAssignment extends JFrame {
    private RoomManager roomManager;
    private PatientManager patientManager;
    private Patient patient;
    private JComboBox<Room> roomComboBox;

    public RoomAssignment(RoomManager roomManager, Patient patient, PatientManager patientManager) {
        this.roomManager = roomManager;
        this.patient = patient;
        this.patientManager = patientManager;

        setTitle("Room Assignment");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Select Room:"));

        // Check if there are available rooms
        if (roomManager.getAvailableRooms().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No rooms are available.", "No Rooms", JOptionPane.WARNING_MESSAGE);
            // Add a dummy item to prevent null pointer
            roomComboBox = new JComboBox<>(new Room[]{new Room("No Available Rooms")});
        } else {
            roomComboBox = new JComboBox<>(roomManager.getAvailableRooms().toArray(new Room[0]));
        }
        add(roomComboBox);

        JButton assignButton = new JButton("Assign Room");
        add(assignButton);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Room selectedRoom = (Room) roomComboBox.getSelectedItem();

                if (selectedRoom == null || selectedRoom.getType().equals("No Available Rooms")) {
                    JOptionPane.showMessageDialog(RoomAssignment.this, "No room selected or available.");
                    return; 
                }

                roomManager.assignRoom(selectedRoom);
                patient.setAssignedRoom(selectedRoom);

                JOptionPane.showMessageDialog(RoomAssignment.this, 
                    "Room " + selectedRoom.getType() + " assigned successfully to " + patient.getFirstName() + " " + patient.getSurname());

                new Confirm(patient, patientManager, roomManager).setVisible(true); 
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

