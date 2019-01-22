import javax.swing.*;
import javax.swing.text.View;
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



        // меню-флажки
        //JMenu newviewMenu = new JMenu("Вид");

            //JCheckBoxMenuItem line = new JCheckBoxMenuItem("Линейка");
           // JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Сетка");
            //JCheckBoxMenuItem naig = new JCheckBoxMenuItem("Навигация");
            // меню-переключатели
           // JRadioButtonMenuItem one = new JRadioButtonMenuItem("Одна страница");
           // JRadioButtonMenuItem two = new JRadioButtonMenuItem("Две страницы");
            // организуем переключатели в логическую группу
           // ButtonGroup bg = new ButtonGroup();
           // bg.add(one);
           // bg.add(two);
            // добавим все в меню
           // newviewMenu.add(line);
           // newviewMenu.add(grid);
           // newviewMenu.add(naig);
            // разделитель можно создать и явно
           // newviewMenu.add(new JSeparator());
           // newviewMenu.add(one);
           // newviewMenu.add(two);


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2, dimension.height/2, 1300,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel Button1 = new JPanel(new GridLayout(1, 2, 5, 0) );
        Button1.add (new JButton("Назад"    ));
        Button1.add (new JButton("Сформировать отчет"));
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(Button1);
        Container container = frame.getContentPane();
        container.add(flow, BorderLayout.SOUTH);
        Main1 arr = new Main1();
            String names [] = {"ФИО","Русский язык","Алгебра","Геометрия","Химия","Физика","Литература","География","Искусство","Физ.Культура","Информатика","Англ.Язык","Обществознание","История"};
        BookTableModel btm = new BookTableModel();
        tebledata = arr.transformArrayList(arr.getNames());
        JTable bookTable = new JTable(tebledata,names);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(1100,250));
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    save1.update_table(len.join(tebledata));
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
        timer1.start();
        frame.add(bookTableScrollPane);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        //newviewMenu.add(fileMenu);
        //frame.setJMenuBar(newviewMenu);
        frame.setVisible(true);
        frame.pack();
        frame.revalidate();
    }
    String [] [] join (String[][] array){
      return array;
    }
}
