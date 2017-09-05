package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.BigLiveBean;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.entity.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.net.HttpFactory;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public class PandaHomeModelImpl implements IPandaHomeModel {


    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME,null,callback);
    }
    //tablayout
    @Override
    public void getPandaLiveData(NetWorkCallBack<BigLiveBean> callBack) {
        iHttp.get(Urls.BIGPAGE,null,callBack);
    }
    //精彩一刻
    @Override
    public void getSplendData(Map<String, String> map, NetWorkCallBack<SplendBean> callBack) {
        HttpFactory.createOK().get(Urls.SPLENDURL,map,callBack);
    }
    //熊猫直播正在直播
    @Override
    public void getPandaLive(NetWorkCallBack<PandaLiveBean> callBack) {
        iHttp.get(Urls.PANDALIVE,null,callBack);
    }
}
