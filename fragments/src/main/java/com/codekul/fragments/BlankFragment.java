package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_blank,
                container, false);

        rootView.findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName= ((EditText)rootView.findViewById(R.id.edtUserName)).getText().toString();
                String password = ((EditText)rootView.findViewById(R.id.edtPassword)).getText().toString();

                if(userName.equalsIgnoreCase("android") && password.equalsIgnoreCase("android"))
                    getParent().runFragmentTransaction(R.id.frameContainer, FinalFragment.getInstance(R.drawable.my));
                else getParent().runFragmentTransaction(R.id.frameContainer, FinalFragment.getInstance(R.mipmap.ic_launcher));
            }
        });

        return rootView;
    }

    private MainActivity getParent(){
        return  (MainActivity) getActivity();
    }
}
