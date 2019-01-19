import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class vote {
    Main vote=new Main();
    Connection co;
    GUI_1 gui = new GUI_1();
    public void vale (String name){

        try {
            vote.open();
        Statement st = co.createStatement();
        String query = "SELECT Классы FROM teach WHERE Имя = " + "'" + name +"'";
            System.out.println(name);
        ResultSet rs = st.executeQuery(query);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
