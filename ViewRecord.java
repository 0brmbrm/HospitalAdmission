import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewRecord extends JFrame {
    private PatientManager patientManager;
    private JTable patientTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton, viewDetailsButton, dischargeButton, backButton;
    
    public ViewRecord(PatientManager patientManager) {
        this.patientManager = patientManager;
        
        setTitle("View Patient Records");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        
       
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        searchPanel.add(new JLabel("Search by Surname:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        
        searchButton = new JButton("Search");
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);
        
        
        String[] columns = {"Surname", "First Name", "Middle Name", "Birth Date", "Gender", "Room Type", "Status"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        patientTable = new JTable(tableModel);
        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        patientTable.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(patientTable);
        add(scrollPane, BorderLayout.CENTER);
        
      
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        backButton = new JButton("Back to Menu");
        viewDetailsButton = new JButton("View Details");
        dischargeButton = new JButton("Discharge Patient");
        
        buttonPanel.add(backButton);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(dischargeButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
       
        loadPatientData();
        
       
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPatients();
            }
        });
        
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatientDetails();
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
        
        dischargeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dischargePatient();
            }
        });
        
        setLocationRelativeTo(null);
    }
    
    private void loadPatientData() {
        tableModel.setRowCount(0);
        
        List<Patient> patients = patientManager.getAllPatients();
        if (patients.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No patient records found.", 
                "Information", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        for (Patient patient : patients) {
            addPatientToTable(patient);
        }
    }
    
    private void addPatientToTable(Patient patient) {
        String roomType = patient.getAssignedRoom() != null ? 
                          patient.getAssignedRoom().getType() : "Not Assigned";
        String status = patient.isDischarged() ? "Discharged" : "Admitted";
        
        Object[] row = {
            patient.getSurname(),
            patient.getFirstName(),
            patient.getMiddleName(),
            patient.getBirthDate(),
            patient.getGender(),
            roomType,
            status
        };
        
        tableModel.addRow(row);
    }
    
    private void searchPatients() {
        String searchTerm = searchField.getText().trim();
        
        if (searchTerm.isEmpty()) {
            loadPatientData();
            return;
        }
        
        tableModel.setRowCount(0);
        
        if (patientManager == null) {
            return;
        }
        
        List<Patient> patients = patientManager.getAllPatients();
        for (Patient patient : patients) {
            if (patient.getSurname().toLowerCase().contains(searchTerm.toLowerCase())) {
                addPatientToTable(patient);
            }
        }
        
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "No matching records found.", 
                "Search Results", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void viewPatientDetails() {
        int selectedRow = patientTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a patient to view details.", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String surname = (String) tableModel.getValueAt(selectedRow, 0);
        String firstName = (String) tableModel.getValueAt(selectedRow, 1);
        
        Patient patient = patientManager.findPatientByName(surname, firstName);
        
        if (patient != null) {
            PatientDetailsDialog detailsDialog = new PatientDetailsDialog(this, patient);
            detailsDialog.setVisible(true);
        }
    }
    
    private void dischargePatient() {
        int selectedRow = patientTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a patient to discharge.", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String surname = (String) tableModel.getValueAt(selectedRow, 0);
        String firstName = (String) tableModel.getValueAt(selectedRow, 1);
        
        Patient patient = patientManager.findPatientByName(surname, firstName);
        
        if (patient != null) {
            if (patient.isDischarged()) {
                JOptionPane.showMessageDialog(this, 
                    "This patient has already been discharged.", 
                    "Already Discharged", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to discharge this patient?",
                    "Confirm Discharge",
                    JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    patient.setDischarged(true);
                    if (patient.getAssignedRoom() != null) {
                        patient.getAssignedRoom().free();
                        patient.setAssignedRoom(null);
                    }
                    JOptionPane.showMessageDialog(this, 
                        "Patient has been discharged.", 
                        "Discharge Successful", 
                        JOptionPane.INFORMATION_MESSAGE);
                    loadPatientData(); 
                }
            }
        }
    }
}

