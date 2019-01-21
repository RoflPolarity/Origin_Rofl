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
    public static void main(String[] args){
         leonid len = new leonid();
         save save1 = new save();
        Timer timer1 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                len.join(tebledata);
            }
        });
        JFrame frame = new JFrame ("Legion");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2, dimension.height/2 - 150, 1300,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        Main1 arr = new Main1();
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
                try {
                    save1.save_table(tebledata);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    save1.save_table(len.join(tebledata));
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
                try {
                    save1.read_teable(tebledata);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        timer1.start();
        frame.add(bookTableScrollPane);
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
