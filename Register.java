import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Register extends JFrame {
    public Register() {
        setTitle("Register Patient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 525);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel info = new JLabel("Fill out patient's information");
        info.setBounds(30, 20, 200, 50);
        add(info);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(30, 75, 150, 50);
        add(name);

        JLabel surexample = new JLabel("Surname");
        surexample.setBounds(127, 99, 200, 50);
        add(surexample);
        JLabel firexample = new JLabel("First Name");
        firexample.setBounds(264, 99, 200, 50);
        add(firexample);
        JLabel midexample = new JLabel("Middle Name");
        midexample.setBounds(401, 99, 200, 50);
        add(midexample);

        JTextField surname = new JTextField();
        surname.setBounds(125, 89, 125, 25);
        add(surname);
        JTextField first = new JTextField();
        first.setBounds(260, 89, 125, 25);
        add(first);
        JTextField middle = new JTextField();
        middle.setBounds(395, 89, 125, 25);
        add(middle);

        JLabel bday = new JLabel("Birth Date:");
        bday.setBounds(30, 140, 150, 50);
        add(bday);

        String[] months = {"January", "February", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> bdaymonth = new JComboBox<>(months);
        bdaymonth.setBounds(125, 153, 100, 25);
        add(bdaymonth);

        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> bdaydays = new JComboBox<>(days);
        bdaydays.setBounds(260, 153, 100, 25);
        add(bdaydays);

        String[] years = new String[100];
        for (int i = 0; i < years.length; i++) {
            years[i] = 2025 - i + "";
        }
        JComboBox<String> bdayyears = new JComboBox<>(years);
        bdayyears.setBounds(395, 153, 100, 25);
        add(bdayyears);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30, 190, 150, 50);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(125, 203, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(200, 203, 100, 25);
        ButtonGroup genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        add(male);
        add(female);

        JLabel contact = new JLabel("Contact Information:");
        contact.setBounds(30, 235, 150, 50);
        add(contact);

        JLabel numinfo = new JLabel("Contact Number");
        numinfo.setBounds(115, 300, 150, 50);
        add(numinfo);
        JLabel emailinfo = new JLabel("Email");
        emailinfo.setBounds(315, 300, 150, 50);
        add(emailinfo);

        JTextField number = new JTextField();
        number.setBounds(100, 285, 150, 25);
        add(number);
        JTextField email = new JTextField();
        email.setBounds(300, 285, 150, 25);
        add(email);

        JLabel address = new JLabel("Address:");
        address.setBounds(30, 337, 150, 50);
        add(address);

        JTextField ress = new JTextField();
        ress.setBounds(100, 350, 350, 25);
        add(ress);

        JButton back = new JButton("Back");
        back.setBounds(30, 425, 65, 20);
        add(back);

        JButton clear = new JButton("Clear");
        clear.setBounds(105, 425, 65, 20);
        add(clear);

        JButton next = new JButton("Next");
        next.setBounds(490, 425, 65, 20);
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
              
                if (surname.getText().isEmpty() || first.getText().isEmpty() || middle.getText().isEmpty() ||
                    number.getText().isEmpty() || email.getText().isEmpty() || ress.getText().isEmpty() ||
                    (!male.isSelected() && !female.isSelected())) {
                    
                    JOptionPane.showMessageDialog(Register.this, "Please fill out all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    
                    JFrame frame3 = new KinInfo();
                    frame3.setVisible(true);
                    dispose(); 
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Register()); 
    }
}