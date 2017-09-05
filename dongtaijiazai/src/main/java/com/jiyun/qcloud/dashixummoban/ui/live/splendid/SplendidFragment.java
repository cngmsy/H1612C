package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.SplendBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by my301s on 2017/8/31.
 */


public class SplendidFragment extends BaseFragment implements SplendidContract.SplendidView {
    private SplendidContract.SplendidPresenter splendidPresenter;
    private XRecyclerView xRecyclerView;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    private int Index = 1;
    Map<String, String> map = new HashMap<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:
                    beanList.clear();
                    splendAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                    Index = 1;
                    initData();
                    break;
                case 3:
                    xRecyclerView.loadMoreComplete();
                    Index++;
                    initData();
                    break;
            }
        }
    };
    private SplendAdapter splendAdapter;
    private String vsid;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splendid;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("onCreate", "onCreate");
    }

    @Override
    protected void initData() {
        //接收id
        Bundle bundle = getArguments();
        vsid = bundle.getString("vsid");

       /* splendidPresenter = new SplendidPresenter(this);
        map.put("vsid", vsid);
        map.put("n", "7");
        map.put("serviceId", "panda");
        map.put("o", "desc");
        map.put("of", "time");
        map.put("p", Index + "");
        splendidPresenter.mapData(map);*/
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = view.findViewById(R.id.splendid_xrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(2, 1000);
            }

            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(3, 2000);
            }
        });
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
    public void setPresenter(SplendidContract.SplendidPresenter splendidPresenter) {
        this.splendidPresenter = splendidPresenter;
    }

    @Override
    public void setResultData(SplendBean resultData) {
        beanList.addAll(resultData.getVideo());
        splendAdapter = new SplendAdapter(getContext(), beanList);
        xRecyclerView.setAdapter(splendAdapter);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("onHiddenChanged", "onHiddenChanged");
    }

    //懒加载fragment
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("setUserVisibleHint", "setUserVisibleHint");
        if (isVisibleToUser == true) {
            splendidPresenter = new SplendidPresenter(this);
            map.put("vsid", vsid);
            map.put("n", "7");
            map.put("serviceId", "panda");
            map.put("o", "desc");
            map.put("of", "time");
            map.put("p", Index + "");
            splendidPresenter.mapData(map);
        }
    }
//    当我们在使用viewpager的时候，viewpager内部有个提前缓存的机制(默认是提前缓存一页)，
//    比如你在看第一个Fragment的时候，隔壁的Fragment已经创建好了，但此时的状态却是不可见的。
//    但是这时候Fragment不会去调用上面说的onhiddenchanged方法，只会调用setUserVisibleHint这个方法。
}
