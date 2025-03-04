import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Register extends JFrame {
    private RoomManager roomManager;
    private PatientManager patientManager;
    private Patient patientToEdit;

    private JTextField surname, first, middle, number, email, ress;
    private JComboBox<String> bdaymonth, bdaydays, bdayyears;
    private JRadioButton male, female;
    private ButtonGroup genders;
    private JTextField guardianNameField, guardianContactField, relationshipField;

    public Register(RoomManager roomManager, PatientManager patientManager) {
        this(roomManager, patientManager, null);
    }

    public Register(RoomManager roomManager, PatientManager patientManager, Patient patientToEdit) { 
        this.roomManager = roomManager; 
        this.patientManager = patientManager;
        this.patientToEdit = patientToEdit;

        setTitle("Register Patient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);
        setLayout(null);

        JLabel info = new JLabel("Fill out patient's information");
        info.setBounds(30,20,200,50);
        add(info);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(30,75,150,50);
        add(name);

        JLabel surexample = new JLabel("Surname");
        surexample.setBounds(127,99,200,50);
        add(surexample);
        JLabel firexample = new JLabel("First Name");
        firexample.setBounds(264,99,200,50);
        add(firexample);
        JLabel midexample = new JLabel("Middle Name");
        midexample.setBounds(401,99,200,50);
        add(midexample);

        surname = new JTextField();
        surname.setBounds(125,89, 125, 25);
        add(surname);
        first = new JTextField();
        first.setBounds(260,89, 125, 25);
        add(first);
        middle = new JTextField();
        middle.setBounds(395,89, 125, 25);
        add(middle);

        JLabel bday = new JLabel("Birth Date:");
        bday.setBounds(30,140,150, 50);
        add(bday);

        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        bdaymonth = new JComboBox<>(months);
        bdaymonth.setBounds(125,153,100,25);
        add(bdaymonth);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.format("%02d", i + 1);
        }
        bdaydays = new JComboBox<>(days);
        bdaydays.setBounds(260,153,100,25);
        add(bdaydays);

        String[] years = new String[100];
        for (int i = 0; i < years.length; i++) {
            years[i] = 2025 - i + "";
        }
        bdayyears = new JComboBox<>(years);
        bdayyears.setBounds(395,153,100,25);
        add(bdayyears);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30,190,150, 50);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(125,203,70,25);
        female = new JRadioButton("Female");
        female.setBounds(200,203,100,25);
        genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        add(male);
        add(female);

        JLabel contact = new JLabel("Contact Information:");
        contact.setBounds(30,235,150, 50);
        add(contact);

        JLabel numinfo = new JLabel("Contact Number");
        numinfo.setBounds(115,300,150, 50);
        add(numinfo);
        JLabel emailinfo = new JLabel("Email");
        emailinfo.setBounds(315,300,150, 50);
        add(emailinfo);

        number = new JTextField();
        number.setBounds(100,285, 150, 25);
        add(number);
        email = new JTextField();
        email.setBounds(300,285, 150, 25);
        add(email);

        JLabel address = new JLabel("Address:");
        address.setBounds(30,337,150, 50);
        add(address);

        ress = new JTextField();
        ress.setBounds(100, 350, 350, 25);
        add(ress);

        
        JLabel guardianLabel = new JLabel("Guardian Information:");
        guardianLabel.setBounds(30, 380, 150, 50);
        add(guardianLabel);

        JLabel guardianNameLabel = new JLabel("Guardian Name:");
        guardianNameLabel.setBounds(30, 420, 100, 25);
        add(guardianNameLabel);
        guardianNameField = new JTextField();
        guardianNameField.setBounds(140, 420, 200, 25);
        add(guardianNameField);

        JLabel guardianContactLabel = new JLabel("Guardian Contact:");
        guardianContactLabel.setBounds(30, 450, 100, 25);
        add(guardianContactLabel);
        guardianContactField = new JTextField();
        guardianContactField.setBounds(140, 450, 200, 25);
        add(guardianContactField);

        JLabel relationshipLabel = new JLabel("Relationship:");
        relationshipLabel.setBounds(30, 480, 100, 25);
        add(relationshipLabel);
        relationshipField = new JTextField();
        relationshipField.setBounds(140, 480, 200, 25);
        add(relationshipField);


        JButton back = new JButton("Back");
        back.setBounds(30,520,65,20);
        add(back);

        JButton clear = new JButton("Clear");
        clear.setBounds(105,520,65,20);
        add(clear);

        JButton next = new JButton("Next");
        next.setBounds(490,520,65,20);
        add(next);

        if (patientToEdit != null) {
            populateFields(patientToEdit);
        }

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                surname.setText(""); first.setText(""); middle.setText("");
                bdaymonth.setSelectedIndex(0); bdaydays.setSelectedIndex(0); bdayyears.setSelectedIndex(0);
                genders.clearSelection();
                number.setText(""); email.setText("");
                ress.setText("");
                guardianNameField.setText("");
                guardianContactField.setText("");
                relationshipField.setText("");
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Menu frame1 = new Menu(patientManager);
                frame1.setVisible(true);
                dispose();
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Patient patient = createPatient();
                    RoomAssignment roomAssignmentFrame = new RoomAssignment(roomManager, patient, patientManager);
                    roomAssignmentFrame.setVisible(true);
                    dispose();
                }
            }
        });

        setLocationRelativeTo(null);
    }

    private void populateFields(Patient patient) {
        surname.setText(patient.getSurname());
        first.setText(patient.getFirstName());
        middle.setText(patient.getMiddleName());

        String[] birthDateParts = patient.getBirthDate().split(" ");
        bdaydays.setSelectedItem(birthDateParts[0]);
        bdaymonth.setSelectedItem(birthDateParts[1]);
        bdayyears.setSelectedItem(birthDateParts[2]);

        if (patient.getGender().equals("Male")) {
            male.setSelected(true);
        } else {
            female.setSelected(true);
        }

        number.setText(patient.getContactNumber());
        email.setText(patient.getEmail());
        ress.setText(patient.getAddress());
        guardianNameField.setText(patient.getGuardianName());
        guardianContactField.setText(patient.getGuardianContact());
        relationshipField.setText(patient.getRelationship());
    }

    private boolean validateFields() {
        if (surname.getText().trim().isEmpty() || first.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Surname and First Name are required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a gender.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (guardianNameField.getText().trim().isEmpty() ||
            guardianContactField.getText().trim().isEmpty() ||
            relationshipField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all guardian information fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Patient createPatient() {
        String patientSurname = surname.getText().trim();
        String patientFirstName = first.getText().trim();
        String patientMiddleName = middle.getText().trim();
        String patientBirthDate = bdaydays.getSelectedItem() + " " + bdaymonth.getSelectedItem() + " " + bdayyears.getSelectedItem();
        String patientGender = male.isSelected() ? "Male" : "Female";
        String patientContactNumber = number.getText().trim();
        String patientEmail = email.getText().trim();
        String patientAddress = ress.getText().trim();
        String guardianName = guardianNameField.getText().trim();
        String guardianContact = guardianContactField.getText().trim();
        String relationship = relationshipField.getText().trim();

        if (patientToEdit != null) {
            // Update existing patient
            patientToEdit.setSurname(patientSurname);
            patientToEdit.setFirstName(patientFirstName);
            patientToEdit.setMiddleName(patientMiddleName);
            patientToEdit.setBirthDate(patientBirthDate);
            patientToEdit.setGender(patientGender);
            patientToEdit.setContactNumber(patientContactNumber);
            patientToEdit.setEmail(patientEmail);
            patientToEdit.setAddress(patientAddress);
            patientToEdit.setGuardianName(guardianName);
            patientToEdit.setGuardianContact(guardianContact);
            patientToEdit.setRelationship(relationship);
            return patientToEdit;
        } else {
            // Create new patient
            return new Patient(patientSurname, patientFirstName, patientMiddleName, patientBirthDate,
                    patientGender, patientContactNumber, patientEmail, patientAddress,
                    guardianName, guardianContact, relationship);
        }
    }
}

