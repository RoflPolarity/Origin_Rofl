import javafx.geometry.VerticalDirection;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;



public class leonid  {
    static Toolkit kit = Toolkit.getDefaultToolkit();
    static Dimension size = kit.getScreenSize();
    public static void main(String[][] tabled){
        JFrame frame = new JFrame ("Legion");
        ImageIcon icon = new ImageIcon("src/legion2.png");
        frame.setIconImage(icon.getImage());
         leonid len = new leonid();
         save save1 = new save();
        Timer timer1 = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JPanel panel = new JPanel();
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
        Main1 arr = new Main1();
        String names [] = {"ФИО","Русский язык","Алгебра","Геометрия","Химия","Физика","Литература","География","Искусство","Физ.Культура","Информатика","Англ.Язык","Обществознание","История"};
        JPanel grid1 = new JPanel(new GridLayout(1, 2, 5, 0) );
        grid1.add (new JButton("Назад"    ));
        grid1.add (new JButton("Сформировать отчет"));
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid1);
        frame.getContentPane();
        frame.add(flow, BorderLayout.SOUTH);
        JTable bookTable = new JTable(tabled,names);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(1100,250));

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    save1.update_table(len.join(tabled));
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
        frame.setVisible(true);
        timer1.start();
        frame.add(bookTableScrollPane);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.revalidate();
    }
    String [] [] join (String[][] array){
      return array;
    }
}
