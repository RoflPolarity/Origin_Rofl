import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
class leonid  {
    static Toolkit kit = Toolkit.getDefaultToolkit();
    private static String[][] arrray;
    static Dimension size = kit.getScreenSize();
    public static void main(String[][] tabled, String names1, String teachName, String trim){

        JFrame frame = new JFrame ("Legion");
        ImageIcon icon = new ImageIcon("legion2.png");
        frame.setIconImage(icon.getImage());
         leonid len = new leonid();
        calc calc1 = null;
        try {
            calc1 = new calc();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        save save1 = new save();
        Timer timer1 = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        arrray = tabled;
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
        String names [] = {"ФИО","Русский язык","Алгебра","Геометрия","Химия","Физика","Литература","География","Искусство","Физ.Культура","Информатика","Англ.Язык","Обществознание","История"};
        JTable bookTable = new JTable(tabled,names);
        JPanel grid1 = new JPanel(new GridLayout(1, 2, 5, 0) );
        JButton jbt = new JButton("Сформировать отчет");
        JButton jbt1 = new JButton("Назад");
        calc finalCalc = calc1;
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save1.update_table(tabled);
                    finalCalc.label(tabled,names1,teachName,trim);
                    finalCalc.calc1(tabled,names1,teachName);
                    finalCalc.label2(tabled,names1,teachName,trim,names);
                } catch (IOException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        grid1.add (jbt1);
        grid1.add (jbt);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid1);
        frame.getContentPane();
        frame.add(flow, BorderLayout.SOUTH);

        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(1100,250));

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    save1.update_table(tabled);
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
