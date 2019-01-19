import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class vote {
    Main vote=new Main();
    Connection co;
    GUI_1 gui = new GUI_1();
    public String vale (String name){
        String  out;
        try {
            vote.open();
        Statement st = co.createStatement();
        String query = "SELECT Классы FROM teach WHERE Имя = " + "'" + name +"'";
        ResultSet rs = st.executeQuery(query);
        String classes = rs.getString("Классы");
        String [] words = classes.split(",");
        out = words[0];
        return out;
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
