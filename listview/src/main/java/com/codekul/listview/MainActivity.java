package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customAdapter();
    }

    private void customAdapter(){

        final ArrayList<MyItem> dataSet =
                new ArrayList<>();
        dataSet.add(new MyItem(1l,R.mipmap.ic_launcher,"Android"));
        dataSet.add(new MyItem(2l,R.mipmap.ic_launcher,"iOS"));
        dataSet.add(new MyItem(3l,R.mipmap.ic_launcher,"Rim"));
        dataSet.add(new MyItem(4l,R.mipmap.ic_launcher,"Windows"));
        dataSet.add(new MyItem(5l,R.mipmap.ic_launcher,"Symbian"));

        MyAdapter adapter =
                new MyAdapter(this,dataSet);

        ((ListView) findViewById(R.id.listCountries)).setAdapter(adapter);
    }

    private void arrayAdapter(){
        final ArrayList<String> dataSet =
                new ArrayList<>();
        dataSet.add("India");
        dataSet.add("Chiana");
        dataSet.add("Japan");
        dataSet.add("Shri Lanka");
        dataSet.add("Nepal");

        ListView listView = (ListView) findViewById(R.id.listCountries);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView text = (TextView) view;
                ((TextView)findViewById(R.id.textItem))
                        .setText(text
                                .getText()
                                .toString());
            }
        });

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dataSet);
        listView.setAdapter(adapter);
    }
}
