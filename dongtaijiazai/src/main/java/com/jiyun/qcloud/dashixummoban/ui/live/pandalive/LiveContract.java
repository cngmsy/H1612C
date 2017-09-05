package com.jiyun.qcloud.dashixummoban.ui.live.pandalive;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveBean;


public interface LiveContract {
    interface LiveView extends IBaseView<LivePresenter> {
        void setResultData(PandaLiveBean resultData);
    }

    interface LivePresenter extends IBasePresenter {

    }
}
