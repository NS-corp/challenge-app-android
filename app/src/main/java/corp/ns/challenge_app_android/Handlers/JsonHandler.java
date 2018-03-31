package corp.ns.challenge_app_android.Handlers;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import corp.ns.challenge_app_android.Bridges.ConnectionBridge;
import corp.ns.challenge_app_android.RequestData.Request;
import corp.ns.challenge_app_android.RequestData.RequestData;
import corp.ns.challenge_app_android.RequestData.Response;
import corp.ns.challenge_app_android.RequestData.ResponseData;

public class JsonHandler {

    private static String parseStringToJson(String string) {
        int firstBraceIndex = string.indexOf("{");
        return firstBraceIndex != -1 ? string.substring(firstBraceIndex) : "";
    }

    // Debug
    public static void showReceivedJson(Context context, ResponseData requestOut) {
        ToastHandler.makeToast(context,
                "Получено: " + new GsonBuilder().create().toJson(requestOut));
    }

    public static boolean checkResponse(Context context, Response response) {
        return false;
    }

    private static Response getResponse(Context context,
                                        String jsonData, ConnectionBridge connectionBridge) {

        Response response;

        // Send request from connectionBridge

        return null;
    }

    public static <S extends RequestData, R extends ResponseData>
                    Response sendRequest(Context context,
                                         Request<S, R> request,
                                         ConnectionBridge connectionBridge) {
        // Format to JSON
        Gson gson = new GsonBuilder().create();
        String jsonIn = gson.toJson(request.getRequestData());
        Log.i("jsonIn", jsonIn);

        // Get response
        Response response = getResponse(context, jsonIn, connectionBridge);

        if (response == null) {
            return null;
        }

        // Get json response
        String jsonOut = parseStringToJson(response.getStringResponse());
        Log.i("jsonOut", jsonOut);

        // Format to ResponseData
        R out = null;
        if (response.isStatusOK() || jsonOut.length() > 0) {
            try {
                out = gson.fromJson(jsonOut, request.getResponseDataClass());
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.e("jsonError", "Catch exception");
            }
        }
        response.setResponseData(out);
        return response;
    }
}
