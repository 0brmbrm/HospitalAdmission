import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomAssignment extends JFrame {
    private RoomManager roomManager;
    private Patient patient;
    private JComboBox<Room> roomComboBox;

    public RoomAssignment(RoomManager roomManager, Patient patient) {
        this.roomManager = roomManager;
        this.patient = patient;

        setTitle("Room Assignment");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Select Room:"));
        roomComboBox = new JComboBox<>(roomManager.getAvailableRooms().toArray(new Room[0]));
        add(roomComboBox);

        JButton assignButton = new JButton("Assign Room");
        add(assignButton);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Room selectedRoom = (Room) roomComboBox.getSelectedItem();
                if (selectedRoom != null) {
                    roomManager.assignRoom(selectedRoom); 
                    patient.setAssignedRoom(selectedRoom);
                    JOptionPane.showMessageDialog(RoomAssignment.this, 
                        "Room " + selectedRoom.getType() + " assigned successfully to " + patient.getFirstName() + " " + patient.getSurname());
                    new Confirm(patient); 
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RoomAssignment.this, "No room selected or available.");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}