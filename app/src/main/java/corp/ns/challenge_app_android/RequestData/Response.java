package corp.ns.challenge_app_android.RequestData;

import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {

    private ResponseData responseData;

    public ResponseData getResponseData(){
        return responseData;
    }

    public void setResponseData(ResponseData data){
        this.responseData = data;
    }

    public String getStringResponse(){
        return "";
    }

    public boolean isStatusOK(){
        return false;
    }

    public Response() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.responseData, flags);
    }

    protected Response(Parcel in) {
        this.responseData = in.readParcelable(ResponseData.class.getClassLoader());
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel source) {
            return new Response(source);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };
}
