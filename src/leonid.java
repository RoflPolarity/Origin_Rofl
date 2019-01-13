import javax.swing.*;
import java.awt.*;

public class leonid  {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Legion");
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        JButton deleteButton = new JButton("Назад");
        JButton clearButton = new JButton("Сформировать отчет");

        BookTableModel btm = new BookTableModel();
        JTable bookTable = new JTable(btm);
        JScrollPane bookTableScrollPane = new JScrollPane(bookTable);
        bookTableScrollPane.setPreferredSize(new Dimension(400,400));
            Main prog = new Main();
            prog.open();
            prog.select_people();
                //System.out.println(prog.select_people());
       // btm.addDate();

        frame.add(bookTableScrollPane, new GridBagConstraints(0,0,3,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        frame.add(deleteButton, new GridBagConstraints(1,1,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1,1,1,1),0,0));

        frame.add(clearButton, new GridBagConstraints(2,1,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1,1,1,1),0,0));

        frame.setVisible(true);
        frame.pack();
        frame.revalidate();
    }
}
