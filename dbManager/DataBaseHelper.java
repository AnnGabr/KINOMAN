package dbManager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import dbManager.tablesInfo.ComTestMode;

/**
 * Created by Ann on 21.03.2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Database.db";
    private static String DB_PATH = "";

    private static Context context;
    private static SQLiteDatabase database;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);

        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        this.context = context;
    }

    //do the same as func below
    public void initDatabase() throws IOException{
        try{
            copyDataBase();
            Log.e("Tag", "database copied");
        } catch (IOException e) {
            throw new Error("Error: can not copy database");
        }
    }

    //copy existing database from assets folder to data/databases
    private void copyDataBase() throws IOException
    {
        InputStream in = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream out = new FileOutputStream(outFileName);

        byte[] buf = new byte[1024];
        int length;
        while ((length = in.read(buf)) > 0)
            out.write(buf, 0, length);

        out.flush();
        out.close();
        in.close();
    }

    //check if database exists in data/databases
    private boolean dbExists() {
        File dbFile = new File(DB_PATH + DB_NAME);
        Log.v("dbFile", dbFile + "   "+ dbFile.exists());

        return dbFile.exists();
    }

    //open database from data/databases
    public boolean open() throws SQLException {
        String dbPath = DB_PATH + DB_NAME;
        Log.v("dbPath", dbPath);
        database = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);

        return database != null;
    }

    @Override
    public synchronized void close() {
        if(database != null)
            database.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
