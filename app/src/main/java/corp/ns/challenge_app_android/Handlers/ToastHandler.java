package corp.ns.challenge_app_android.Handlers;

import android.content.Context;
import android.widget.Toast;


public class ToastHandler {

    public static void makeToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Toast for status STATUS_CONNECTION_ERROR
     */
    private static void onStatusConnectionError(Context context, int connectionStatus){
        /*ToastHandler.makeToast(context, "Ошибка подключения к серверу\nКод ошибки:"
                + connectionStatus);*/
        ToastHandler.makeToast(context, "Ошибка подключения к серверу");
    }

    /**
     * Toast for status STATUS_WRONG_ADDRESS
     */
    private static void onStatusWrongAddress(Context context){
        ToastHandler.makeToast(context, "Неверный адрес сервера");
    }

    /**
     * Toast for status STATUS_NETWORK_UNAVAILABLE
     */
    private static void onStatusNetworkUnavailable(Context context){
        ToastHandler.makeToast(context, "Нет подключения к сети.\n" +
                " Подключитесь к сети и попробуйте снова");

    }

    /**
     * Toast for status CONNECTION_STATUS_TIMEOUT_ERROR
     */
    private static void onStatusTimeoutError(Context context){
        ToastHandler.makeToast(context, "Превышено время ожидания. \n" +
                "Запрос не отправлен");
    }
}
