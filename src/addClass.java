import javax.swing.*;
import java.awt.*;

class addClass extends JFrame {
    Font mainFont = new Font("Aial",Font.BOLD,10);
    private String [] classes = new String[]{"1","2","3","4","5","6","7","8","9","10","11"};
    private String [] classes1 = new String[]{"А","Б","В","Г"};
    private String [] klassPredm = new String[]{"Русский язык","Литература","Алгебра","Геометрия","ОБЖ","Астрономия","Английский язык","Физическая культура","Физика","Химия","Биология","Информатика","Искусство","Обществознание","Экономика"};
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dim = toolkit.getScreenSize();
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
    void addTeach (){
        JLabel label_class = new JLabel("Выберите класс");
        JLabel label_teach = new JLabel("Укажите имя учителя");
        JFrame frame = new JFrame();
        JPanel MainPanel = new JPanel();

        JCheckBox chB = new JCheckBox();
        JCheckBox chB1 = new JCheckBox();JCheckBox chB2 = new JCheckBox();
        GroupLayout layout = new GroupLayout(MainPanel);
        MainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        JTextField textTeacher = new JTextField(20);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(label_teach)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
                .addComponent(textTeacher).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(chB).addComponent(chB1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(chB2)))));
        frame.pack();
        frame.add(MainPanel);

        frame.setBounds(dim.width/2 - 150, dim.height/2 - 75, 300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
