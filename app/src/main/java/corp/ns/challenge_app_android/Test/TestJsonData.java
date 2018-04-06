package corp.ns.challenge_app_android.Test;

import java.util.ArrayList;
import java.util.List;

import corp.ns.challenge_app_android.RequestData.Data.ChallengeInfo;

public class TestJsonData {
    public static List<ChallengeInfo> getChallenges(){
        List<ChallengeInfo> challenges = new ArrayList<>();

        ChallengeInfo challengeKek = new ChallengeInfo();
        challengeKek.setName("Kek");
        challenges.add(challengeKek);

        ChallengeInfo challengeLol = new ChallengeInfo();
        challengeLol.setName("Lol");
        challenges.add(challengeLol);

        ChallengeInfo challengeCheburek = new ChallengeInfo();
        challengeCheburek.setName("Cheburek");
        challenges.add(challengeCheburek);

        return challenges;
    }
}
