import javax.swing.table.AbstractTableModel;

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
    public String getColumnName(int column){
        column = 1;
        String names = "ФИО";
        return names;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String [][] array = setName.transformArrayList(setName.getNames());
        return array;
    }
}