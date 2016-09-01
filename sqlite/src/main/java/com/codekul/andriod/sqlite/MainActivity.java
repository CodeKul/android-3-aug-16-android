package com.codekul.andriod.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@codekul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper = new DbHelper(this,
                getResources()
                        .getString(R.string.dbName),
                null,
                getResources()
                        .getInteger(R.integer.dbVersion));

        findViewById(R.id.btnInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb =
                        helper.getWritableDatabase();

                ContentValues values =
                        new ContentValues();
                values.put(getResources().getString(R.string.colMyName),"android");
                values.put(getResources().getString(R.string.colMyCity),"Pune");

                sqDb.insert(getResources().getString(R.string.tableName),null,values);
                sqDb.close();

                Log.i(TAG,"Data Inserted Successfully .. ");
            }
        });

        findViewById(R.id.btnQuery)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb =
                        helper.getReadableDatabase();

                String table = getValue(R.string.tableName);

                String[] columns = {getValue(R.string.colMyCity)};

                String selection =getValue(R.string.colMyName) +" = ?";

                String[] selectionArgs = new String[]{"android"};

                String groupBy =null;
                String having =null;
                String orderBy = null;

                Cursor cursor =
                        sqDb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);

                while(cursor.moveToNext()){

                    /*String myName = cursor
                            .getString(cursor
                                    .getColumnIndex(getResources()
                                            .getString(R.string.colMyName)));*/

                    String myCity = cursor
                            .getString(cursor
                                    .getColumnIndex(getResources()
                                            .getString(R.string.colMyCity)));

                    //Log.i(TAG,"My Name - "+myName +" My City - "+myCity);
                    Log.i(TAG," My City - "+myCity);
                }

                sqDb.close();
            }
        });

        findViewById(R.id.btnUpdate)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb = helper.getWritableDatabase();

                String table = getValue(R.string.tableName);
                ContentValues values = new ContentValues();
                values.put(getValue(R.string.colMyCity),"sangli");
                String whereClause = getValue(R.string.colMyName) +" = ?";
                String[] whereArgs = {"android"};

                sqDb.update(table,values,whereClause,whereArgs);

                sqDb.close();
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb = helper.getWritableDatabase();

                String table = getValue(R.string.tableName);
                String whereClause = getValue(R.string.colMyCity) +" = ?";
                String[] whereArgs = {"Pune"};

                sqDb.delete(table,whereClause,whereArgs);

                sqDb.close();
            }
        });
    }

    public String getValue(int id){
        return getResources().getString(id);
    }
}
