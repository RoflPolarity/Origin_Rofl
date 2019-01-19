import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class vote {
    Main vote=new Main();
    Connection co;
    GUI_1 gui = new GUI_1();
    public  void vale (String name){
        String  out;
        try {
            vote.open();
        Statement st = co.createStatement();
        String query = "SELECT Классы FROM teach WHERE Имя = " + "'" + name +"'";
        ResultSet rs = st.executeQuery(query);
        String classes = rs.getString("Классы");
        String [] words = classes.split(",");
        }
        catch (Exception e){

        }
        JFrame frame = new JFrame("Выбор класса");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] items = {"Leonid","Valechka","Artyom"};
        JComboBox comboBox = new JComboBox(items);
        frame.add(comboBox);
        frame.setVisible(true);
    }
}
