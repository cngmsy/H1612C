package com.example.a82.myapplication.modle;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 82年的笔记本 on 2017/8/31.
 */

public class MyModle {
    public void postFile(String url, final LoadData loadData) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        //图片路径
        String s = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/AAA.jpg";
        File file = new File(s);
        RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody multipartBody= new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("qqq",file.getName(),body).build();
        client.newCall(new Request.Builder().url(url).post(multipartBody).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loadData.fail(e.getMessage()+e.getLocalizedMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loadData.success(response.body().string());
            }
        });
    }

    public interface LoadData {
        void success(String s);
        void fail(String ss);
    }
}
