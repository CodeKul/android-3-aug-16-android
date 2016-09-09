package com.codekul.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        registerForContextMenu(findViewById(R.id.textInfo));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {

            Snackbar
                    .make(findViewById(R.id.root),"Settings",Snackbar.LENGTH_LONG)
                    .show();

            return true;
        }
        if(id == R.id.actionCopy){
            Snackbar
                    .make(findViewById(R.id.root),"Copy",Snackbar.LENGTH_LONG)
                    .show();
        }
        if(id == R.id.actionPaste){
            Snackbar
                    .make(findViewById(R.id.root),"Paste",Snackbar.LENGTH_LONG)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_scrolling,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.actionCopy){
            Snackbar
                    .make(findViewById(R.id.root),"Copy",Snackbar.LENGTH_LONG)
                    .show();
        }
        return true;
    }
}
