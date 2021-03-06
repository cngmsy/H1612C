package com.jiyun.qcloud.dashixummoban.ui.live.pandalive;

import android.util.Log;

import com.jiyun.qcloud.dashixummoban.entity.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

public class LivePresenter implements LiveContract.LivePresenter {
    private LiveContract.LiveView liveView;
    private PandaHomeModelImpl modelImp;

    public LivePresenter(LiveContract.LiveView liveView) {
        this.liveView = liveView;
        modelImp = new PandaHomeModelImpl();
        liveView.setPresenter(this);
    }


    @Override
    public void start() {
        modelImp.getPandaLive(new NetWorkCallBack<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {
                liveView.setResultData(pandaLiveBean);
                Log.d("LivePresenter", liveView.toString());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
