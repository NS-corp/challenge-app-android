package corp.ns.challenge_app_android.RetrofitApi;

import corp.ns.challenge_app_android.RequestData.AuthUserData.AuthUserResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerApi {

    @GET("/auth_user_request/")
    Call<AuthUserResponseData> authUserRequest(@Query("userId") int userId);
}
