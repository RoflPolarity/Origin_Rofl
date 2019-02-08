import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
public class vote {
    Main vote=new Main();
    save save1 = new save();
    Main1 arr = new Main1();
        public  void vale (String name) throws SQLException {
            vote.open();
            ResultSet rs = vote.connection_Query("SELECT Классы FROM teach WHERE Имя = " + "'" + name +"'");
        String classes = rs.getString("Классы");
        String [] words = classes.split(",");
        JFrame frame = new JFrame("Выбор класса");
        ImageIcon icon = new ImageIcon("legion2.png");
        frame.setIconImage(icon.getImage());
        JPanel panel = new JPanel();
        JComboBox comboBox = new JComboBox(words);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu newMenu = new JMenu("Новый файл");
            String[] items = {
                    "1 триместр",
                    "2 триместр",
                    "3 триместр"
            };
            JComboBox comboBox1 = new JComboBox(items);
            panel.add(comboBox1);
        fileMenu.add(newMenu);
            String finalName = name;
        JMenuItem txtFileItem = new JMenuItem("Текстовый файл");
        newMenu.add(txtFileItem);
        JMenuItem imgFileItem = new JMenuItem("Изображение");
        newMenu.add(imgFileItem);
        final String [][] tabledata = arr.transformArrayList(arr.getNames());
        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    leonid.main(save1.read_teable(tabledata),comboBox.getSelectedItem().toString(),finalName,comboBox1.getSelectedItem().toString());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        fileMenu.add(openItem);
        JMenuItem helpFileItem = new JMenuItem("Помощь");
        fileMenu.add(helpFileItem);

        fileMenu.addSeparator();
        JMenuItem closeItem = new JMenuItem("Выйти");
        fileMenu.add(closeItem);
        JMenuItem closeAllItem = new JMenuItem("Сохранить и выйти");
        fileMenu.add(closeAllItem);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        panel.add(comboBox);

        JButton jbt = new JButton("Далее");


            jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals(words[0])){
                    leonid.main(tabledata,comboBox.getSelectedItem().toString(), finalName,comboBox1.getSelectedItem().toString());
                }else if (comboBox.getSelectedItem().equals(words[1])){
                    System.out.println("Этот класс еще не готов(");
                }else if (comboBox.getSelectedItem().equals(words[2])){
                    System.out.println("Этот касс еще не готов");
                }
            }
        });
        panel.add(jbt);
        menuBar.add(fileMenu);
        frame.setBounds(dimension.width/2 - 150, dimension.height/2 - 75, 300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        name = (String) comboBox.getSelectedItem();
        vote.close();
    }
}
