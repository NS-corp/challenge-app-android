package corp.ns.challenge_app_android.Services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;

import corp.ns.challenge_app_android.Bridges.ConnectionBridge;
import corp.ns.challenge_app_android.Fragments.LoadingDialogFragment;
import corp.ns.challenge_app_android.Handlers.JsonHandler;
import corp.ns.challenge_app_android.RequestData.Request;
import corp.ns.challenge_app_android.RequestData.Response;
import corp.ns.challenge_app_android.Receivers.RequestReceiver;

public class RequestService extends IntentService {
    public static final String INTENT_EXTRA_JSON_REQUEST = "jsonRequest";
    public static final String INTENT_EXTRA_JSON_REQUEST_RESULT = "jsonRequestResult";
    public static final String BROADCAST_REQUEST_ACTION
            = "corp.ns.challengeapplication.request_action"; // For IntentFilter

    @Override
    protected void onHandleIntent(Intent intent) {
        Request request = intent.getParcelableExtra(INTENT_EXTRA_JSON_REQUEST);

        // Creating ConnectionBridge
        /* TODO ADD connection bridge init */
        ConnectionBridge connectionBridge = null;

        Response response = JsonHandler.sendRequest(
                        getApplicationContext(), request, connectionBridge);

        // Send request result to receiver
        sendBroadcast(new Intent(BROADCAST_REQUEST_ACTION)
                .putExtra(INTENT_EXTRA_JSON_REQUEST_RESULT, response));
    }

    public RequestService() {
        super("RequestService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * This function show loading dialog and send request
     *
     * @param context - application context
     * @param requestReceiver - where answer must be send
     * @param dialog - loading dialog for show to user
     * @param manager - need to show dialog
     * @param jsonRequest - what request must be send
     */
    public static void sendRequest(Context context, RequestReceiver requestReceiver,
                                            LoadingDialogFragment dialog, FragmentManager manager,
                                            Request jsonRequest) {
        // Show loading dialog
        if (!dialog.isAdded()) {
            dialog.show(manager, "dialog");
        }

        startRequestService(context, requestReceiver, jsonRequest);
    }

    private static void startRequestService(Context context, RequestReceiver requestReceiver,
                                   Request jsonRequest) {
        requestReceiver.registerReceiver();
        Intent serviceIntent = new Intent(context, RequestService.class)
                .putExtra(RequestService.INTENT_EXTRA_JSON_REQUEST, jsonRequest);
        context.startService(serviceIntent);
    }
}
