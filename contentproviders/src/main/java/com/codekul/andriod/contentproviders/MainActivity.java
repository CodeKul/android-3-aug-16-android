package com.codekul.andriod.contentproviders;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMyDb();
    }

    private void showContacts(){

        ContentResolver resolver =
                getContentResolver();

         Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor c = resolver.query(uri,projection,selection,selectionArgs,sortOrder);

        ArrayList<String> dataSet = new ArrayList<>();

        while(c.moveToNext()){

            String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            dataSet.add(name+"\n"+number);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSet);

        ((ListView)findViewById(R.id.listContacts)).setAdapter(adapter);
    }

    private void showMyDb(){

        ContentResolver resolver =
                getContentResolver();

        Uri uri = Uri.parse("content://com.codekul.db.provider");
        String[] projection = {"myName","myCity"};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor c = resolver.query(uri,projection,selection,selectionArgs,sortOrder);

        ArrayList<String> dataSet = new ArrayList<>();

        while(c.moveToNext()){

            String name = c.getString(c.getColumnIndex("myName"));
            String number = c.getString(c.getColumnIndex("myCity"));
            dataSet.add(name+"\n"+number);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSet);

        ((ListView)findViewById(R.id.listContacts)).setAdapter(adapter);
    }
}
