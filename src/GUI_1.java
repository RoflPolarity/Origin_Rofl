import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class GUI_1 {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension size = kit.getScreenSize();
    Main prog = new Main();
    void main_GUI() throws SQLException {
        vote make = new vote();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setBounds(size.width / 2 - 250, size.height / 2 - 150, 250, 150);
        JButton button_a = new JButton("Далее");
        TextField username = new TextField(20);
        JLabel name = new JLabel("Введите ваше имя");
        username.setBackground(Color.lightGray);
        String query = "SELECT Имя, Классы FROM teach;";
        ResultSet rs = prog.connection_Query(query);
        ArrayList<String> teach = new ArrayList<>();
        while (rs.next()) {
            teach.add(rs.getString("Имя"));
        }
        panel.add(name);
        panel.add(username);
        panel.add(button_a);
        button_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.getText().equals("")) {
                    System.out.println("Введите текст");
                } else {
                    for (int i=0;i<teach.size();i++){
                            if (username.getText().equals(teach.get(0))){
                                String names = username.getText();
                                frame.setVisible(false);
                                try {
                                    make.vale(names);
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                System.out.println("Введеное вами имя не найдено (");
                            }
                    }
                        }
                    }
            });
        if (prog.open()) {
            button_a.setBackground(Color.green);
        } else button_a.setBackground(Color.red);
    }
  }
