package com.codekul.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> dataSet = new ArrayList<>();
        dataSet.add(R.mipmap.ic_launcher);
        dataSet.add(R.mipmap.ic_launcher);
        dataSet.add(R.mipmap.ic_launcher);
        dataSet.add(R.mipmap.ic_launcher);
        dataSet.add(R.mipmap.ic_launcher);
        dataSet.add(R.mipmap.ic_launcher);
        dataSet.add(R.mipmap.ic_launcher);

        GridView grid = (GridView) findViewById(R.id.gridView);
        ImageAdapter adapter =
                new ImageAdapter(dataSet);
        grid.setAdapter(adapter);

    }

    private class ImageAdapter extends BaseAdapter{

        private ArrayList<Integer> dataSet;
        private LayoutInflater inflater;

        public ImageAdapter(ArrayList<Integer> dataSet) {
            this.dataSet = dataSet;

            inflater = getLayoutInflater();
        }

        @Override
        public int getCount() {
            return dataSet.size();
        }

        @Override
        public Object getItem(int position) {
            return dataSet.get(position);
        }

        @Override
        public long getItemId(int position) {
            return dataSet.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = null;
            if(convertView == null)
                view = inflater.inflate(R.layout.image_item,null,false);
            else view = convertView;

            ((ImageView)view.findViewById(R.id.imageView))
                    .setImageResource(dataSet.get(position));

            return view;
        }
    }
}
