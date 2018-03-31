package corp.ns.challenge_app_android.RequestData.ChangeTaskStatusData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.DefaultData.DefaultRequestData;

public class ChangeTaskStatusRequestData extends DefaultRequestData {

    /* Request fields */

    private int challengeID;
    private int taskID;
    private boolean taskStatus;

    /* Constructors */

    public ChangeTaskStatusRequestData(int userID) {
        super(userID);
    }

    protected ChangeTaskStatusRequestData(Parcel in) {
        super(in);
        this.challengeID = in.readInt();
        this.taskID = in.readInt();
        this.taskStatus = in.readByte() != 0;
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.challengeID);
        dest.writeInt(this.taskID);
        dest.writeByte(this.taskStatus ? (byte) 1 : (byte) 0);
    }

    public static final Creator<ChangeTaskStatusRequestData> CREATOR = new Creator<ChangeTaskStatusRequestData>() {
        @Override
        public ChangeTaskStatusRequestData createFromParcel(Parcel source) {
            return new ChangeTaskStatusRequestData(source);
        }

        @Override
        public ChangeTaskStatusRequestData[] newArray(int size) {
            return new ChangeTaskStatusRequestData[size];
        }
    };
}
