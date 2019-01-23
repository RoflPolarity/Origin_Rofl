
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main1 {
    Connection co;
    boolean open(){//Функция коннекта к БД
        try{
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:database\\users.db");
            System.out.println("Connected");
            return true;
        }
        catch (Exception e){
            System.out.println (e.getMessage());
        }
        return false;
    }//Связь с БД (открытие)
    static class User {
        private String name;
        private String profile;
        private String ocenka;

        public User(String name, String ocenka) {
            this.name = name;
            this.profile = profile;
            this.ocenka = ocenka;
        }

        public String getOcenka(){
            return ocenka;
        }
        public void setOcenka(String ocenka){
            this.ocenka = ocenka;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

    }

    public static void main(String[] args) {
        Main1 m = new Main1();
        List<User> users = m.getNames();
        String[][] transformedUsers = m.transformArrayList(users);
        prettyPrintMatrix(transformedUsers);
    }

    public static void prettyPrintMatrix(String [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<User> getNames() {
        Main prog = new Main();
        this.open();

        //Это результат селекта "SELECT id, Имя, Фамилия, Отчество, Profile FROM people"
        String [][] array = {{}};
        List<User> users = new ArrayList();
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, Имя, Фамилия, Отчество, Факультет FROM people ORDER BY Фамилия");
        while (rs.next()){
            String a = rs.getString("Фамилия");
            String b = rs.getString("Имя");
            String c = rs.getString("Отчество");
            User sample = new User(a + " " + b + " " + c,"");
            //получаешь строку с именем из resultset'a
            //получешь строку с профилем из resultset'a
            //пихаешь из в объект User
            //и добавляешь его в список
            users.add(sample);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return users;
    }

    public String[][] transformArrayList(List<User> users) {
        String[][] transformedUsers = new String[users.size()][15];
        for(int i = 0; i < users.size(); i++) {
            transformedUsers[i][0] = users.get(i).getName();
            transformedUsers[i][1] = users.get(i).getOcenka();
            transformedUsers[i][2] = users.get(i).getOcenka();
            transformedUsers[i][3] = users.get(i).getOcenka();
            transformedUsers[i][4] = users.get(i).getOcenka();
            transformedUsers[i][5] = users.get(i).getOcenka();
            transformedUsers[i][6] = users.get(i).getOcenka();
            transformedUsers[i][7] = users.get(i).getOcenka();
            transformedUsers[i][8] = users.get(i).getOcenka();
            transformedUsers[i][9] = users.get(i).getOcenka();
            transformedUsers[i][10] = users.get(i).getOcenka();
            transformedUsers[i][11] = users.get(i).getOcenka();
            transformedUsers[i][12] = users.get(i).getOcenka();
            transformedUsers[i][13] = users.get(i).getOcenka();
            transformedUsers[i][14] = users.get(i).getOcenka();
        }
        return transformedUsers;

    }

}
