package camera2prueba.example.org.camera2apiprueba;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Eduardo on 15/11/2016.
 */



public class ConfirmacionPermisos extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(getResources().getText(R.string.permiso_camara))
                .setTitle(getResources().getText(R.string.titulo_permisos))
                .setPositiveButton(getResources().getText(R.string.conceder_permiso), new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.setData(Uri.parse("package:" + this.getClass().getPackage().getName()));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(getResources().getText(R.string.denegar_permiso), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}