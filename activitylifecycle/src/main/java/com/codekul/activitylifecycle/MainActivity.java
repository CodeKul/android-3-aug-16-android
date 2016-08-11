package com.codekul.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_TEXT_VIEW = "textData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState != null)
            ((TextView)findViewById(R.id.textInfo))
                    .setText(savedInstanceState
                            .getString(KEY_TEXT_VIEW));*/

        mt("onCreate");

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((TextView)findViewById(R.id.textInfo))
                        .setText(""+new Date());
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();

        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mt("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        mt("onPause");
    }

    @Override
    protected void onStop() {

        super.onStop();

        mt("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mt("onDestroy");
    }

    private void mt(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_TEXT_VIEW,((TextView)findViewById(R.id.textInfo)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null)
            ((TextView)findViewById(R.id.textInfo))
                    .setText(savedInstanceState
                            .getString(KEY_TEXT_VIEW));
    }
}
