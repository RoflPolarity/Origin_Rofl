import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GUI_1 {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension size = kit.getScreenSize();
    Main prog = new Main();
    public ArrayList<String> people = prog.select_people();

    void main_GUI(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setBounds(size.width/2 - 250, size.height/2 - 150, 250, 150);
        JButton button_a = new JButton("Далее");
        TextField username = new TextField(20);
        JLabel name = new JLabel("Введите ваше имя");
        username.setBackground(Color.lightGray);
        panel.add(name);
        panel.add(username);
        panel.add(button_a);
        button_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.getText().equals("")){
                    System.out.println("Введите текст");
                } else {
                    frame.setVisible(false);
                    second_window();
                }
            }
        });
        if (prog.open()){
            button_a.setBackground(Color.green);
        }else button_a.setBackground(Color.red);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                String names = username.getText() ;
                String people = prog.valid_name(names);
                String [] classes = people.split(",");
                System.out.println(classes[0]);
            }
        });
    }
    void second_window() {
        JFrame second_frame = new JFrame();
        second_frame.setVisible(true);
        second_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel_2 = new JPanel();
        second_frame.add(panel_2);
        second_frame.setBounds(size.width/2 - 250, size.height/2 - 150,500 , 300);
    }
    void table(){
        DefaultTableModel tableModel;
        JTable table1;
        Object [] columnsHeader = new String [] {"ФИО обучаегося",
                "Русский язык", "Литература", "Английский язык",
                "Алгебра", "Геометрия", "Информатика",
                "История","Обществознание", "Физика",
                "Химия", "Биология", "Искусство",
                "Физическая культура", " ", "Кол-во учащихся: "};
        String name = " ";
        for (int i = 0; i==people.size(); i++) {
            name = people.get(i);
        }
        Object[][] array = new String[][]{{name}};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnsHeader);
        for (int i = 0; i<array.length; i++) {
            tableModel.addRow(array[i]);
        }
        table1 = new JTable(tableModel);
        JTable table2 = new JTable();
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
    }
}