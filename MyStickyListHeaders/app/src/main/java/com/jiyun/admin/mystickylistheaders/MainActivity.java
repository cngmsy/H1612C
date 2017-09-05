package com.jiyun.admin.mystickylistheaders;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.admin.mystickylistheaders.adapter.LiftAdapter;
import com.jiyun.admin.mystickylistheaders.adapter.RightAdapter;
import com.jiyun.admin.mystickylistheaders.entity.Data;
import com.jiyun.admin.mystickylistheaders.entity.Head;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    //左边的ListView
    @BindView(R.id.myLv)
    ListView myLv;
    //右边的粘性标题列表
    @BindView(R.id.myshl)
    StickyListHeadersListView myshl;
    //普通条目的数据
    List<Head> headList = new ArrayList<>();
    //粘性标题的数据
    List<Data> dataList = new ArrayList<>();
    private LiftAdapter liftAdapter;
    private RightAdapter rightAdapter;
    private boolean isScroll = false;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        testData();
        setAdapter();
        handler.obtainMessage();
    }

    private void setAdapter() {
        liftAdapter = new LiftAdapter(this, headList);
        myLv.setAdapter(liftAdapter);

        rightAdapter = new RightAdapter(this, dataList, headList);
        myshl.setAdapter(rightAdapter);

        //左边ListView的点击监听
        myLv.setOnItemClickListener(this);
        //右边StickyListHeadersListView的滚动监听
        myshl.setOnScrollListener(this);
    }

    private void testData() {
        //左侧数据
        for (int i = 0; i < 10; i++) {
            Head head = new Head();
            head.setInfo("头(左侧)数据" + i);
            headList.add(head);
        }
        //右侧数据
        //添加右侧数据的方式类似于ExpandableListView，左侧的可以看作是Group，右侧可以看作是Child
        for (int j = 0; j < headList.size(); j++) {
            Head head = headList.get(j);
            for (int o = 0; o < 10; o++) {
                Data data = new Data();
                data.setHeadId(j);
                data.setHeadIndex(j);
                data.setInfo("普通条目数据:第" + j + "组,条目数:" + o);
                /**
                 * 外层每循环一次，内层开始循环到第一条的时候，为右边的头标签设置一个下标值
                 * 防止其重复，吧右侧普通条目的集合长度作为下标值
                 * 如 第一次循环集合长度为0，右侧第一个下标值=0
                 * 第二次循环集合长度为10，右侧第二个下标值 = 10
                 * 一次类推
                 * 这样左侧就可以通过右侧头标签的下标值进行联动操作
                 */
                if (o == 0) {
                    //对应的组元素中第一条数据的下标
                    head.setGroupFirstIndex(dataList.size());
                }
                dataList.add(data);
            }
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //右边在滚动
        isScroll = true;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //左边点击  导致右边滚动 只触发这个方法
        if (isScroll) {
            Data data = dataList.get(firstVisibleItem);
            //当前正在置顶显示的头
            //左侧通过右侧同组的下标设置选择哪一个item显示
            liftAdapter.setSelectedPosition(data.getHeadIndex());

            //滚动左边时  右边的显示问题
            int firstVisiblePosition = myLv.getFirstVisiblePosition();
            int lastVisiblePosition = myLv.getLastVisiblePosition();
            if (data.getHeadIndex() <= firstVisiblePosition || data.getHeadIndex() >= lastVisiblePosition) {
                myLv.setSelection(data.getHeadIndex());
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //左边条目被点击了
        liftAdapter.setSelectedPosition(position);
        //通过添加数据时右侧添加的
        Head head = headList.get(position);
        myshl.setSelection(head.getGroupFirstIndex());
        isScroll = false;
    }
}
