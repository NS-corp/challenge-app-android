package corp.ns.challenge_app_android.RequestData.DefaultData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.ResponseData;

public class DefaultResponseData implements ResponseData {

    /* Request fields */

    private boolean requestStatus;

    /* Getters and Setters */

    public boolean getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    /* Constructors */

    public DefaultResponseData(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.requestStatus ? (byte) 1 : (byte) 0);
    }

    protected DefaultResponseData(Parcel in) {
        this.requestStatus = in.readByte() != 0;
    }

    public static final Creator<DefaultResponseData> CREATOR = new Creator<DefaultResponseData>() {
        @Override
        public DefaultResponseData createFromParcel(Parcel source) {
            return new DefaultResponseData(source);
        }

        @Override
        public DefaultResponseData[] newArray(int size) {
            return new DefaultResponseData[size];
        }
    };
}
