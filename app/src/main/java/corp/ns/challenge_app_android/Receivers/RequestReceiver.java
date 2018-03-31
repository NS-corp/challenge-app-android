package corp.ns.challenge_app_android.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import corp.ns.challenge_app_android.Fragments.LoadingDialogFragment;
import corp.ns.challenge_app_android.RequestData.Response;
import corp.ns.challenge_app_android.Services.RequestService;


public class RequestReceiver extends BroadcastReceiver {

    public Context context;
    public LoadingDialogFragment dialog;

    public RequestReceiver(Context context, LoadingDialogFragment dialog) {
        this.context = context;
        this.dialog = dialog;
    }

    public RequestReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Response requestResult = intent.getParcelableExtra(
                RequestService.INTENT_EXTRA_JSON_REQUEST_RESULT);

        // Dismiss dialog
        if(dialog != null && dialog.isAdded()) {
            dialog.dismissAllowingStateLoss();
        }

        unregisterReceiver();
        execute(requestResult);
    }

    /**
     * Method for override
     * This method will calling in onReceive
     * and execute something after receive request result
      */
    public void execute(Response response) {

    }

    // Switch on request receiver
    public void registerReceiver() {
        // Create filter for BroadcastReceiver
        IntentFilter intFilter = new IntentFilter(RequestService.BROADCAST_REQUEST_ACTION);

        // Register (turn on) BroadcastReceiver
        context.registerReceiver(this, intFilter);
    }

    // Switch off request receiver
    public void unregisterReceiver() {
        context.unregisterReceiver(this);
    }
}
