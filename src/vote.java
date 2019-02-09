import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
public class vote {
    private Main vote=new Main();
    private save save1 = new save();
    private Main1 arr = new Main1();
    private help HelpItem1 = new help();
    public JFrame frame = new JFrame("Выбор класса");
        void vale(String name) throws SQLException {
            vote.open();
            ResultSet rs = vote.connection_Query("SELECT Классы FROM teach WHERE Имя = " + "'" + name +"'");
        String classes = rs.getString("Классы");
        String [] words = classes.split(",");

        ImageIcon icon = new ImageIcon("legion2.png");
        frame.setIconImage(icon.getImage());
        JPanel panel = new JPanel();
        JComboBox comboBox = new JComboBox(words);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
            String[] items = {
                    "1 триместр",
                    "2 триместр",
                    "3 триместр",
                    "Годовая"
            };
            JComboBox comboBox1 = new JComboBox(items);
            panel.add(comboBox1);
            String finalName = name;
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
        fileMenu.addSeparator();
            JMenuItem HelpItem = new JMenuItem("Помощь");;
            String finalName1 = name;
            HelpItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    HelpItem1.help(finalName1);
                }
            });
            fileMenu.add(HelpItem);
        JMenuItem closeItem = new JMenuItem("Выйти");
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fileMenu.add(closeItem);

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
