package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.MovieBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<MovieBean.DataBean.TrailersBean>  datalist;

    public MyAdapter(Context context, List<MovieBean.DataBean.TrailersBean> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder  holder=null;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            holder.videoPlayer = view.findViewById(R.id.list_player);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.itemview = view;

        MovieBean.DataBean.TrailersBean trailersBean = datalist.get(i);

        //设置视频地址、缩略图地址、标题
        holder.videoPlayer.setUp(trailersBean.getHightUrl(),trailersBean.getVideoTitle());
        Glide.with(context).load(trailersBean.getCoverImg()).into(holder.videoPlayer.ivThumb);
        //
        holder.videoPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);

        return view;
    }

    class ViewHolder{
        View itemview;
        JCVideoPlayer videoPlayer;

    }
}
