import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;

//.
public class leonid  {
    private static String [] [] tebledata;
    static Toolkit kit = Toolkit.getDefaultToolkit();
    static Dimension size = kit.getScreenSize();
    public static void main(String[][] tebledata){
         leonid len = new leonid();
         save save1 = new save();
         Main1 arr = new Main1();
        Timer timer1 = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        JFrame frame = new JFrame ("Legion");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu newMenu = new JMenu("Новый файл");
        fileMenu.add(newMenu);
        JMenuItem txtFileItem = new JMenuItem("Текстовый файл");
        newMenu.add(txtFileItem);
        JMenuItem imgFileItem = new JMenuItem("Изображение");
        newMenu.add(imgFileItem);
        JMenuItem openItem = new JMenuItem("Открыть");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        JMenuItem closeItem = new JMenuItem("Выйти");
        fileMenu.add(closeItem);
        JMenuItem closeAllItem = new JMenuItem("Сохранить и выйти");
        fileMenu.add(closeAllItem);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2, dimension.height/2 - 150, 1300,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

            String names [] = {"ФИО","Русский язык","Алгебра","Геометрия","Химия","Физика","Литература","География","Искусство","Физ.Культура","Информатика","Англ.Язык","Обществознание","История"};
        JButton deleteButton = new JButton("Назад");
        JButton clearButton = new JButton("Сформировать отчет");
        BookTableModel btm = new BookTableModel();
        tebledata = arr.transformArrayList(arr.getNames());
        JTable bookTable = new JTable(tebledata,names);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(1100,250));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        String[][] finalTebledata = tebledata;
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    save1.update_table(len.join(finalTebledata));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        timer1.start();
        frame.add(bookTableScrollPane);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.setVisible(true);
        frame.pack();
        frame.revalidate();
    }
    String [] [] join (String[][] array){
      return array;
    }
}
