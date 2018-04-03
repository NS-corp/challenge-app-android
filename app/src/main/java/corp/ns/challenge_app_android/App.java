package corp.ns.challenge_app_android;

import android.app.Application;
import android.util.Log;

import corp.ns.challenge_app_android.RetrofitApi.ServerApi;
import lombok.Getter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    @Getter
    private static ServerApi serverApi;
    private static final String serverBaseUrl = "http://192.168.0.103:8080/";

    @Override
    public void onCreate() {
        super.onCreate();

        setUpServerApi();
        Log.i("App", "End onCreate");
    }

    private void setUpServerApi(){
        Retrofit retrofit;
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(serverBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            Log.e("retrofit", "Can't set up retrofit");
            return;
        }
        serverApi = retrofit.create(ServerApi.class);
    }
}
