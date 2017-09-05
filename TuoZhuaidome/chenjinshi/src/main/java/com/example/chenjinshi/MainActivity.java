package com.example.chenjinshi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<String>();
    private RecyclerView review;
    private TextView name;
    private AdapterR adapterR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        for (int i = 0; i <100 ; i++) {
            list.add("8888888888發財了");
        }
        review = (RecyclerView) findViewById(R.id.review);
        name = (TextView) findViewById(R.id.name);
        adapterR = new AdapterR(this, list);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        review.setLayoutManager(llm);
        review.setAdapter(adapterR);
        //滑动监听
        review.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //这是获取reeview的长度
                int measuredHeight = review.getMeasuredHeight();
                float i = dy / measuredHeight;
                int i1 = (int)(i * 255);
                name.setAlpha(i1);
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
