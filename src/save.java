import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class save {
    List<Main1.User> load = new ArrayList();
    File tableSaved = new File("Table.txt");
        void save_table (String [] [] array) {
            try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tableSaved,true));
                PrintWriter writer1 = new PrintWriter("Table.txt");
                String lineSeparator = System.getProperty("line.separator");
            int a = 0;
                writer1.print("");
                writer1.close();
            for (int i =0; i<=array.length;i++){
                writer.write(array[i][a] +" - "+ array[i][a+1] +" - " + array[i][a+2] +" - "+ array[i][a+3] +" - "+ array[i][a+4] +" - " + array[i][a+5]+ " - " + array[i][a+6] + " - " + array[i][a+7] + " - " + array[i][a+8] + " - " + array[i][a+9] + " - " + array[i][a+10] + " - " + array[i][a+11] + " - " + array[i][a+12] + " - " + array[i][a+13] + " - " + array[i][a+14]+ " - " + array[i][a+15]+lineSeparator);
                writer.flush();

            }
                writer.close();
            }catch (Exception e){
                //Exception
            }
        }
        String [] [] read_teable () throws IOException {
            Main1 matrix = new Main1();
            BufferedReader br = new BufferedReader(new FileReader("Table.txt"));
            int i = 0;
            ArrayList<String> row = new ArrayList<String>();
            while (br.readLine()!=null){
                br.readLine();
                //Main1.User sample = new Main1.User()
                //load.add(i,);
                i = i+1;
            }
            String [] [] newTable = matrix.transformArrayList(load);
            return newTable;
        }
}
