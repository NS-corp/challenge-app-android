package corp.ns.challenge_app_android;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import corp.ns.challengeapplication.R;

public class CreateChallengeActivity extends AppCompatActivity {

    private DbHelper dbHelper;

    private EditText challengeNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);

        dbHelper = new DbHelper(this);

        challengeNameEditText = findViewById(R.id.challenge_name_edit_text);
    }

    public void onCreateChallengeButtonClicked(View view){
        insertDatabaseRecord();

    }

    public void insertDatabaseRecord(){
        // Connect to database
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        // Put name value
        contentValues.put(ChallengeTableData.COLUMN_NAME, challengeNameEditText.getText().toString());

        // Insert row in database
        long rowID = database.insert(ChallengeTableData.TABLE_NAME, null, contentValues);
        Log.i("DB", "New row id: " + rowID);

        // Close connection
        database.close();
    }
}
