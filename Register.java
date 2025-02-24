import javax.swing.*;

public class Register extends JFrame{
    public Register(){

        setTitle("Register Patient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setLayout(null);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(30,50,150,50);
        add(name);

        JLabel surexample = new JLabel("Surname");
        surexample.setBounds(125,85,200,50);
        add(surexample);
        JLabel firexample = new JLabel("First Name");
        firexample.setBounds(260,85,200,50);
        add(firexample);
        JLabel midexample = new JLabel("Middle Name");
        midexample.setBounds(395,85,200,50);
        add(midexample);

        JTextField surname = new JTextField();
        surname.setBounds(125,62, 125, 25);
        add(surname);
        JTextField first = new JTextField();
        first.setBounds(260,62, 125, 25);
        add(first);
        JTextField middle = new JTextField();
        middle.setBounds(395,62, 125, 25);
        add(middle);

        JLabel bday = new JLabel("Birth Date:");
        bday.setBounds(30,130,150, 50);
        add(bday);

        String[] months = {"January","February","March","April","May","Jun","July","August","September","October","November","December"};
        JComboBox<String> bdaymonth = new JComboBox<>(months);
        bdaymonth.setBounds(125,145,100,25);
        add(bdaymonth);

        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> bdaydays = new JComboBox<>(days);
        bdaydays.setBounds(260,145,100,25);
        add(bdaydays);

        String[] years = new String[50];
        for (int i = 0; i < years.length; i++) {
            years[i] = 1975 + i + "";}
        JComboBox<String> bdayyears = new JComboBox<>(years);
        bdayyears.setBounds(395,145,100,25);
        add(bdayyears);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30,210,150, 50);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(125,226,70,25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(200,226,100,25);
        ButtonGroup genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        add(male);
        add(female);



        



        setVisible(true);
    }

}
