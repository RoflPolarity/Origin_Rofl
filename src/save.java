import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class save {
    Main prog = new Main();
    private String query;
        void save_table (String [] [] array) throws SQLException {
            query = "create table if not exists '11А'(id INTEGER PRIMARY KEY AUTOINCREMENT, ФИО TEXT , Русскийязык INTEGER,Алгебра INTEGER,Геометрия INTEGER,Химия INTEGER,Физика INTEGER, Литература INTEGER,География INTEGER, Искусство INTEGER,Физра INTEGER,Информатика INTEGER,English INTEGER ,Обществознание INTEGER ,История INTEGER )";
            Boolean check = prog.connection_execute(query);
            query = "SELECT id FROM '11А' WHERE id = 1";
            ResultSet rs = prog.connection_Query(query);
            for (int i = 0; i<array.length; i++){
                query = "INSERT INTO '11А'(ФИО)VALUES('" + array[i][0] + "')";
                prog.connection_execute(query);
                }
            }


        void update_table(String [] [] array) throws SQLException{
            Integer args [] = new Integer[13];
            for (int i = 0; i<args.length; i++){

            }
            for (int b = 0; b<array.length;b++){
                if (array[b][1].equals("")){array[b][1] = "0";}
                if (array[b][2].equals("")){array[b][2] = "0";}
                if (array[b][3].equals("")){array[b][3] = "0";}
                if (array[b][4].equals("")){array[b][4] = "0";}
                if (array[b][5].equals("")){array[b][5] = "0";}
                if (array[b][6].equals("")){array[b][6] = "0";}
                if (array[b][7].equals("")){array[b][7] = "0";}
                if (array[b][8].equals("")){array[b][8] = "0";}
                if (array[b][9].equals("")){array[b][9] = "0";}
                if (array[b][10].equals("")){array[b][10] = "0";}
                if (array[b][11].equals("")){array[b][11] = "0";}
                if (array[b][12].equals("")){array[b][12] = "0";}
                if (array[b][13].equals("")){array[b][13] = "0";}
                query = "UPDATE '11А' SET Русскийязык = " + array[b][1] + ", Алгебра = " + array[b][2] + ", Геометрия = " + array[b][3] + ", Химия =" + array[b][4] + ", Физика = " + array[b][5] + ", Литература =" + array[b][6] + ", География  =" + array[b][7] + ", Искусство =" + array[b][8] + ", Физра = " + array[b][9] + ", Информатика =" + array[b][10] + ", English = " + array[b][11] + ", Обществознание = " + array[b][12] + ", История = " + array[b][13] + "WHERE ФИО ='" + array[b][0] +"'";
                int a = prog.connection_Update(query);
            }
        }
        void read_teable (String[][] array) throws IOException {

        }
}
