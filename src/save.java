import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class save {
    Main prog = new Main();
        void save_table (String [] [] array) throws SQLException {
            String query = "create table if not exists '11А'(id INTEGER PRIMARY KEY AUTOINCREMENT, ФИО TEXT NOT NULL, Русский язык INTEGER NOT NULL,Алгебра INTEGER NOT NULL,Геометрия INTEGER NOT NULL,Химия INTEGER NOT NULL,Физика INTEGER NOT NULL, Литература INTEGER NOT NULL,География INTEGER NOT NULL, Искусство INTEGER NOT NULL,Физра INTEGER NOT NULL,Информатика INTEGER NOT NULL,English INTEGER NOT NULL,Обществознание INTEGER NOT NULL,стория INTEGER NOT NULL)";
            Boolean check = prog.connection_execute(query);
            System.out.println(check);
//            prog.connection_Query("CREATE TABLE 11А(" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
//                    "ФИО TEXT NOT NULL,\n" +
//                    "Русский язык INTEGER NOT NULL,\n" +
//                    "Алгебра INTEGER NOT NULL,\n" +
//                    "Геометрия INTEGER NOT NULL),\n" +
//                    "Химия INTEGER NOT NULL\n" +
//                    "Физика INTEGER NOT NULL\n" +
//                    "Литература INTEGER NOT NULL\n" +
//                    "География INTEGER NOT NULL\n" +
//                    "Искусство INTEGER NOT NULL\n" +
//                    "Физ.Культура INTEGER NOT NULL\n" +
//                    "Информатика INTEGER NOT NULL\n" +
//                    "Англ.Язык INTEGER NOT NULL\n" +
//                    "Обществознание INTEGER NOT NULL\n" +
//                    "История INTEGER NOT NULL\n");
        }
        void read_teable (String[][] array) throws IOException {

        }
}
