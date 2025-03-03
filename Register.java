import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Patient {
    private String surname, firstName, middleName, birthDate, gender, contactNumber, email, address;
    private String guardianName, guardianContact, relationship;

    public Patient(String surname, String firstName, String middleName, String birthDate, String gender,
                   String contactNumber, String email, String address) {
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}



public class Register extends JFrame {
    private JTextField surname, first, middle, number, email, ress;
    private JTextField ksurname, kfirst, kmiddle, knumber, kemail, relationshipField;
    private JComboBox<String> bdaymonth, bdaydays, bdayyears;
    private ButtonGroup genders;

    public Register() {
        setTitle("Register Patient and Guardian");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1015, 550);
        setResizable(false);
        setLayout(null);

        JLabel info = new JLabel("Fill out patient's information");
        info.setBounds(20, 20, 200, 50);
        add(info);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(20, 75, 150, 50);
        add(name);

        JLabel surexample = new JLabel("Surname");
        surexample.setBounds(95, 99, 200, 50);
        add(surexample);
        JLabel firexample = new JLabel("First Name");
        firexample.setBounds(230, 99, 200, 50);
        add(firexample);
        JLabel midexample = new JLabel("Middle Name");
        midexample.setBounds(365, 99, 200, 50);
        add(midexample);

        surname = new JTextField();
        surname.setBounds(90, 89, 125, 25);
        add(surname);
        first = new JTextField();
        first.setBounds(225, 89, 125, 25);
        add(first);
        middle = new JTextField();
        middle.setBounds(360, 89, 125, 25);
        add(middle);

        JLabel bday = new JLabel("Birth Date:");
        bday.setBounds(20, 140, 150, 50);
        add(bday);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        bdaymonth = new JComboBox<>(months);
        bdaymonth.setBounds(90, 153, 100, 25);
        add(bdaymonth);

        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        bdaydays = new JComboBox<>(days);
        bdaydays.setBounds(225, 153, 100, 25);
        add(bdaydays);

        String[] years = new String[100];
        for (int i = 0; i < years.length; i++) {
            years[i] = 2025 - i + "";
        }
        bdayyears = new JComboBox<>(years);
        bdayyears.setBounds(360, 153, 100, 25);
        add(bdayyears);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(20, 190, 150, 50);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(90, 203, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(150, 203, 100, 25);
        genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        add(male);
        add(female);

        JLabel contact = new JLabel("Contact Information:");
        contact.setBounds(20, 225, 150, 50);
        add(contact);

        JLabel numinfo = new JLabel("Contact Number");
        numinfo.setBounds(115, 280, 150, 50);
        add(numinfo);
        JLabel emailinfo = new JLabel("Email");
        emailinfo.setBounds(315, 280, 150, 50);
        add(emailinfo);

        number = new JTextField();
        number.setBounds(100, 270, 150, 25);
        add(number);
        email = new JTextField();
        email.setBounds(300, 270, 150, 25);
        add(email);

        JLabel address = new JLabel("Address:");
        address.setBounds(20, 325, 150, 50);
        add(address);

        ress = new JTextField();
        ress.setBounds(100, 340, 350, 25);
        add(ress);

        JSeparator sep = new JSeparator(SwingConstants.VERTICAL);
        sep.setBounds(480, 20, 10, 450);
        add(sep);

        JLabel kinfo = new JLabel("Fill out guardian's information");
        kinfo.setBounds(520, 20, 200, 50);
        add(kinfo);

        JLabel kname = new JLabel("Full Name:");
        kname.setBounds(520, 75, 150, 50);
        add(kname);

        JLabel ksurexample = new JLabel("Surname");
        ksurexample.setBounds(595, 99, 200, 50);
        add(ksurexample);
        JLabel kfirexample = new JLabel("First Name");
        kfirexample.setBounds(730, 99, 200, 50);
        add(kfirexample);
        JLabel kmidexample = new JLabel("Middle Name");
        kmidexample.setBounds(865, 99, 200, 50);
        add(kmidexample);

        ksurname = new JTextField();
        ksurname.setBounds(590, 89, 125, 25);
        add(ksurname);
        kfirst = new JTextField();
        kfirst.setBounds(725, 89, 125, 25);
        add(kfirst);
        kmiddle = new JTextField();
        kmiddle.setBounds(860, 89, 125, 25);
        add(kmiddle);

        JLabel relation = new JLabel("Relationship to Patient:");
        relation.setBounds(520, 140, 150, 50);
        add(relation);

        String[] relate = {"Spouse", "Mother", "Father", "Child", "Others"};
        JComboBox<String> relationPatient = new JComboBox<>(relate);
        relationPatient.setBounds(595, 190, 100, 25);
        add(relationPatient);

        JLabel specify = new JLabel("If others, specify");
        specify.setBounds(730, 210, 100, 25);
        add(specify);

        JTextField others = new JTextField();
        others.setBounds(725, 190, 150, 25);
        add(others);

        JLabel kcontact = new JLabel("Contact Information:");
        kcontact.setBounds(520, 225, 150, 50);
        add(kcontact);

        JLabel knuminfo = new JLabel("Contact Number");
        knuminfo.setBounds(615, 280, 150, 50);
        add(knuminfo);
        JLabel kemailinfo = new JLabel("Email");
        kemailinfo.setBounds(815, 280, 150, 50);
        add(kemailinfo);

        knumber = new JTextField();
        knumber.setBounds(600, 270, 150, 25);
        add(knumber);
        kemail = new JTextField();
        kemail.setBounds(800, 270, 150, 25);
        add(kemail);

        JButton back = new JButton("Back");
        back.setBounds(30, 450, 65, 20);
        add(back);

        JButton clear = new JButton("Clear");
        clear.setBounds(105, 450, 65, 20);
        add(clear);

        JButton next = new JButton("Next");
        next.setBounds(900, 450, 65, 20);
        add(next);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surname.setText("");
                first.setText("");
                middle.setText("");
                bdaymonth.setSelectedIndex(0);
                bdaydays.setSelectedIndex(0);
                bdayyears.setSelectedIndex(0);
                genders.clearSelection();
                number.setText("");
                email.setText("");
                ress.setText("");
                ksurname.setText("");
                kfirst.setText("");
                kmiddle.setText("");
                relationPatient.setSelectedIndex(0);
                others.setText("");
                knumber.setText("");
                kemail.setText("");
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu frame1 = new Menu();
                frame1.setVisible(true);
                dispose();
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientSurname = surname.getText();
                String patientFirstName = first.getText();
                String patientMiddleName = middle.getText();
                String patientBirthDate = bdaydays.getSelectedItem() + " " + bdaymonth.getSelectedItem() + " " + bdayyears.getSelectedItem();
                String patientGender = male.isSelected() ? "Male" : "Female";
                String patientContactNumber = number.getText();
                String patientEmail = email.getText();
                String patientAddress = ress.getText();

                Patient patient = new Patient(patientSurname, patientFirstName, patientMiddleName, patientBirthDate,
                        patientGender, patientContactNumber, patientEmail, patientAddress);

                String guardianFullName = ksurname.getText() + " " + kfirst.getText() + " " + kmiddle.getText();
                patient.setGuardianName(guardianFullName);
                patient.setGuardianContact(knumber.getText());
                patient.setRelationship(relationshipField.getText());
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Register register = new Register();
        register.setVisible(true);
    }
}