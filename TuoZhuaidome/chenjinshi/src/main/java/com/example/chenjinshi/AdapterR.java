package com.example.chenjinshi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KING on 2017/8/31 14:40
 * 邮箱:992767879@qq.com
 */

public class AdapterR extends RecyclerView.Adapter {
    private Context  context;
    private List<String> list;

    public AdapterR(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itme_buju, null);
        return new Nebulei(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Nebulei holder1 = (Nebulei) holder;
        holder1.aaa.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class Nebulei extends RecyclerView.ViewHolder {

        private final TextView aaa;

        public Nebulei(View itemView) {
            super(itemView);
            aaa = itemView.findViewById(R.id.aaaa);
        }
    }
}
