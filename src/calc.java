import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


class calc {
    Workbook wb = new HSSFWorkbook();
    Sheet sh1 = wb.createSheet("Отчет");
    FileOutputStream fos = new FileOutputStream("Отчет.xls");
    calc() throws FileNotFoundException {
    }
    void table (String[][] arr,String classNo,String teachName, String trim) throws IOException {
        Row row =sh1.createRow(0);
        Cell cell = row.createCell(2);
        cell.setCellValue("Рейтинг успеваемости учащихся " + classNo +" класса");

        row = sh1.createRow(1);
        cell = row.createCell(4);
        cell.setCellValue("Триместры ");

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
            cell.setCellValue("ФИО" + "\n" + "учащегося");
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
    void calc1(String[][] arr, String classNo,String teachName) throws IOException {
            for (int i = 0; i < arr.length; i++) {
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
                Row row = sh1.createRow(7+i);
                Cell cell = row.createCell(0);
                cell.setCellValue(arr[i][0]);
                cell = row.createCell(1);
                cell.setCellValue(ocenki[0]);
                cell = row.createCell(2);
                cell.setCellValue(ocenki[1]);
                cell = row.createCell(3);
                cell.setCellValue(ocenki[3]);
                sh1.autoSizeColumn(0);
                wb.write(fos);
                fos.close();
                System.out.println(ocenki[0] + " " + ocenki[1] + " " + ocenki[2] + " " + ocenki[3]);
                if (ocenki[0] > 1) System.out.println(arr[i][0]);
                else System.out.println(" - ");
                if (ocenki[1] == 1) System.out.println(arr[i][0]);
                else System.out.println(" - ");
                if (ocenki[2] == 1) System.out.println(arr[i][0]);
                else System.out.println(" - ");
                if (ocenki[0] == 0 && ocenki[1] == 0) {
                    System.out.println(arr[i][0]);
                } else System.out.println(" - ");
                if (ocenki[0] == 0 && ocenki[1] == 0 && ocenki[2] == 0) {
                    System.out.println(arr[i][0]);
                } else System.out.println(" - ");
            }

        fos.close();
        }
}