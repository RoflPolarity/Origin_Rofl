import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    Scanner data = new Scanner(System.in);
    Connection co;
    public static void main(String[] args) {
        Scanner main =  new Scanner(System.in);
        Main program = new Main();
        program.open();
        GUI_1 gui = new GUI_1();
        try {
            gui.main_GUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    boolean open(){//Функция коннекта к БД
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
    String valid_name(String name){
        String get_name = "";
        try {
            Statement state = co.createStatement();
            String query_name = "SELECT Имя, Классы FROM teach";
            ResultSet res = state.executeQuery(query_name);
            if (res.getString("Имя").equals(name)){

                get_name = res.getString("Классы");
            }
        }catch (Exception e){System.out.println(e.getMessage());}
        return get_name;
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