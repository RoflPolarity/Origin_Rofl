import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

//.
public class leonid  {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Legion");
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        Main1 arr = new Main1();
            String names [] = {"ФИО","Профиль"};
        JButton deleteButton = new JButton("Назад");
        JButton clearButton = new JButton("Сформировать отчет");
        BookTableModel btm = new BookTableModel();
//        String [] [] tebledata = arr.transformArrayList(arr.getNames());
        JTable bookTable = new JTable(btm);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(400,400));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println();
            }
        });
        frame.add(bookTableScrollPane);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.setVisible(true);
        frame.pack();
        frame.revalidate();
    }
}
