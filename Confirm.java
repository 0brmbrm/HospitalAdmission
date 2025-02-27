import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;

public class Confirm extends JFrame{
    public Confirm(){
        setTitle("Confirm Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);
        setLayout(null);

        JTextArea info = new JTextArea();
        info.setBounds(50,50,470,450);
        info.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        info.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        add(info);

    }
}
