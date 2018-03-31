package corp.ns.challenge_app_android.RequestData.RegisterUserData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.DefaultData.DefaultRequestData;

public class RegisterUserRequestData extends DefaultRequestData {

    /* Request fields */

    private String userName; // User name

    /* Getters and Setters */

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /* Constructors */

    public RegisterUserRequestData(int userID, String userName) {
        super(userID);
        this.userName = userName;
    }

    protected RegisterUserRequestData(Parcel in) {
        super(in);
        this.userName = in.readString();
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.userName);
    }

    public static final Creator<RegisterUserRequestData> CREATOR = new Creator<RegisterUserRequestData>() {
        @Override
        public RegisterUserRequestData createFromParcel(Parcel source) {
            return new RegisterUserRequestData(source);
        }

        @Override
        public RegisterUserRequestData[] newArray(int size) {
            return new RegisterUserRequestData[size];
        }
    };
}
