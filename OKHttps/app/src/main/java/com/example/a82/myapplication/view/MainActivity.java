package com.example.a82.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.a82.myapplication.R;
import com.example.a82.myapplication.presenter.MyPresenter;

public class MainActivity extends AppCompatActivity implements Loading{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyPresenter myPresenter=new MyPresenter(this);
        myPresenter.getData("http://123.206.14.104:8080/FileUploadDemo/FileUploadServlet");
    }
    @Override
    public void success(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("MainActivity", s);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void fail(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("MainActivity", s);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
