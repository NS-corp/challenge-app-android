package corp.ns.challenge_app_android.RequestData.DefaultData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.RequestData;

public class DefaultRequestData implements RequestData {

    /* Request fields */

    private int userID; // User ID

    /* Getters and Setters */

    @Override
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    /* Constructors */

    public DefaultRequestData(int userID){
        this.userID = userID;
    }

    protected DefaultRequestData(Parcel in) {
        this.userID = in.readInt();
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userID);
    }

    public static final Creator<DefaultRequestData> CREATOR = new Creator<DefaultRequestData>() {
        @Override
        public DefaultRequestData createFromParcel(Parcel source) {
            return new DefaultRequestData(source);
        }

        @Override
        public DefaultRequestData[] newArray(int size) {
            return new DefaultRequestData[size];
        }
    };

}
