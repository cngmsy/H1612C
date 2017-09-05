package com.jiyun.qcloud.dashixummoban.ui.live.pandalive;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveBean;

import java.util.ArrayList;

/**
 *
 */
public class PandaLiveFragment extends BaseFragment implements LiveContract.LiveView {

    ImageView pandanliveVitamio;
    TextView pandanliveName;
    ImageView pandanliveDetail;
    private LiveContract.LivePresenter livePresenter;
    private int co = 1;
    private ArrayList<Fragment> list = new ArrayList<>();

    private String flv2;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_panda_live;
    }

    @Override
    protected void initData() {
        livePresenter = new LivePresenter(this);
        livePresenter.start();
    }

    @Override
    protected void initView(View view) {

        pandanliveVitamio = (ImageView) view.findViewById(R.id.pandanlive_vitamio);
        pandanliveName = (TextView) view.findViewById(R.id.pandanlive_name);
        pandanliveDetail = (ImageView) view.findViewById(R.id.pandanlive_detail);


    }

    @Override
    public void setBundle(Bundle bundle) {

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
    public void setPresenter(LiveContract.LivePresenter pandaLivePresenter) {
        livePresenter = pandaLivePresenter;
    }

    @Override
    public void setResultData(PandaLiveBean resultData) {
        Glide.with(getActivity())
                .load(resultData.getLive().get(0).getImage())
                .into(pandanliveVitamio);
    //    pandanliveContent.setText(resultData.getLive().get(0).getBrief());
    }
}
