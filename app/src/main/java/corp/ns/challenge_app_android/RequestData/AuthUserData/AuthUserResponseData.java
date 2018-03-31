package corp.ns.challenge_app_android.RequestData.AuthUserData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.Data.UserInfo;
import corp.ns.challenge_app_android.RequestData.DefaultData.DefaultResponseData;
import lombok.Getter;
import lombok.Setter;

public class AuthUserResponseData extends DefaultResponseData {

    /* Request fields */

    @Getter @Setter
    UserInfo userInfo;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.userInfo, flags);
    }

    public AuthUserResponseData(boolean requestStatus, UserInfo userInfo) {
        super(requestStatus);
        this.userInfo = userInfo;
    }

    protected AuthUserResponseData(Parcel in) {
        super(in);
        this.userInfo = in.readParcelable(UserInfo.class.getClassLoader());
    }

    public static final Creator<AuthUserResponseData> CREATOR = new Creator<AuthUserResponseData>() {
        @Override
        public AuthUserResponseData createFromParcel(Parcel source) {
            return new AuthUserResponseData(source);
        }

        @Override
        public AuthUserResponseData[] newArray(int size) {
            return new AuthUserResponseData[size];
        }
    };
}
