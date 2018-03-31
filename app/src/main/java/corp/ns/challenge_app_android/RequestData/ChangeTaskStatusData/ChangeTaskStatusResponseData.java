package corp.ns.challenge_app_android.RequestData.ChangeTaskStatusData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.DefaultData.DefaultResponseData;

public class ChangeTaskStatusResponseData extends DefaultResponseData {

    /* Constructors */

    public ChangeTaskStatusResponseData(boolean requestStatus) {
        super(requestStatus);
    }

    protected ChangeTaskStatusResponseData(Parcel in) {
        super(in);
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    public static final Creator<ChangeTaskStatusResponseData> CREATOR = new Creator<ChangeTaskStatusResponseData>() {
        @Override
        public ChangeTaskStatusResponseData createFromParcel(Parcel source) {
            return new ChangeTaskStatusResponseData(source);
        }

        @Override
        public ChangeTaskStatusResponseData[] newArray(int size) {
            return new ChangeTaskStatusResponseData[size];
        }
    };
}
