import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class print {

        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = printService.createPrintJob();
        DocAttributeSet docAttribute = new HashDocAttributeSet();

        void print () throws FileNotFoundException {
            DocFlavor[] docFlavors = printService.getSupportedDocFlavors();
            //Doc doc = new SimpleDoc(new FileInputStream("Отчет.txt"),docFlavors,docAttribute);
            docAttribute.add(OrientationRequested.PORTRAIT);
            PrintRequestAttributeSet printAttributes = new HashPrintRequestAttributeSet();

//            try {
//                //job.print("Отчет.xls",printAttributes);
//            }catch (PrintException e){
//                System.out.println(e.getMessage());
//            }
        }
}
