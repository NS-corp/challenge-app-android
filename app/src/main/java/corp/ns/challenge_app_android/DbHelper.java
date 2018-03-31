package corp.ns.challenge_app_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;

    DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createChallengeTable(db);
    }

    private void createChallengeTable(SQLiteDatabase db){
        db.execSQL("create table " + ChallengeTableData.TABLE_NAME + " ("
        + "id integer primary key autoincrement,"
        + ChallengeTableData.COLUMN_NAME + " text"
        + ");");
    }

    void removeTable(String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
