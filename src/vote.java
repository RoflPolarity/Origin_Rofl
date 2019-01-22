import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class vote {
    Main vote=new Main();
    save save1 = new save();
    Connection co;
    Main1 arr = new Main1();
    GUI_1 gui = new GUI_1();
    leonid len = new leonid();
    public  void vale (String name){
        String  out;
        try {
            vote.open();
        Statement st = co.createStatement();
        String query = "SELECT Классы FROM teach WHERE Имя = " + "'" + name +"'";
        ResultSet rs = st.executeQuery(query);
        String classes = rs.getString("Классы");
        String [] words = classes.split(",");
        }
        catch (Exception e){

        }

        JFrame frame = new JFrame("Выбор класса");
        JPanel panel = new JPanel();
        String[][] tebledata = arr.transformArrayList(arr.getNames());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu newMenu = new JMenu("Новый файл");
        fileMenu.add(newMenu);
        JMenuItem txtFileItem = new JMenuItem("Текстовый файл");
        newMenu.add(txtFileItem);
        JMenuItem imgFileItem = new JMenuItem("Изображение");
        newMenu.add(imgFileItem);
        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    len.main(save1.read_teable(tebledata));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        JMenuItem closeItem = new JMenuItem("Выйти");
        fileMenu.add(closeItem);
        JMenuItem closeAllItem = new JMenuItem("Сохранить и выйти");
        fileMenu.add(closeAllItem);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        String[] items = {"11A","11Б","10А"};
        JComboBox comboBox = new JComboBox(items);
        panel.add(comboBox);

        menuBar.add(fileMenu);
        frame.setResizable(false);
        frame.add(new JButton("Далее"), "South");
        frame.setBounds(dimension.width/2 - 150, dimension.height/2 - 75, 300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
