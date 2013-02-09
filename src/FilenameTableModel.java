import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: tmb
 * Date: 28/01/13
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class FilenameTableModel extends AbstractTableModel {
    private String[] columnNames = {"id", "filename"};
    private ArrayList<DbFilename> rowData;

    public FilenameTableModel()
    {
        MySqlAdapter adapter = new MySqlAdapter();
        rowData = adapter.getAllRows();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return rowData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col].toString();
    }

    public Object getValueAt(int rowIndex, int colIndex) {
        DbFilename row = rowData.get(rowIndex);
        switch (colIndex) {
            case 0:
                return row.getId();
            case 1:
                return row.getFileName();
        }
         return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
