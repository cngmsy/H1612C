package com.example.dell.minemy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recy;
    ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        for (int i = 0; i <11; i++) {
            Map<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("name", "zhou");
            stringObjectHashMap.put("ima", R.mipmap.ic_launcher);
            arrayList.add(stringObjectHashMap);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main2Activity.this);
        recy.setLayoutManager(linearLayoutManager);
        Myadapter myadapter = new Myadapter(Main2Activity.this,arrayList);
        recy.setAdapter(myadapter);
    }
}
