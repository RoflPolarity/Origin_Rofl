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
        gui.main_GUI();
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
    void update(){
        try{
        System.out.println("Введите, что надо изменить");
        String smena = data.nextLine();
        System.out.println("На что нужно изменить этот параметр?");
        String otvet_smena = data.nextLine();
        System.out.println("Введите id человека");
        String gde = data.nextLine();
        String query = "UPDATE users " + "SET " + smena + " = " + "'" + otvet_smena  + "'" + " WHERE id = " + gde;
        Statement stmt = co.createStatement();
        int re = stmt.executeUpdate(query);
    }catch (Exception e){System.out.println(e.getMessage());}
    }
    void insert() {
        try {
            //Ввод переменных
                System.out.println("Введите ФИО ученика: ");
                String FIO = data.nextLine();
                String [] words = FIO.split(" ");
                System.out.println("Введите класс ученика ");
                String classes = data.nextLine();
                System.out.println("Введите факультет ученика ");
                String facult = data.nextLine();
        String query = "INSERT INTO users (Имя, Фамилия, Отчество, Класс, Факультет)"+ " VALUES ('"+ words[1] + "','" + words[0] + "','"  + words[2] + "','" + classes +"','" + facult +"')";
        Statement stmt = co.createStatement();
        int rs = stmt.executeUpdate(query);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void close(){ //Закрытие
        try {
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
    void select(){
        try {
            Statement st = co.createStatement();
            String query = "SELECT id, Имя,Фамилия,Отчество FROM people ORDER BY id ";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("Имя");
                String fam = rs.getString("Фамилия");
                String otch = rs.getString("Отчество");
            }
            rs.close();
            st.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void delete(){
        try {
            System.out.println("Какую строку удалить?");
            int id = data.nextInt();
            Statement st = co.createStatement();
            int id1 = id - 1;
            String delete = "DELETE FROM users WHERE id = " + id;
            String resets = "UPDATE sqlite_sequence SET seq = " + id1 + " WHERE name = 'users'";
            int deleted_row = st.executeUpdate(delete);
            int reset = st.executeUpdate(resets);
            System.out.println("\n");
        }catch (Exception e){
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