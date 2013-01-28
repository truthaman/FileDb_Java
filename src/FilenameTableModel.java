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
    private String[] columnNames = {"id", "name"};
    private Object[][] data;

    public FilenameTableModel()
    {
        MySqlAdapter adapter = new MySqlAdapter();
        ArrayList<HashMap<String,Object>> rows = adapter.getAllRows();
        int count = 0;
        for (HashMap<String,Object> row : rows) {

            System.out.println(row.keySet());
            Object[] keys =  row.keySet().toArray();

            for (Object key:keys) {
                //System.out.println(key);
            }
            //columnNames = row.keySet().toArray();
            //data[count++] = row.values().toArray();
            System.out.println(row.values());
        }


    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
