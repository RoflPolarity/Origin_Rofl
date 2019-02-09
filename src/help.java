import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class help {
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private JFrame frame = new JFrame("Помощь");
    private JPanel panel = new JPanel();
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = toolkit.getScreenSize();
    private JButton jbt = new JButton();
    private JLabel label = new JLabel();
    void help (String name){
        String label1 = "";//Помощь
        label.setText(label1);
        vote vote1 = new vote();
        jbt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setVisible(false);
                    vote1.vale(name);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        frame.add(panel);
        panel.add(label);
        panel.add(jbt);
        frame.setBounds(dimension.width/2 - 150, dimension.height/2 - 75, 300,150);
        frame.setVisible(true);
    }
}
