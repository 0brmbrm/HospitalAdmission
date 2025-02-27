import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame{
        public Menu(){
        setTitle("Hospital Admission");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        setLayout(null);
        
        JButton button1 = new JButton("Register Patient");
        button1.setBounds(150,50,200,50);
        add(button1);

        JButton button2 = new JButton("View Record");
        button2.setBounds(150,130,200,50);
        add(button2);

        JButton button3 = new JButton("Update Record");
        button3.setBounds(150,210,200,50);
        add(button3);

        JButton button4 = new JButton("Discharge Patient");
        button4.setBounds(150,290,200,50);
        add(button4);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame frame2 = new Register();
                frame2.setVisible(true);
                dispose();
            }
        });
    }
}
