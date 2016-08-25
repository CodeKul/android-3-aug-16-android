package com.codekul.dialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlertDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd(MyDialog.DIALOG_ALERT);
            }
        });

        findViewById(R.id.btnDatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd(MyDialog.DATE_PICKER);
            }
        });

        findViewById(R.id.btnTimePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd(MyDialog.TIME_PICKER);
            }
        });

        findViewById(R.id.btnProgress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd(MyDialog.PROGRESS);
            }
        });

        findViewById(R.id.btnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd(MyDialog.CUSTOM);
            }
        });

    }

    private void sd(String tag){
        MyDialog dialog = new MyDialog();
        dialog.show(getSupportFragmentManager(),tag);
    }
}
