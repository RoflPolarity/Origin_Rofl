import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    Connection co;
    boolean open() {//Функция коннекта к БД
        try {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:database\\users.db");
            System.out.println("Connected");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    class User {
        private String name;
        private String profile;

        public User(String name, String profile) {
            this.name = name;
            this.profile = profile;
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

        //Это результат селекта "SELECT id, Имя, Фамилия, Отчество, Profile FROM people"
        String [][] array = {{}};
        List<User> users = new ArrayList();

        for (int i = 0; i < array.length; i++) {
            //получаешь строку с именем из resultset'a
            //получешь строку с профилем из resultset'a
            //пихаешь из в объект User
            //и добавляешь его в список
            users.add(new User(array[i][0], array[i][1]));
        }

        return users;
    }

    public String[][] transformArrayList(List<User> users) {
        String[][] transformedUsers = new String[users.size()][2];
        for(int i = 0; i < users.size(); i++) {
            transformedUsers[i][0] = users.get(i).getName();
            transformedUsers[i][1] = users.get(i).getProfile();
        }
        return transformedUsers;

    }

}
