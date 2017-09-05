package com.example.a82.myapplication.presenter;

import com.example.a82.myapplication.modle.MyModle;
import com.example.a82.myapplication.view.Loading;


/**
 * Created by 82年的笔记本 on 2017/8/31.
 */

public class MyPresenter {
    Loading loading;

    public MyPresenter(Loading loading) {
        this.loading = loading;
    }

    public void getData(String url) {
        MyModle myModel = new MyModle();
        myModel.postFile(url, new MyModle.LoadData() {
            @Override
            public void success(String s) {
                loading.success(s);
            }

            @Override
            public void fail(String ss) {
                loading.fail(ss);
            }
        });
    }
}
