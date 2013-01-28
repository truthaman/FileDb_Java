/**
 * Created with IntelliJ IDEA.
 * User: tmb
 * Date: 30/12/12
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MysqlAdapter {

    private static String dbDatabase = "filenames";
    private static String dbUsername = "root";
    private static String dbPassword = "";

    private Connection conn = null;

    public MysqlAdapter() {
        connectToDb();
    }

    private void connectToDb() {
        try {
            String url = "jdbc:mysql://localhost/".concat(dbDatabase);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
        }
    }

    private void disconnectFromDb() {
        if (this.conn != null) {
            try {
                this.conn.close();
                System.out.println("Database connection terminated");
            } catch (Exception e) { /* ignore close errors */ }
        }
    }

    public ArrayList<HashMap<String,Object>> getAllRows() {
        String sql =  "SELECT id_filename, filename FROM filename";
        try {
            Statement stm = conn.createStatement();
            boolean returningRows = stm.execute(sql);

            if (!returningRows)
                return new ArrayList<HashMap<String,Object>>();

            ResultSet result = stm.getResultSet();
            ResultSetMetaData meta = result.getMetaData();

            //get column names
            ArrayList<String> cols = new ArrayList<String>();
            for (int id=1; id <= meta.getColumnCount(); id++)
                cols.add(meta.getColumnName(id));

            //fetch out rows
            ArrayList<HashMap<String,Object>> rows =
                    new ArrayList<HashMap<String,Object>>();

            while (result.next()) {
                HashMap<String,Object> row = new HashMap<String,Object>();
                for (String colName:cols) {
                    Object val = result.getObject(colName);
                    row.put(colName, val);
                }
                rows.add(row);
            }

            result.close();
            stm.close();

            return rows;
        } catch (SQLException e) {
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error number: " + e.getErrorCode());
            return new ArrayList<HashMap<String,Object>>();
        }
    }
}
