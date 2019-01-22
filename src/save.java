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
            Integer args [] = new Integer[14];

            for (int b = 0; b<array.length;b++){
                    if (array[b][1].equals("")){args[0] = 0;}else args[0] = Integer.parseInt(array[b][1]);
                    if (array[b][2].equals("")){args[1] = 0;}else args[1] = Integer.parseInt(array[b][2]);
                    if (array[b][3].equals("")){args[2] = 0;}else args[2] = Integer.parseInt(array[b][3]);
                    if (array[b][4].equals("")){args[3] = 0;}else args[3] = Integer.parseInt(array[b][4]);
                    if (array[b][5].equals("")){args[4] = 0;}else args[4] = Integer.parseInt(array[b][5]);
                    if (array[b][6].equals("")){args[5] = 0;}else args[5] = Integer.parseInt(array[b][6]);
                    if (array[b][7].equals("")){args[6] = 0;}else args[6] = Integer.parseInt(array[b][7]);
                    if (array[b][8].equals("")){args[7] = 0;}else args[7] = Integer.parseInt(array[b][8]);
                    if (array[b][9].equals("")){args[8] = 0;}else args[8] = Integer.parseInt(array[b][9]);
                    if (array[b][10].equals("")){args[9] = 0;}else args[9] = Integer.parseInt(array[b][10]);
                    if (array[b][11].equals("")){args[10] = 0;}else args[10] = Integer.parseInt(array[b][11]);
                    if (array[b][12].equals("")){args[11] = 0;}else args[11] = Integer.parseInt(array[b][12]);
                    if (array[b][13].equals("")){args[12] = 0;}else args[12] = Integer.parseInt(array[b][13]);
                query = "UPDATE '11А' SET Русскийязык = " + args[0] + ", Алгебра = " + args[1] + ", Геометрия = " + args[2] + ", Химия =" + args[3] + ", Физика = " + args[4] + ", Литература =" + args[5] + ", География  =" + args[6] + ", Искусство =" + args[7] + ", Физра = " + args[8] + ", Информатика =" + args[9] + ", English = " + args[10] + ", Обществознание = " + args[12] + ", История = " + args[13] + " WHERE ФИО ='" + array[b][0] +"'";
                int a = prog.connection_Update(query);
            }
        }
        void read_teable (String[][] array) throws IOException {

        }
}
