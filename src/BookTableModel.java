import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {
    private ArrayList columnNames = new ArrayList();
    private ArrayList<String[]> dataArrayList;
    private ArrayList columnTypes = new ArrayList();
    private static ArrayList data = new ArrayList();
    public BookTableModel() {
        dataArrayList = new ArrayList<>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }
//
    @Override
    public int getRowCount() {
        synchronized (data) {
            return data.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }
    @Override
    public Class getColumnClass(int column){
        return (Class) columnTypes.get(column);    }

    @Override
    public String getColumnName(int column) {
        return (String)columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        synchronized (data){
            return ((ArrayList)data.get(row)).get(column);
        }
    }
    @Override
    public void setValueAt(
            Object value, int row, int column) {
        synchronized (data) {
            ((ArrayList) data.get(row)).set(column, value);
        }
    }

}
