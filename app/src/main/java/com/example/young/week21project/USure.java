package com.example.young.week21project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Young on 2/25/2016. Stolen from google!!!!
 */
public class USure extends DialogFragment {
    MainActivity class1= new MainActivity();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //remove saved value

                class1.textView.setText("");
                class1.textDisappearer.setVisibility(View.VISIBLE);
                class1.editText.setVisibility(View.VISIBLE);



            }
        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        }
                });
        return builder.create();
    }


}
