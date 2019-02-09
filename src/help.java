import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class help {
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension size = kit.getScreenSize();
    private JFrame frame = new JFrame("Help");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton jbt = new JButton();
    public void help(String name){
        vote vote1 = new vote();
        frame.setBounds(size.width / 2 - 250, size.height / 2 - 150, 250, 150);
        label.setText("");
        frame.setResizable(false);
        jbt.setText("Назад");
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                try {
                    vote1.vale(name);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(label);
        panel.add(jbt);
        frame.add(panel);
        frame.setVisible(true);

    }
}
