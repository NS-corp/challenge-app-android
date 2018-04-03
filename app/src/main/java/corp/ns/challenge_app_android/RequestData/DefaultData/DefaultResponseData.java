package corp.ns.challenge_app_android.RequestData.DefaultData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.ResponseData;
import lombok.Getter;
import lombok.Setter;

public class DefaultResponseData implements ResponseData {

    /* Request fields */

    @Setter
    private boolean res;

    /* Getters and Setters */

    public boolean getRes() {
        return res;
    }

    /* Constructors */

    public DefaultResponseData(boolean requestStatus) {
        this.res = requestStatus;
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.res ? (byte) 1 : (byte) 0);
    }

    protected DefaultResponseData(Parcel in) {
        this.res = in.readByte() != 0;
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
