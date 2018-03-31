package corp.ns.challenge_app_android.RequestData.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthorizeInfo implements Parcelable {

    /* Private fields */

    private String login;
    private String password;

    /* Getters and Setters */

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Constructors */

    public AuthorizeInfo() {
    }

    protected AuthorizeInfo(Parcel in) {
        this.login = in.readString();
        this.password = in.readString();
    }

    /* Parcelable */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeString(this.password);
    }

    public static final Parcelable.Creator<AuthorizeInfo> CREATOR = new Parcelable.Creator<AuthorizeInfo>() {
        @Override
        public AuthorizeInfo createFromParcel(Parcel source) {
            return new AuthorizeInfo(source);
        }

        @Override
        public AuthorizeInfo[] newArray(int size) {
            return new AuthorizeInfo[size];
        }
    };
}
