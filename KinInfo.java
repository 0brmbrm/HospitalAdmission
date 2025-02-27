import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KinInfo extends JFrame {
    public KinInfo(){
        setTitle("Kin/Guardian Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setLayout(null);

        JLabel info = new JLabel("Fill out guardian's information");
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

        JTextField surname = new JTextField();
        surname.setBounds(125,89, 125, 25);
        add(surname);
        JTextField first = new JTextField();
        first.setBounds(260,89, 125, 25);
        add(first);
        JTextField middle = new JTextField();
        middle.setBounds(395,89, 125, 25);
        add(middle);

        JLabel relation = new JLabel("Relationship to Patient:");
        relation.setBounds(30,150,150, 50);
        add(relation);

        String[] relate = {"Spouse","Mother","Father","Child","Others"};
        JComboBox<String> relationPatient = new JComboBox<>(relate);
        relationPatient.setBounds(150,200,100,25);
        add(relationPatient);

        JLabel specify = new JLabel("If others, specify");
        specify.setBounds(310,220,100,25);
        add(specify);
        
        JTextField others = new JTextField();
        others.setBounds(300,200,100,25);
        add(others);

    }
}
