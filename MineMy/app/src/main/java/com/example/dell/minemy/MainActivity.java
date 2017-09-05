package com.example.dell.minemy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//http://blog.csdn.net/zhaokaiqiang1992/article/details/38585547
public class MainActivity extends AppCompatActivity implements OnBannerListener {
    ExpandListView list1;
    ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
    private Banner banner;
    ArrayList<Integer> arraytu = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        list1 = (ExpandListView) findViewById(R.id.re);
        for (int i = 0; i < 5; i++) {
            arraytu.add(R.mipmap.v);
        }
        banner = (Banner) findViewById(R.id.roll);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(arraytu);
        //点击事件
        banner.setOnBannerListener(this);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        for (int i = 0; i <10; i++) {
            Map<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("name", "zhou");
            stringObjectHashMap.put("ima", R.mipmap.ic_launcher);
            arrayList.add(stringObjectHashMap);
        }
        Myadapter1 myadapter = new Myadapter1(MainActivity.this,arrayList);
        list1.setAdapter(myadapter);

    }
    @Override
    public void OnBannerClick(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
        }
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}

