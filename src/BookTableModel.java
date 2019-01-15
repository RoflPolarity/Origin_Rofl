import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {
    Main sel = new Main();
    Main1 setName = new Main1();
    @Override
    public int getRowCount() {
        sel.open();
        return sel.select_people().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        String [] [] people  = setName.transformArrayList(setName.getNames());
        return people;
    }
}