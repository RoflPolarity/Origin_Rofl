import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class GUI_1 {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension size = kit.getScreenSize();
    Main prog = new Main();
    JButton button_a;
    ArrayList<String> teach;
    void main_GUI() throws SQLException {
        vote make = new vote();
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("src/legion2.png");
        JPanel panel = new JPanel();
        button_a = new JButton("Далее");
        TextField username = new TextField(20);
        JLabel name = new JLabel("Введите ваше имя");
        teach = new ArrayList<>();
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        buttonColor();
        panel.setVisible(true);
        panel.add(name);
        name.setVisible(true);
        panel.add(username);
        panel.add(button_a);
        frame.pack();
        frame.setBounds(size.width / 2 - 250, size.height / 2 - 150, 250, 150);
        username.setBackground(Color.lightGray);
        names();
        button_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.getText().equals("")) {
                    System.out.println("Введите текст");
                } else {
                    for (int i=0;i<teach.size();i++){
                            if (username.getText().equals(teach.get(i))){
                                String names = username.getText();
                                frame.setVisible(false);
                                try {
                                    if (username.getText().equals(teach.get(i))){
                                        make.vale(names);
                                }} catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                System.out.println("Введеное вами имя не найдено (");
                            }
                    }
                        }
                    }
            });

    }
    ArrayList<String> names () throws SQLException {
        ResultSet rs = prog.connection_Query("SELECT Имя, Классы FROM teach;");
        while (rs.next()) {
            teach.add(rs.getString("Имя"));
        }
        return teach;
    }
    void buttonColor (){if (prog.open()) {
        button_a.setBackground(Color.green);
    } else button_a.setBackground(Color.red);}
  }
