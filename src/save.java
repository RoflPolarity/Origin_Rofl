import java.io.*;
import java.lang.reflect.Array;

public class save {
    Main1 user = new Main1();

        void save_table (String [] [] array) {
            try {
            File tableSaved = new File("Table.txt");
            if (tableSaved.exists()){ }else {tableSaved.createNewFile();}
            BufferedWriter writer = new BufferedWriter(new FileWriter(tableSaved,true));
            String lineSeparator = System.getProperty("line.separator");
            int a = 0;
            for (int i =0; i<=array.length;i++){
                writer.write(array[i][a] +" - "+ array[i][a+1] +" - " + array[i][a+2] +" - "+ array[i][a+3] +" - "+ array[i][a+4] +" - " + array[i][a+5]+ " - " + array[i][a+6] + " - " + array[i][a+7] + " - " + array[i][a+8] + " - " + array[i][a+9] + " - " + array[i][a+10] + " - " + array[i][a+11] + " - " + array[i][a+12] + " - " + array[i][a+13] + " - " + array[i][a+14]+ " - " + array[i][a+15]+lineSeparator);
                writer.flush();

            }
                writer.close();
            }catch (Exception e){
            System.out.println(e.getMessage());
            }
        }
        void check_table(String[] [] array){
            save save1 = new save();
            try {
                BufferedReader br = new BufferedReader(new FileReader("Table.txt"));
                String str = br.readLine();
                System.out.println(str);
                if (str.equals("")){
                    save1.save_table(array);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
