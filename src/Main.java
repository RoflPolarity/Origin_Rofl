import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    Connection co;

    public static void main(String[] args) throws SQLException{
        Main program = new Main();
        GUI_1 gui = new GUI_1();
            gui.main_GUI();
    }
    boolean open() {//Функция коннекта к БД
        try{
            Class.forName("org.sqlite.JDBC");
             co = DriverManager.getConnection("jdbc:sqlite:database\\users.db");
            return true;
        }
        catch (Exception e){
            System.out.println (e.getMessage());
        }
        return false;
    }
    Boolean connection_execute (String query) throws SQLException{
        this.open();
        Statement st = co.createStatement();
        return st.execute(query);
    }
    ResultSet connection_Query (String query) throws SQLException {
        open();
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
    }
    int connection_Update (String query) throws SQLException {
        this.open();
        Statement st = co.createStatement();
        int rs = st.executeUpdate(query);
        return rs;
    }
    void close(){ //Закрытие
        try {
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
    ArrayList<String> select_people (){
        ArrayList<String> array = new ArrayList<>();
        try {
            Statement st = co.createStatement();
            String query = "SELECT id, Имя, Фамилия, Отчество, Факультет FROM people";
            ResultSet rs = st.executeQuery(query);
            for (int i = 0;  rs.next(); i++){
                String a = rs.getString("Фамилия");
                String b = rs.getString("Имя");
                String c = rs.getString("Отчество");
                array.add(i,a+" " + " " + b + " " + c);
            }
        }catch (Exception e ){System.out.println(e.getMessage());}
    return array;
    }
}