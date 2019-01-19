import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class leonid  {
    static String [] [] tebledata;
    static Toolkit kit = Toolkit.getDefaultToolkit();
    static Dimension size = kit.getScreenSize();
    static leonid len = new leonid();
    public static void main(String[] args){
        Timer timer1 = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                len.join(tebledata);
            }
        });
        leonid len = new leonid();
        JFrame frame = new JFrame ("Legion");
        frame.setResizable(false);
        frame.setSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        Main1 arr = new Main1();
            String names [] = {"ФИО","Профиль","Русский язык","Алгебра","Геометрия","Химия","Физика","Литература","География","Искусство","Физ.Культура","Информатика","Англ.Изык","Обществознание","История"};
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
        timer1.start();
        frame.add(bookTableScrollPane);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.setVisible(true);
        frame.pack();
        frame.revalidate();
    }
    String[][] join (String[][] array){
        return array;
    }
}
