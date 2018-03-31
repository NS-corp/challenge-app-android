package corp.ns.challenge_app_android.RequestData;

import android.os.Parcel;
import android.os.Parcelable;

public class Request<S extends RequestData, R extends ResponseData> implements Parcelable {

    private S requestData;
    private Class<S> requestDataClass;
    private Class<R> responseDataClass;

    public Request(Class<S> requestDataClass, Class<R> responseDataClass) {
        this.requestDataClass = requestDataClass;
        this.responseDataClass = responseDataClass;
    }

    public S getRequestData() {
        return requestData;
    }

    public Class<R> getResponseDataClass() {
        return responseDataClass;
    }

    public void setRequestData(S sendData) {
        this.requestData = sendData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.requestDataClass);
        dest.writeParcelable(this.requestData, flags);
        dest.writeSerializable(this.responseDataClass);
    }

    @SuppressWarnings("unchecked")
    protected Request(Parcel in) {
        this.requestDataClass = (Class<S>) in.readSerializable();
        this.requestData = in.readParcelable(requestDataClass.getClassLoader());
        this.responseDataClass = (Class<R>) in.readSerializable();
    }

    public static final Creator<Request> CREATOR = new Creator<Request>() {
        @Override
        public Request createFromParcel(Parcel source) {
            return new Request(source);
        }

        @Override
        public Request[] newArray(int size) {
            return new Request[size];
        }
    };
}
