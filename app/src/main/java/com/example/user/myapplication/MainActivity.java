package com.example.user.myapplication;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TabLayout sliding_tab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        sliding_tab = findViewById(R.id.tab_layout);


        pager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2); // 안보이는 페이지 로딩해 놓을 갯수

        sliding_tab.addTab(sliding_tab.newTab().setText("쿠폰"), 0, true); // 페이지 등록

        sliding_tab.addTab(sliding_tab.newTab().setText("업체"), 1);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(sliding_tab));


        sliding_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
                // 슬라이딩이 아니라 위에 페이지를 선택했을 때도 페이지 이동 가능하게.

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}
