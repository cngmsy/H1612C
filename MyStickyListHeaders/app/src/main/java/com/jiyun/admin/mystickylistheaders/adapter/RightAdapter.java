package com.jiyun.admin.mystickylistheaders.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jiyun.admin.mystickylistheaders.entity.Data;
import com.jiyun.admin.mystickylistheaders.entity.Head;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by admin on 2017/8/16.
 */

public class RightAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    //传入两个集合，对左右两个ListView进行关联
    private Context context;
    private List<Data> dataList;
    private List<Head> headList;

    public RightAdapter(Context context, List<Data> dataList,List<Head> headList) {
        this.context = context;
        this.dataList = dataList;
        this.headList = headList;
    }

    //分组
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        Data data = dataList.get(position);
        //把头(右侧标签)所在的下标与左侧相互关联
        Head head = headList.get(data.getHeadIndex());

        TextView tv = new TextView(context);
        tv.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        //为右侧头添加左侧相对应的标签内容
        tv.setText(head.getInfo());
        tv.setBackgroundColor(Color.GRAY);
        return tv;
    }

    @Override
    public long getHeaderId(int position) {
        //position是普通条目的 里面有HeadId
        //同一个头下的普通条目的headId是相同的
        int headId = dataList.get(position).getHeadId();
        return headId;
    }
    //普通条目的数量
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //普通条目赋值
        TextView tv = new TextView(context);
        tv.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        tv.setText(dataList.get(position).getInfo());
        tv.setTextColor(Color.GRAY);
        return tv;
    }
}
