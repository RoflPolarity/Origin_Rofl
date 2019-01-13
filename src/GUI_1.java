import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GUI_1 {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension size = kit.getScreenSize();
    Connection con;
    Main prog = new Main();
    void main_GUI(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setBounds(size.width/2 - 250, size.height/2 - 150, 250, 150);
        JButton button_a = new JButton("Далее");
        TextField username = new TextField(20);
        JLabel name = new JLabel("Введите ваше имя");
        username.setBackground(Color.lightGray);
        panel.add(name);
        panel.add(username);
        panel.add(button_a);
        button_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.getText().equals("")){
                    System.out.println("Введите текст");
                } else {String name = username.getText() ;
                    String people = prog.valid_name(name);
                    String [] classes = people.split(",");
                    for (int i = 0; i<classes.length; i++){
                        System.out.println(classes[i] + " ");
                    }
                }
            }
        });
        if (prog.open()){
            button_a.setBackground(Color.green);
        }else button_a.setBackground(Color.red);
            panel.revalidate();
    }
    void second_window() {
        JFrame second_frame = new JFrame();
        second_frame.setVisible(true);
        second_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel_2 = new JPanel();
        second_frame.add(panel_2);
        second_frame.setBounds(size.width/2 - 250, size.height/2 - 150,500 , 300);

    }
}