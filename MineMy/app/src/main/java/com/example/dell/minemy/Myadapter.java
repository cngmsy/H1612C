package com.example.dell.minemy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by lenovo on 2017/8/31.
 */

public class Myadapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<Map<String, Object>> arrayList;
    private static final int ONE=1;
    private static final int TWO=2;

    public Myadapter(Context context, ArrayList<Map<String, Object>> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==5){
            return TWO;
        }else {
            return ONE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case ONE:
                View inflate = LayoutInflater.from(context).inflate(R.layout.ben, null);
                holder = new myviewHolder(inflate);
                break;
            case TWO:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.beng, null);
                holder = new RcyHh(inflate1);
                break;
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case ONE:
                myviewHolder holder1 = (myviewHolder) holder;
//                final ViewGroup.LayoutParams layoutParams = holder1.ima.getLayoutParams();
//                layoutParams.height=(int)(80+Math.random()*300);
                holder1.te.setText("zyy");
                holder1.ima.setImageResource(R.mipmap.v);
                break;
            case TWO:
                RcyHh holder2 = (RcyHh) holder;
                ArrayList<String> strings = new ArrayList<>();
                for (int i = 0; i <20; i++) {
                    strings.add("hh"+i);
                }
                ArrayAdapter pter=new ArrayAdapter(context,R.layout.ff,R.id.textView,strings);
                holder2.listView.setAdapter(pter);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class myviewHolder extends RecyclerView.ViewHolder {
        private TextView te;
        private ImageView ima;

        public myviewHolder(View itemView) {
            super(itemView);
            te = (TextView) itemView.findViewById(R.id.tex);
            ima = (ImageView) itemView.findViewById(R.id.ima);

        }
    }

    private class RcyHh extends RecyclerView.ViewHolder {
        private InnerListview listView;

        public RcyHh(View itemView) {
            super(itemView);
            listView = (InnerListview) itemView.findViewById(R.id.listyyy);

        }
    }
}