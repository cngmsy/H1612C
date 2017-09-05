package com.jiyun.qcloud.dashixummoban.ui.live.bigfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.BigLiveBean;
import com.jiyun.qcloud.dashixummoban.ui.live.pandalive.PandaLiveFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.splendid.SplendidFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chj on 2017/8/31.
 */

public class LivePageFragment extends BaseFragment implements LivePageContract.LivePageView{

    private TabLayout tablayout;
    private ViewPager vp;
    private LivePageContract.LivePagePresenter livePresenter;
    private PanadLiveFragmentAdapter panadLiveFragmentAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initData() {
        livePresenter=new LivePagePresenter(this);
        livePresenter.start();
    }

    @Override
    protected void initView(View view) {
        tablayout = view.findViewById(R.id.tablayout);
        vp = view.findViewById(R.id.vp);
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
    public void setPresenter(LivePageContract.LivePagePresenter livePagePresente) {
        livePresenter=livePagePresente;
    }

    @Override
    public void getResult(BigLiveBean bigLiveBean) {

        List<Fragment> contentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

       contentList.add(new PandaLiveFragment());

        for (int x = 0; x < bigLiveBean.getTablist().size(); x++) {

            titleList.add(bigLiveBean.getTablist().get(x).getTitle());
            if (x > 0) {
                //用Bundle传递各个Fragment的id
                Bundle bundle = new Bundle();
                bundle.putString("vsid", bigLiveBean.getTablist().get(x).getId());
                SplendidFragment splendidFragment = new SplendidFragment();
                splendidFragment.setArguments(bundle);
                contentList.add(splendidFragment);
            }
        }

        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        panadLiveFragmentAdapter = new PanadLiveFragmentAdapter(getActivity().getSupportFragmentManager(), contentList, titleList);
        vp.setAdapter(panadLiveFragmentAdapter);
        tablayout.setupWithViewPager(vp);
    }
}
