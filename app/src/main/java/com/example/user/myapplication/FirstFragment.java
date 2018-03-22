package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 2018-03-09.
 */

@SuppressLint("ValidFragment")
public class FirstFragment extends ListFragment {


    ArrayList<list_item> list_itemArrayList;
    private ListView listView;

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private TextView name, subname;

    String temp = "https://cdn-images-1.medium.com/fit/c/36/36/0*HgJ2Psmia7PjQsp9.jpg";

    public FirstFragment(int Page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, Page);
        //PageFragment fragment1 = new PageFragment(page ,name_Str, location_Str, state, PhoneNum);
        this.setArguments(args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = null;

        list_itemArrayList = new ArrayList<list_item>();

        list_itemArrayList.add(new list_item("https://cdn-images-1.medium.com/fit/c/36/36/0*HgJ2Psmia7PjQsp9.jpg", "보라돌이", "제목1", new Date(System.currentTimeMillis()), "내용1"));
        list_itemArrayList.add(new list_item("https://cdn-images-1.medium.com/fit/c/36/36/0*HgJ2Psmia7PjQsp9.jpg", "뚜비", "제목2", new Date(System.currentTimeMillis()), "내용2"));
        list_itemArrayList.add(new list_item("https://cdn-images-1.medium.com/fit/c/36/36/0*HgJ2Psmia7PjQsp9.jpg", "나나", "제목3", new Date(System.currentTimeMillis()), "내용3"));
        list_itemArrayList.add(new list_item("https://cdn-images-1.medium.com/fit/c/36/36/0*HgJ2Psmia7PjQsp9.jpg", "뽀", "제목4", new Date(System.currentTimeMillis()), "내용4"));
        list_itemArrayList.add(new list_item("https://cdn-images-1.medium.com/fit/c/36/36/0*HgJ2Psmia7PjQsp9.jpg", "햇님", "제목5", new Date(System.currentTimeMillis()), "내용5"));

        if (mPage == 0) {
            view = inflater.inflate(R.layout.fragment_one, container, false);//fragment_page
            createListView(view);

            //setonclicklistner를 할지 아이템 클릭리스너를 할지
        }
        return view;
    }

    public void createListView(View v) {
        listView = v.findViewById(R.id.list_one);

        final ArrayList<list_item> items = new ArrayList<>();

        //        listView.addHeaderView(header);
        //adapter = ;//MyListAdapter(Context context, ArrayList<list_item> list_itemArrayList)
        listView.setAdapter(new MyListAdapter(getActivity(),items));

        //onItemClickListener를 추가
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentDialog dialog = new FragmentDialog();
                dialog.show(fragmentManager, "dialog");

            }
        });
    }
/*
    protected void switchFragment(String id) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (id.equals("Puppy")) {
            fragmentTransaction.replace(R.id.fragment_puppy, catFragment);
            fragmentTransaction.addToBackStack(null);
        } else if (id.equals("Cat")) {
            fragmentTransaction.replace(R.id.fragment_cat, puppyFragment);
            fragmentTransaction.addToBackStack(null);
        } else {
            fragmentTransaction.replace(R.id.fragment_tiger, tigerFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
*/
    private class MyListAdapter extends BaseAdapter {//수정 시급
        Context context;
        private ArrayList<list_item> list_itemArrayList;
        CustomViewHolder viewholder;
        private FragmentActivity activity;
        private LayoutInflater inflater;

        public MyListAdapter(Context context, ArrayList<list_item> list_itemArrayList) {
            this.context = context;
            this.list_itemArrayList = list_itemArrayList;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return this.list_itemArrayList.size();
        }

        @Override
        public list_item getItem(int position) {
            return list_itemArrayList.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            final int allposition = position;

            LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            if (convertView == null) {
                convertView = vi.inflate(R.layout.listview_item, null);

                viewholder = new CustomViewHolder();
                viewholder.nickname_textView = (TextView) convertView.findViewById(R.id.nickname_textview);
                viewholder.title_textView = (TextView) convertView.findViewById(R.id.content_texview);
                viewholder.date_textView = (TextView) convertView.findViewById(R.id.date_textview);
                viewholder.title_textView = (TextView) convertView.findViewById(R.id.title_textview);
                viewholder.profile_imageView = (ImageView) convertView.findViewById(R.id.profile_imageView);

            } else {
                viewholder = (CustomViewHolder) convertView.getTag();
            }
            viewholder.nickname_textView.setText(list_itemArrayList.get(position).getNickname());
            viewholder.title_textView.setText(list_itemArrayList.get(position).getTitle());
            viewholder.content_textView.setText(list_itemArrayList.get(position).getContent());
            viewholder.date_textView.setText(list_itemArrayList.get(position).getWrite_date().toString());
            Glide.with(context).load(list_itemArrayList.get(position).getProfile_image()).into(viewholder.profile_imageView);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //  Toast.makeText(getActivity()), list_itemArrayList.get(allposition), Toast.LENGTH_SHORT).show();
                    //// TODO: 2017-01-02 여기서 데이터 받고 뿌려주자 그래야 익셉션이안뜸
                }
            });
            return convertView;
        }

        public class CustomViewHolder {
            TextView nickname_textView;
            TextView title_textView;
            TextView date_textView;
            TextView content_textView;
            ImageView profile_imageView;
        }
    }

    public class list_item {

        public list_item(String profile_image, String nickname, String title, Date write_date, String content) {
            this.profile_image = profile_image;
            this.nickname = nickname;
            this.title = title;
            this.write_date = write_date;
            this.content = content;
        }

        private String profile_image;
        private String nickname;
        private String title;
        private Date write_date;
        private String content;


        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Date getWrite_date() {
            return write_date;
        }

        public void setWrite_date(Date write_date) {
            this.write_date = write_date;
        }
    }
}

