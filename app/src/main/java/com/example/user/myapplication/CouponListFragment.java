package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2018-03-09.
 */

@SuppressLint("ValidFragment")
public class CouponListFragment extends ListFragment implements View.OnClickListener {
    CouponListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Adapter 생성 및 Adapter 지정.
        adapter = new CouponListViewAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem("Vero");
        // 두 번째 아이템 추가.
        adapter.addItem("그녀의 커피잔");
        // 세 번째 아이템 추가.
        adapter.addItem( "커피사진관");

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.list_one:
                // 데이터를 다이얼로그로 보내는 코드
                Bundle args = new Bundle();
                args.putString("key", "value");
                //---------------------------------------.//
                FragmentDialog dialog = new FragmentDialog();
                dialog.setArguments(args); // 데이터 전달
                dialog.show(getActivity().getSupportFragmentManager(), "tag");
                break;
        }
    }
}
