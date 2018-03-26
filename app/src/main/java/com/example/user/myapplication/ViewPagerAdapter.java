package com.example.user.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by user on 2018-03-09.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {//nodejs
    private static final int PAGE_COUNT = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("position", String.valueOf(position));

        if (position == 0) {
            return new CouponListFragment();
        } else {
            return new StoreListFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


    //텍스트 쓸때
    @Override
    public CharSequence getPageTitle(int position) {
        return "탭 " + position; // 페이지(position)에 따른 tab 의 타이틀 지정
    }
}

//이미지 쓸때
//    @Override
//    public int getPageIconResId(int position) {
//        return 0;
//    }



