package com.codekul.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@codekul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // /data/data/your-package/shared_prefs/my.xml
        // /data/data/your-package/files/my.txt
        // /data/data/your-package/database/my

        try {
            writeToOurDirectory();

            readFromOurDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile() throws Exception{
        FileOutputStream fos = openFileOutput("my.txt",MODE_APPEND);
        fos.write("This is {code}kul;".getBytes());
        fos.close();
    }

    private void readFile() throws Exception{
        FileInputStream fis = openFileInput("my.txt");

        StringBuilder builder = new StringBuilder();
        while(true){
            int ch = fis.read();
            if(ch == -1) break;
            else builder.append((char)ch);
        }
        Log.i(TAG,builder.toString());
        fis.close();
    }

    private void someUsefulMethods(){

        Log.i(TAG,"getFilesDir - "+getFilesDir().getAbsolutePath());

        Log.i(TAG,"getDir - "+getDir("my",MODE_PRIVATE).getAbsolutePath());

        for (String s : fileList()) {
            Log.i(TAG,"File Internal - "+s);
        }
    }

    private void writeToOurDirectory() throws Exception{
        File file =
                new File(getDir("my",MODE_APPEND),"out.txt");

        FileOutputStream fos = new FileOutputStream(file,true);
        fos.write("this is {code}kul;".getBytes());
        fos.close();
    }

    private void readFromOurDirectory() throws Exception{

        File file =
                new File(getDir("my",MODE_APPEND),"out.txt");

        FileInputStream fis = new FileInputStream(file);
        StringBuilder builder = new StringBuilder();
        while(true){
            int ch = fis.read();
            if(ch == -1) break;
            else  builder.append((char)ch);
        }
        Log.i(TAG,builder.toString());
    }
}
