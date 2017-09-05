package com.jiyun.com.newviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.com.newviewpager.adapter.MyAdapter;
import com.jiyun.com.newviewpager.fragment.Five;
import com.jiyun.com.newviewpager.fragment.Four;
import com.jiyun.com.newviewpager.fragment.One;
import com.jiyun.com.newviewpager.fragment.Three;
import com.jiyun.com.newviewpager.fragment.Two;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mytab;

    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<Fragment> list = new ArrayList<>();
    private MyViewpager myviewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        strings.add("第一");
        strings.add("第二");
        strings.add("第三");
        strings.add("第四");
        strings.add("第五");

        list.add(new One());
        list.add(new Two());
        list.add(new Three());
        list.add(new Four());
        list.add(new Five());
//        myviewpager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return true;
//            }
//        });
        mytab.setTabMode(TabLayout.MODE_SCROLLABLE);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), strings, list);

        myviewpager.setAdapter(adapter);
        mytab.setupWithViewPager(myviewpager);

    }

    private void initView() {
        mytab = (TabLayout) findViewById(R.id.mytab);
        ;


        myviewpager = (MyViewpager) findViewById(R.id.myviewpager);
    }
}
