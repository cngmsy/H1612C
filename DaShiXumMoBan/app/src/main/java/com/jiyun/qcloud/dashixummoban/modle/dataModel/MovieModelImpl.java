package com.jiyun.qcloud.dashixummoban.modle.dataModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.MovieBean;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MovieModelImpl implements IMovieModel {
    @Override
    public void loadmovielist(NetWorkCallBack<MovieBean> callback) {
        iHttp.get(Urls.MOVIES,null,callback);
    }
}
