import javax.swing.*;
import java.awt.*;

public class leonid  {
    public static void main(String[] args){

        JFrame frame = new JFrame ("Legion");
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
            String names [] = {"ФИО","Профиль"};
            String [][] array = {{"Янпольский Артём Олегович", "Физмат"},{"Чеков Леонид Анатольевич","Физмат"}};
        JButton deleteButton = new JButton("Назад");
        JButton clearButton = new JButton("Сформировать отчет");

        BookTableModel btm = new BookTableModel();
        JTable bookTable = new JTable(array,names);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(400,400));
        frame.add(bookTableScrollPane);
        frame.add(deleteButton);
        frame.add(clearButton);

        frame.setVisible(true);
        frame.pack();
        frame.revalidate();
    }
}
