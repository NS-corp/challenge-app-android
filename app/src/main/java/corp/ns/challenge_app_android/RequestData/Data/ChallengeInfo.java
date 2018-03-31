package corp.ns.challenge_app_android.RequestData.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class ChallengeInfo implements Parcelable {

    /* Constants */

    public static final String CHALLENGE_KEY = "challenge_key";

    /* Private fields */

    private int id;
    private String name;

    /* Getters and Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* Constructors */

    public ChallengeInfo() {
    }

    protected ChallengeInfo(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    public static final Parcelable.Creator<ChallengeInfo> CREATOR = new Parcelable.Creator<ChallengeInfo>() {
        @Override
        public ChallengeInfo createFromParcel(Parcel source) {
            return new ChallengeInfo(source);
        }

        @Override
        public ChallengeInfo[] newArray(int size) {
            return new ChallengeInfo[size];
        }
    };
}
