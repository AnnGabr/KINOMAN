package dbManager;

/**
 * Created by Ann on 24.03.2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

public class DbAdapter
{
    protected static final String TAG = "DataAdapter";

    public final Context context;
    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;

    public DbAdapter(Context context) throws IOException{
        this.context = context;
        dbHelper = new DataBaseHelper(context);
        dbHelper.initDatabase();
    }

    public void open(){
        dbHelper.open();
        dbHelper.close();
        database = dbHelper.getReadableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    //return the cursor to data selected by id
    public Cursor getDataById(int id, String tableName) throws SQLException{
        try
        {
            String sql ="SELECT * FROM " + tableName + " where id=" + id;
            Cursor cursor = database.rawQuery(sql, null);

            return cursor;
        } catch (SQLException e) {
            Log.e(TAG, "getTestData >>"+ e.toString());
            throw e;
        }
    }
}