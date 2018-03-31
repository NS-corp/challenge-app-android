package corp.ns.challenge_app_android.RequestData.RegisterUserData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.DefaultData.DefaultResponseData;

public class RegisterUserResponseData extends DefaultResponseData {

    /* Request fields */

    private int userID; // User ID

    /* Getters and Setters */

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    /* Constructors */

    public RegisterUserResponseData(boolean requestStatus, int userID) {
        super(requestStatus);
        this.userID = userID;
    }

    protected RegisterUserResponseData(Parcel in) {
        super(in);
        this.userID = in.readInt();
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.userID);
    }

    public static final Creator<RegisterUserResponseData> CREATOR = new Creator<RegisterUserResponseData>() {
        @Override
        public RegisterUserResponseData createFromParcel(Parcel source) {
            return new RegisterUserResponseData(source);
        }

        @Override
        public RegisterUserResponseData[] newArray(int size) {
            return new RegisterUserResponseData[size];
        }
    };
}
