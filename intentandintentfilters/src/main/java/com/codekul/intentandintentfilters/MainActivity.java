package com.codekul.intentandintentfilters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISION_CALL = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3();
            }
        });
    }

    private void simple(){
        //                Intent intent =
//                        new Intent(MainActivity.this,NextActivity.class); //Explicit intent
        Intent intent =
                new Intent("com.codekul.action.NEXT");//
        startActivity(intent);
    }

    private void dial(){

        Intent intent =
                new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call(){

        // marshmallow
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISION_CALL);
        }
        else {
            Intent intent =
                    new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel://9762548833"));
            startActivity(intent);
        }
    }

    private void mp3(){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        File fileMp3 = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),
                "a.mp3");

        intent.setDataAndType(Uri.fromFile(fileMp3),"audio/*");
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISION_CALL){
            if(grantResults.length > 0){

                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent =
                            new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel://9762548833"));
                    startActivity(intent);
                }
            }
        }
    }
}
