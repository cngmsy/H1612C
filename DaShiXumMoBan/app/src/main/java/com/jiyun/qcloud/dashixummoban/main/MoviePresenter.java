package com.jiyun.qcloud.dashixummoban.main;


import com.jiyun.qcloud.dashixummoban.entity.MovieBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IMovieModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.MovieModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/22.
 */

public class  MoviePresenter implements MovieContract.Presenter {

    private MovieContract.View movieview;
    private IMovieModel moviemodel;

    public MoviePresenter(MovieContract.View movieview){
        this.movieview = movieview;
        movieview.setPresenter(this);
        this.moviemodel = new MovieModelImpl();
    }
    @Override
    public void start() {
        movieview.showProgress();
        moviemodel.loadmovielist(new NetWorkCallBack<MovieBean>() {
            @Override
            public void onSuccess(MovieBean movieBean) {
                movieview.showMoviedata(movieBean);
                movieview.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
               movieview.showMessage(errorMsg);
                movieview.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

}
