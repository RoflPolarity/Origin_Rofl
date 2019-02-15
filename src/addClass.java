import javax.swing.*;
import java.awt.*;

public class addClass {
    Font mainFont = new Font("Aial",Font.BOLD,10);
    String [] classes = new String[]{"1","2","3","4","5","6","7","8","9","10","11"};
    String [] classes1 = new String[]{"А","Б","В","Г"};
    String [] klassPredm = new String[]{"Русский язык","Литература","Алгебра","Геометрия","ОБЖ","Астрономия","Английский язык","Физическая культура","Физика","Химия","Биология","Информатика","Искусство","Обществознание","Экономика"};
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dim = toolkit.getScreenSize();
    void addClasses (String teachName){
        JFrame frame = new JFrame();
        JPanel Mainpanel = new JPanel();
        JPanel choiceClass = new JPanel();
        JPanel premet = new JPanel(new GridLayout(klassPredm.length,1,4,4));
        JLabel label = new JLabel("Выберите класс");
        frame.add(Mainpanel);
        Mainpanel.add(choiceClass);
        JComboBox comboBox = new JComboBox(classes);
        JComboBox comboBox1 = new JComboBox(classes1);

        choiceClass.add(label);
        choiceClass.add(comboBox);
        choiceClass.add(comboBox1);

        JCheckBox predm = new JCheckBox();
        for (int i = 0;i<klassPredm.length;i++) {
            predm.setText(klassPredm[i]);
            choiceClass.add(predm);
        }
        frame.setBounds(dim.width/2 - 150, dim.height/2 - 75, 300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
