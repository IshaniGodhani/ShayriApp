package com.example.shayari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayari.Activities.Config;
import com.example.shayari.Activities.EditeActivity;
import com.example.shayari.R;

public class FontcolorAdapter extends BaseAdapter {
    Context context;
    int[] colors;
    TextView textView;
    public FontcolorAdapter(Context context, int[] colors) {
        this.context=context;
        this.colors=colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.background_item,viewGroup,false);
        textView=view.findViewById(R.id.bg_item);

        textView.setTextColor(view.getResources().getColor(Config.colors[i]));


        return view;
    }
}
