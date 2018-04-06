package corp.ns.challenge_app_android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import corp.ns.challenge_app_android.Adapters.ChallengeRecyclerAdapter;
import corp.ns.challenge_app_android.RequestData.Data.ChallengeInfo;
import corp.ns.challenge_app_android.Test.TestJsonData;
import corp.ns.challengeapplication.R;

public class ChallengeListActivity extends AppCompatActivity {

    @BindView(R.id.challenges_list_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);
        ButterKnife.bind(this);

        setChallengesInList(testLoadChallenges());

    }

    private void setChallengesInList(List<ChallengeInfo> challenges){
        // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        // передаем параметр true - это увеличивает производительность
        mRecyclerView.setHasFixedSize(true);

        // используем linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        // создаем адаптер
        RecyclerView.Adapter adapter = new ChallengeRecyclerAdapter(challenges);
        mRecyclerView.setAdapter(adapter);
    }

    private List<ChallengeInfo> testLoadChallenges(){
        return TestJsonData.getChallenges();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void onAddChallengeButtonClicked (View view) {
        Intent intent = new Intent(this, CreateChallengeActivity.class);
        startActivity(intent);
    }

}
