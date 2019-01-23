import java.sql.ResultSet;
import java.sql.SQLException;
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
                    if (array[b][14].equals("")){args[13] = 0;}else args[13] = Integer.parseInt(array[b][14]);
                query = "UPDATE '11А' SET Русскийязык = " + args[0] + ", Алгебра = " + args[1] + ", Геометрия = " + args[2] + ", Химия =" + args[3] + ", Физика = " + args[4] + ", Литература =" + args[5] + ", География  =" + args[6] + ", Искусство =" + args[7] + ", Физра = " + args[8] + ", Информатика =" + args[9] + ", English = " + args[10] + ", Обществознание = " + args[12] + ", История = " + args[13] + " WHERE ФИО ='" + array[b][0] +"'";
                int a = prog.connection_Update(query);
            }
        }
        String [][] read_teable (String[][] array)throws SQLException {
            prog.open();
            query = "SELECT * FROM" + "'"+"11А"+"'";
            ResultSet rs = prog.connection_Query(query);
            String FIO[] = new String[array.length];
            String ocenki[] = new String[13];
            for (int i =0;rs.next();i++){
                FIO[i] = rs.getString("ФИО");
                ocenki[0] = rs.getString("Русскийязык");
                ocenki[1] = rs.getString("Алгебра");
                ocenki[2] = rs.getString("Геометрия");
                ocenki[3] = rs.getString("Химия");
                ocenki[4] = rs.getString("Физика");
                ocenki[5] = rs.getString("Литература");
                ocenki[6] = rs.getString("География");
                ocenki[7] = rs.getString("Искусство");
                ocenki[8] = rs.getString("Физра");
                ocenki[9] = rs.getString("Информатика");
                ocenki[10] = rs.getString("English");
                ocenki[11] = rs.getString("Обществознание");
                ocenki[12] = rs.getString("История");
                if (ocenki[0].equals("0"))ocenki[0] = "";
                if (ocenki[1].equals("0"))ocenki[1] = "";
                if (ocenki[2].equals("0"))ocenki[2] = "";
                if (ocenki[3].equals("0"))ocenki[3] = "";
                if (ocenki[4].equals("0"))ocenki[4] = "";
                if (ocenki[5].equals("0"))ocenki[5] = "";
                if (ocenki[6].equals("0"))ocenki[6] = "";
                if (ocenki[7].equals("0"))ocenki[7] = "";
                if (ocenki[8].equals("0"))ocenki[8] = "";
                if (ocenki[9].equals("0"))ocenki[9] = "";
                if (ocenki[10].equals("0"))ocenki[10] = "";
                if (ocenki[11].equals("0"))ocenki[11] = "";
                if (ocenki[12].equals("0"))ocenki[12] = "";
                array[i][0] = FIO[i];
                array[i][1] = ocenki[0];
                array[i][2] = ocenki[1];
                array[i][3] = ocenki[2];
                array[i][4] = ocenki[3];
                array[i][5] = ocenki[4];
                array[i][6] = ocenki[5];
                array[i][7] = ocenki[6];
                array[i][8] = ocenki[7];
                array[i][9] = ocenki[8];
                array[i][10] = ocenki[9];
                array[i][11] = ocenki[10];
                array[i][12] = ocenki[11];
                array[i][13] = ocenki[12];
            }
            prog.close();
          return array;
        }
}
