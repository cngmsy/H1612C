package com.jiyun.qcloud.dashixummoban.main;

import android.widget.ListView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.MyAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.MovieBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static com.jiyun.qcloud.dashixummoban.manager.ActivityCollector.getActivity;

/**
 * Created by chj on 2017/8/20.
 */

public class MainActivity extends BaseActivity implements MovieContract.View{

    @BindView(R.id.movielist)
    ListView movielistview;
    private MovieContract.Presenter presenter;
    private List<MovieBean.DataBean.TrailersBean> movielist = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void initData() {
        presenter=new MoviePresenter(this);
        if(presenter!=null) {
            presenter.start();
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void showMoviedata(MovieBean movieBean) {
        List<MovieBean.DataBean.TrailersBean> trailers = movieBean.getData().getTrailers();
        movielist.addAll(trailers);
        adapter = new MyAdapter(getActivity(), movielist);
        movielistview.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        this.presenter = presenter;
    }



}




