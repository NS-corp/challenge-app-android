package corp.ns.challenge_app_android.RetrofitApi;

import android.util.Log;

import corp.ns.challenge_app_android.RequestData.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ResponseCallback<T extends ResponseData> implements Callback<T>{

    /**
     * Method already overrided
     * Include checking response body for null and request status
     * All steps is logging
     */
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.i("retrofit", call.request().toString());
        T responseData = response.body();
        // Check null
        if(responseData == null) {
            Log.e("retrofit", "Null body");
            return;
        }

        Log.i("retrofit", response.toString());
        // Check Request Status
        if(responseData.getRes()){
            onRequestSuccess(responseData);
        } else {
            Log.e("retrofit", "Request Status failure");
        }
    }

    /**
     * Abstract method must override in anonymous class,
     * that will use in retrofit request
     *
     * Method will invoke if request is success
     * @param responseData with requestStatus == true
     */
    abstract public void onRequestSuccess(T responseData);

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.i("retrofit", call.request().toString());
        Log.e("retrofit", t.toString());
    }
}
