package com.example.dell.minemy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import static com.example.dell.minemy.R.id.ima;

/**
 * Created by lenovo on 2017/8/31.
 */
public class Myadapter1 extends BaseAdapter{
    Context context;
    ArrayList<Map<String, Object>> arrayList;

    public Myadapter1(Context context, ArrayList<Map<String, Object>> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder der=null;
        if(view==null){
            der=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.ben, null);
            der.te = (TextView) view.findViewById(R.id.tex);
            der.ima = (ImageView) view.findViewById(ima);
            view.setTag(der);
        }else {
            der= (ViewHolder) view.getTag();
        }
        der.te.setText("gg");
        der.ima.setImageResource(R.mipmap.v);
        return view;
    }
    class ViewHolder{
        TextView te;
        ImageView ima;

    }
}
