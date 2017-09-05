package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.entity.BigLiveBean;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.entity.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public interface IPandaHomeModel extends BaseModel {

    void loadHomeList(NetWorkCallBack<PandaHome> callback);

    void getPandaLiveData(NetWorkCallBack<BigLiveBean> callBack);

    void getSplendData(Map<String,String> map, NetWorkCallBack<SplendBean> callBack);

    void getPandaLive(NetWorkCallBack<PandaLiveBean> callBack);
}
