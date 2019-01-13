import javax.swing.*;

public class NewMainForm extends JFrame{
    JFrame frame = new JFrame();
    private JPanel rootPanel;

    public NewMainForm() {
        setContentPane(rootPanel);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new NewMainForm();
    }
}
