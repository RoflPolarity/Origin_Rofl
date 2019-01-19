import javax.swing.*;
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
    //https://stackoverrun.com/ru/q/12840175
        }
        catch (Exception e){

        }
        JFrame frame = new JFrame();
        frame.setSize(500,800);
        JMenu menu = new JMenu("Меню");
        frame.add(menu);
        frame.setVisible(true);
    }
}
