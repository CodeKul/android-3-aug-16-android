package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FinalFragment extends Fragment {

    public static final String KEY_IMAGE = "image";

    public static FinalFragment getInstance(int image){

        FinalFragment fragment = new FinalFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_IMAGE,image);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_final, container, false);

        Bundle bundle = getArguments();
        int image = bundle.getInt(KEY_IMAGE);
        ((ImageView)rootView.findViewById(R.id.imageView))
                .setImageResource(image);

        return rootView;
    }
}
