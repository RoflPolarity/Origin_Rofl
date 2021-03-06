import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
class leonid extends Component {
    private static String[][] arrray;
    public static void main(String[][] tabled, String names1, String teachName, String trim){
        File och = new File("Отчет.xls");
        JLabel lable = new JLabel();
        lable.setVisible(false);
        vote vale = new vote();
        JFrame frame = new JFrame ("Legion");
        ImageIcon icon = new ImageIcon("legion2.png");
        frame.setIconImage(icon.getImage());
        calc calc1 = null;
        try {
            calc1 = new calc();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        save save1 = new save();
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
        JPanel grid1 = new JPanel(new GridLayout(2, 2, 5, 0) );
        JButton jbt = new JButton("Сформировать отчет");
        JButton jbt1 = new JButton("Назад");
        calc finalCalc = calc1;
        lable.setBackground(Color.gray);
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lable.setVisible(true);
                lable.setText("Формирование отчета...");
                try {
                    save1.update_table(tabled);
                    finalCalc.finalcalc(tabled,names1,teachName,trim,names);
                    lable.setText("Отчет успешно сформирован");
                } catch (IOException | SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setVisible(false);
                    vale.vale(names1);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        grid1.add (jbt1);
        grid1.add (jbt);
        grid1.add(lable);
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
        Timer timer1 = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

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
}

