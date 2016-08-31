package com.codekul.externalstorage;

import android.os.Environment;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@codekul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            publicAccessWrite();

            publicAccessRead();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private Boolean isMounted(){
        return Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);
    }

    private void publicAccessWrite() throws Exception{
        if(isMounted()){
            File file =
                    new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"my.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("this is {code}kul;".getBytes());
            fos.close();
        }
        else {
            Toast.makeText(this,R.string.mediaError,Toast.LENGTH_LONG).show();
        }
    }

    private void publicAccessRead() throws Exception {

        if(isMounted()){
            File file =
                    new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"my.txt");

            FileInputStream fis = new FileInputStream(file);

            StringBuilder builder = new StringBuilder();
            while(true){
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }
            Log.i(TAG,builder.toString());
        }
        else {
            Toast.makeText(this,R.string.mediaError,Toast.LENGTH_LONG).show();
        }
    }
}
