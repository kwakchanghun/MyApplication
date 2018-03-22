package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2018-03-09.
 */

@SuppressLint("ValidFragment")
public class SecondFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public SecondFragment(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //PageFragment fragment1 = new PageFragment(page ,name_Str, location_Str, state, PhoneNum);
        this.setArguments(args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        if (mPage == 1) {
            view = inflater.inflate(R.layout.fragment_two, container, false);//fragment_page
        }

        return view;
    }

}
