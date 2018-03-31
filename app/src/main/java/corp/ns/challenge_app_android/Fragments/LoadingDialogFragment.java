package corp.ns.challenge_app_android.Fragments;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;


public class LoadingDialogFragment extends DialogFragment {

    private int dialogLayout;

    public void setDialogLayout(int dialogLayout) {
        this.dialogLayout = dialogLayout;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog.Builder builder = new ProgressDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(dialogLayout, null);
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

    }

    @Override
    public void onCancel(DialogInterface dialog) {
    }
}