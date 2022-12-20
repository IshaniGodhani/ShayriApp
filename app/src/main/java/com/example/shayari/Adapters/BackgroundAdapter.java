package com.example.shayari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayari.Activities.Config;
import com.example.shayari.R;

public class BackgroundAdapter extends BaseAdapter {

    Context context;
    int[] bg;
    int [] colors;
    TextView textView;
    String type;

    public BackgroundAdapter(Context context, int[] gradient, String type)
    {

        this.context=context;
        this.bg=gradient;
        this.colors=colors;
        this.type=type;

    }



    @Override
    public int getCount() {
        return bg.length;
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

        if (type=="gradient")
        {
            textView.setBackgroundResource(bg[i]);
        }

        if (type=="color")
        {
            textView.setBackgroundColor(view.getResources().getColor(Config.colors[i]));
        }





        return view;
    }
}
