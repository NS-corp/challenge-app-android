package corp.ns.challenge_app_android;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import corp.ns.challenge_app_android.Consts.ExtraNames;
import corp.ns.challenge_app_android.RequestData.Data.UserInfo;

public class UserActivity extends AppCompatActivity {

    @BindView(R.id.et_test)
    EditText editTextTest;
    @BindView(R.id.button_test)
    Button buttonTest;

    @BindView(R.id.user_name)
    TextView mUserNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        // Take UserInfo from intent
        placeUserInfo((UserInfo) getIntent().
                getParcelableExtra(ExtraNames.USER_INFO_EXTRA));
    }

    public void onChallengeButtonClicked(View view){
        Intent intent = new Intent(this, ChallengeListActivity.class);
        startActivity(intent);
    }

    public void onHistoryButtonClicked(View view){}

    private void placeUserInfo(@Nullable UserInfo userInfo){
        if(userInfo == null){
            return;
        }

        mUserNameTextView.setText(userInfo.getName());
    }



}
