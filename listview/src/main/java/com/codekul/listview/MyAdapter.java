package com.codekul.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by aniruddha on 9/8/16.
 */
public class MyAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<MyItem> dataSet;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<MyItem> dataSet) {
        this.context = context;
        this.dataSet = dataSet;

        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        return dataSet.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.my_item,null,false);

        ImageView image = (ImageView) view.findViewById(R.id.imageItem);
        image.setImageResource(dataSet.get(position).getImageId());

        TextView text = (TextView) view.findViewById(R.id.textItem);
        text.setText(dataSet.get(position).getName());

        return view;
    }
}
