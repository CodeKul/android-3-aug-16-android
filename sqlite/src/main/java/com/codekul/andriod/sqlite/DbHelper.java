package com.codekul.andriod.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by aniruddha on 1/9/16.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final String TAG = "@codekul";

    private Context context;

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder builder = new StringBuilder();
        builder.append("create table ")
                .append(context.getResources().getString(R.string.tableName))
                .append(" ( ")
                .append(context.getResources().getString(R.string.colMyCity))
                .append(" text")
                .append(",")
                .append(context.getResources().getString(R.string.colMyName))
                .append(" text")
                .append(")");

        Log.i(TAG,"Query is - "+builder.toString());

        db.execSQL(builder.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
