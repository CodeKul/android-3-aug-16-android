package com.codekul.dialogs;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends AppCompatDialogFragment {

    public static final String DIALOG_ALERT = "alert";
    private static final String TAG = "@codekul";
    public static final String DATE_PICKER = "datePicker";
    public static final String TIME_PICKER = "timePicker";
    public static final String PROGRESS = "progress";
    public static final String CUSTOM = "custom";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;

        if (getTag().equals(DIALOG_ALERT)) dialog = makeAlert();
        if(getTag().equals(DATE_PICKER)) dialog = makeDatePicker();
        if(getTag().equals(TIME_PICKER)) dialog = makeTimePicker();
        if(getTag().equals(PROGRESS)) dialog = makeProgress();
        if(getTag().equals(CUSTOM)) dialog = makeCustom();

        return dialog;
    }

    private Dialog makeAlert() {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.alertTitle)
                        .setMessage(R.string.alertMsg)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton(R.string.btnYes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i(TAG, "Positive Clicked");
                            }
                        })
                        .setNegativeButton(R.string.btnNo, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i(TAG, "Negative Clicked");
                            }
                        })
                        .setNeutralButton(R.string.btnNeutral, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i(TAG, "Neutral Clicked");
                            }
                        });

        return builder.create();
    }

    public Dialog makeDatePicker(){

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.i(TAG,""+(dayOfMonth)+" - "+(monthOfYear+1)+" - "+year);
            }
        },2016,7,24);

        return datePickerDialog;
    }

    public Dialog makeTimePicker(){

        TimePickerDialog timePickerDialog =
                new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Log.i(TAG,""+hourOfDay +" : "+minute);
                    }
                },6,8,false);
        return timePickerDialog;
    }

    public Dialog makeProgress(){

        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setMessage(getResources().getString(R.string.alertMsg));
        dialog.setTitle(getResources().getString(R.string.alertTitle));
        dialog.setIcon(R.mipmap.ic_launcher);
        //dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        return dialog;
    }

    public Dialog makeCustom(){

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_my_dialog,null,false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view);

        AlertDialog dialog = builder.create();
        view.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Login Clicked");
            }
        });

        return dialog;
    }
}
