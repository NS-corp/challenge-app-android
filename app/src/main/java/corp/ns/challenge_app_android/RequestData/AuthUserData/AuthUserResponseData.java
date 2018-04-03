package corp.ns.challenge_app_android.RequestData.AuthUserData;

import android.os.Parcel;

import corp.ns.challenge_app_android.RequestData.Data.UserInfo;
import corp.ns.challenge_app_android.RequestData.DefaultData.DefaultResponseData;

public class AuthUserResponseData extends DefaultResponseData {

    /* Request fields */

    private UserInfo uinf;

    public UserInfo getUserInfo() {
        return uinf;
    }

    public void setUserInfo(UserInfo uInf) {
        this.uinf = uInf;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.uinf, flags);
    }

    public AuthUserResponseData(boolean requestStatus, UserInfo userInfo) {
        super(requestStatus);
        this.uinf = userInfo;
    }

    protected AuthUserResponseData(Parcel in) {
        super(in);
        this.uinf = in.readParcelable(UserInfo.class.getClassLoader());
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
