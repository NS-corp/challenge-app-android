package corp.ns.challenge_app_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import corp.ns.challenge_app_android.RequestData.Data.ChallengeInfo;
import corp.ns.challengeapplication.R;

public class ChallengeActivity extends AppCompatActivity {

    private TextView challengeIdTextView;
    private TextView challengeNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        ChallengeInfo challenge = getIntent().getParcelableExtra(ChallengeInfo.CHALLENGE_KEY);

        challengeIdTextView = findViewById(R.id.challenge_id_text_view);
        challengeNameTextView = findViewById(R.id.challenge_name_text_view);

        challengeIdTextView.setText(String.valueOf(challenge.getId()));
        challengeNameTextView.setText(challenge.getName());

    }
}
