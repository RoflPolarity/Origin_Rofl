import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;


class calc {
    Main prog = new Main();
    Workbook wb = new HSSFWorkbook();
    Sheet sh1 = wb.createSheet("Статистика");
    Sheet sh2 = wb.createSheet("Кач-сок");
    FileOutputStream fos = new FileOutputStream("Отчет.xls");
    String[] FIO;
    private int predmet1[][];
    private int[][] main;

    calc() throws FileNotFoundException {
    }
    public  int findSumWithoutUsingStream(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    public  double findAverageWithoutUsingStream(int[] array) {
        int sum = findSumWithoutUsingStream(array);
        return (double) sum / array.length;
    }
    void label(String[][] arr, String classNo, String teachName, String trim) throws IOException {
        Row row = sh1.createRow(0);
        Cell cell = row.createCell(2);
        cell.setCellValue("Рейтинг успеваемости учащихся " + classNo + " класса");

        row = sh1.createRow(1);
        cell = row.createCell(4);
        cell.setCellValue(trim + " 2018-19 уч.года");

        row = sh1.createRow(3);
        cell = row.createCell(2);
        cell.setCellValue("Количество учащихся: " + arr.length);

        row = sh1.createRow(4);
        cell = row.createCell(8);
        cell.setCellValue("Классный руководитель: " + teachName);
        {
            row = sh1.createRow(6);
            cell = row.createCell(0);
            cell.setCellValue("№ п/п\n");
            cell = row.createCell(1);
            row.setHeightInPoints(35);
            cell.setCellValue("ФИО учащегося");
            cell = row.createCell(2);
            cell.setCellValue("кол-во \n троек");
            cell = row.createCell(3);
            cell.setCellValue("кол-во \n четверок");
            cell = row.createCell(4);
            cell.setCellValue("кол-во \n пятерок");
            cell = row.createCell(5);
            cell.setCellValue("кол-во \n двоек");
            cell = row.createCell(6);
            cell.setCellValue("с одной \n \"2\" и более");
            cell = row.createCell(7);
            cell.setCellValue("с одной \n \"3\"");
            cell = row.createCell(8);
            cell.setCellValue("с одной \n \"4\"");
            cell = row.createCell(9);
            cell.setCellValue("на \"4\" и \"5\"\n");
            cell = row.createCell(10);
            cell.setCellValue("на \"5\"");
            cell = row.createCell(11);
            cell.setCellValue("5");
            cell = row.createCell(12);
            cell.setCellValue("одна 4\n");
            cell = row.createCell(13);
            cell.setCellValue("на 4 и 5\n");
            sh1.autoSizeColumn(1);
            sh1.autoSizeColumn(6);
            wb.write(fos);
            fos.close();
        }
    }
        int[][] calc1 (String[][]arr, String classNo, String teachName) throws IOException {
            main = new int[13][arr.length];
        for (int i = 0; i < arr.length; i++) {
                FIO = arr[i][0].split(" ");
                Integer[] ocenki = new Integer[]{0, 0, 0, 0};
                if (arr[i][1].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][1].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][1].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][1].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][2].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][2].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][2].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][2].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][3].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][3].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][3].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][3].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][4].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][4].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][4].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][4].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][5].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][5].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][5].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][5].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][6].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][6].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][6].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][6].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][7].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][7].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][7].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][7].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][8].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][8].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][8].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][8].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][9].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][9].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][9].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][9].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][10].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][10].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][10].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][10].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][11].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][11].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][11].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][11].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][12].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][12].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][12].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][12].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][13].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][13].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][13].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][13].equals("5")) ocenki[3] = ocenki[3] + 1;
                if (arr[i][14].equals("2")) ocenki[0] = ocenki[0] + 1;
                if (arr[i][14].equals("3")) ocenki[1] = ocenki[1] + 1;
                if (arr[i][14].equals("4")) ocenki[2] = ocenki[2] + 1;
                if (arr[i][14].equals("5")) ocenki[3] = ocenki[3] + 1;
                fos = new FileOutputStream("Отчет.xls");
                Row row = sh1.createRow(7 + i);
                Cell cell = row.createCell(1);
                cell.setCellValue(arr[i][0]);
                cell = row.createCell(2);
                cell.setCellValue(ocenki[1]);
                cell = row.createCell(3);
                cell.setCellValue(ocenki[2]);
                cell = row.createCell(4);
                cell.setCellValue(ocenki[3]);
                cell = row.createCell(5);
                cell.setCellValue(ocenki[0]);
                cell = row.createCell(0);
                cell.setCellValue(1 + i);
                cell = row.createCell(6);
                if (ocenki[0] == 1 && ocenki[0] > 1) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                cell = row.createCell(7);
                if (ocenki[1] == 1) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                cell = row.createCell(8);
                if (ocenki[2] == 1) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                cell = row.createCell(9);
                if (ocenki[0] == 0 && ocenki[1] == 0) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                cell = row.createCell(10);
                if (ocenki[0] == 0 && ocenki[1] == 0 && ocenki[2] == 0) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                cell = row.createCell(11);
                if (ocenki[0] == 0 && ocenki[1] == 0 && ocenki[2] == 0) cell.setCellValue(1);
                else cell.setCellValue("-");
                cell = row.createCell(13);
                if (ocenki[0] == 0 && ocenki[1] == 0 && ocenki[2] == 1) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                cell = row.createCell(12);
                if (ocenki[2] == 1) cell.setCellValue(FIO[0]);
                else cell.setCellValue("-");
                sh1.autoSizeColumn(9);
                sh1.autoSizeColumn(1);
                wb.write(fos);
                fos.close();
            }
            fos.close();
            return main;
        }
        void label2(String[][] arr, String classNo, String teachName, String trim,String predmet[]) throws IOException, SQLException {
        main = new int[13][arr.length];
            String query = "SELECT * FROM '"+ classNo + "'";
            ResultSet rs = prog.connection_Query(query);
            for  (int i = 0;rs.next();i++) {
                main[0][i] = rs.getInt("Русскийязык");
                main[1][i] = rs.getInt("Алгебра");
                main[2][i] = rs.getInt("Геометрия");
                main[3][i] = rs.getInt("Химия");
                main[4][i] = rs.getInt("Физика");
                main[5][i] = rs.getInt("Литература");
                main[6][i] = rs.getInt("География");
                main[7][i] = rs.getInt("Искусство");
                main[8][i] = rs.getInt("Физра");
                main[9][i] = rs.getInt("Информатика");
                main[10][i] = rs.getInt("English");
                main[11][i] = rs.getInt("Обществознание");
                main[12][i] = rs.getInt("История");
            }
        Row row = sh2.createRow(0);
            Cell cell = row.createCell(2);
            cell.setCellValue("Рейтинг успеваемости учащихся " + classNo + " класса");

            row = sh2.createRow(1);
            cell = row.createCell(4);
            cell.setCellValue(trim + " 2018-19 уч.года");

            row = sh2.createRow(3);
            cell = row.createCell(2);
            cell.setCellValue("Количество учащихся: " + arr.length);

            row = sh2.createRow(4);
            cell = row.createCell(8);
            cell.setCellValue("Классный руководитель: " + teachName);
            wb.write(fos);
            double average;
            predmet1 = new int[predmet.length][arr.length];
            for (int i = 0; i < main.length; i++) {
                for (int b=0;b<main.length;b++){
                    if (main[i][b]==5)predmet1[i][0]++;
                    if (main[i][b]==4)predmet1[i][1]++;
                    if (main[i][b]==3)predmet1[i][2]++;
                    if (main[i][b]==2)predmet1[i][3]++;
                }
                fos = new FileOutputStream("Отчет.xls");
                row = sh2.createRow(5);
                    cell = row.createCell(1);
                    cell.setCellValue(predmet[1]);
                    cell = row.createCell(2);
                    cell.setCellValue(predmet[2]);
                    cell = row.createCell(3);
                    cell.setCellValue(predmet[3]);
                    cell = row.createCell(4);
                    cell.setCellValue(predmet[4]);
                    cell = row.createCell(5);
                    cell.setCellValue(predmet[5]);
                    cell = row.createCell(6);
                    cell.setCellValue(predmet[6]);
                    cell = row.createCell(7);
                    cell.setCellValue(predmet[7]);
                    cell = row.createCell(8);
                    cell.setCellValue(predmet[8]);
                    cell = row.createCell(9);
                    cell.setCellValue(predmet[9]);
                    cell = row.createCell(10);
                    cell.setCellValue(predmet[10]);
                    cell = row.createCell(11);
                    cell.setCellValue(predmet[11]);
                    cell = row.createCell(12);
                    cell.setCellValue(predmet[12]);
                    cell = row.createCell(13);
                    cell.setCellValue(predmet[13]);
                    //13 предметов (12 в массиве)
                    row = sh2.createRow(6);
                    cell = row.createCell(1+i);
                    cell.setCellValue(predmet1[i][0]+predmet1[i][1]+predmet1[i][2]+predmet1[i][3]);
                    row = sh2.createRow(7);
                    cell = row.createCell(1+i);
                    cell.setCellValue(predmet1[i][0]);
                    row = sh2.createRow(8);
                    cell = row.createCell(1+i);
                    cell.setCellValue(predmet1[i][1]);
                    row = sh2.createRow(9);
                    cell = row.createCell(1+i);
                    cell.setCellValue(predmet1[i][2]);
                    row = sh2.createRow(10);
                    cell = row.createCell(1+i);
                    cell.setCellValue(predmet1[i][3]);
                    row = sh2.createRow(11);
                    cell = row.createCell(1+i);
                    cell.setCellValue(predmet1[i][3]);
                    average = this.findAverageWithoutUsingStream(main[i]);
                    row = sh2.createRow(12);
                    cell = row.createCell(1+i);
                    cell.setCellValue(average);
                    System.out.println(predmet1[i][0] + " " + predmet1[i][1] + " " + predmet1[i][2] + " " + predmet1[i][3]);
                    wb.write(fos);
            }
            }
    }