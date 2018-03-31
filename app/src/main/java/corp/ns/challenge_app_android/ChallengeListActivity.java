package corp.ns.challenge_app_android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import corp.ns.challenge_app_android.RequestData.Data.ChallengeInfo;

public class ChallengeListActivity extends AppCompatActivity {

    DbHelper dbHelper;

    ListView challengesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);

        dbHelper = new DbHelper(this);

        challengesListView = findViewById(R.id.challenges_list_view);
    }

    @Override
    protected void onStart() {
        super.onStart();

        updateList();
    }

    private void updateList(){
        // Package data in understandable for adapter structure
        ArrayList<Map<String, ChallengeInfo>> data = new ArrayList<>();
        Map<String, ChallengeInfo> m;

        // Attribute's names array
        String[] from = { ChallengeViewBinder.CHALLENGE_VIEW,
                ChallengeViewBinder.CHALLENGE_VIEW_NAME};
        // Array of ID of View-components in list element layout
        int[] to = { R.id.challenge_view, R.id.challenge_view_name };

        List<ChallengeInfo> challenges = getChallengeList();
        for(ChallengeInfo challenge : challenges){
            m = new HashMap<>();
            for(String keyFrom : from){
                m.put(keyFrom, challenge);
            }

            data.add(m);
        }

        // Create adapter
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.challenge_view,
                from, to);
        // Set binder for adapter
        sAdapter.setViewBinder(new ChallengeViewBinder());

        // Set adapter to ListView
        challengesListView.setAdapter(sAdapter);
    }

    public List<ChallengeInfo> getChallengeList(){
        List<ChallengeInfo> challenges = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.query(ChallengeTableData.TABLE_NAME, null, null,
                null, null, null, null);

        ChallengeCursor challengeCursor = new ChallengeCursor();
        challengeCursor.setIdColumnIndex(cursor.getColumnIndex(ChallengeTableData.COLUMN_ID));
        challengeCursor.setNameColumnIndex(cursor.getColumnIndex(ChallengeTableData.COLUMN_NAME));
        while (cursor.moveToNext()){
            ChallengeInfo challenge = new ChallengeInfo();
            challenge.setId(cursor.getInt(challengeCursor.getIdColumnIndex()));
            challenge.setName(cursor.getString(challengeCursor.getNameColumnIndex()));

            challenges.add(challenge);
        }

        cursor.close();

        return challenges;
    }

    public void onAddChallengeButtonClicked (View view) {
        Intent intent = new Intent(this, CreateChallengeActivity.class);
        startActivity(intent);
    }

    private class ChallengeViewBinder implements SimpleAdapter.ViewBinder {
        public static final String CHALLENGE_VIEW = "challenge_view";
        public static final String CHALLENGE_VIEW_NAME = "challenge_view_name";

        @Override
        public boolean setViewValue(View view, Object o, String s) {
            final ChallengeInfo challenge = (ChallengeInfo) o;

            switch (view.getId()){
                case R.id.challenge_view:
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), ChallengeActivity.class);
                            intent.putExtra(ChallengeInfo.CHALLENGE_KEY, challenge);
                            startActivity(intent);
                        }
                    });
                    return true;
                case R.id.challenge_view_name:
                    ((TextView) view).setText(challenge.getName());
                    return true;
            }

            return false;
        }
    }
}
