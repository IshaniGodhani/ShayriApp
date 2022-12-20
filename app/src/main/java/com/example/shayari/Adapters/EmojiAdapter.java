package com.example.shayari.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayari.Activities.Config;
import com.example.shayari.Activities.EditeActivity;
import com.example.shayari.R;

public class EmojiAdapter extends BaseAdapter {

    Context context;
    String[] emoji;
    TextView textView;
    String type;
    public EmojiAdapter(Context context, String[] emoji, String type) {
        this.emoji=emoji;
        this.context=context;
        this.type=type;


    }

    @Override
    public int getCount() {
        return emoji.length;
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
        view= LayoutInflater.from(context).inflate(R.layout.emoji_item,viewGroup,false);
        textView=view.findViewById(R.id.emoji_item);

        if(type=="emog")
        {
            textView.setText(Config.emoji[i]);
        }
        else
        {
            Typeface face = Typeface.createFromAsset(context.getAssets(), Config.font[i]);
            textView.setText("shayri");


            textView.setTypeface(face);
           // textView.setText(Config.font[i]);
        }

        return view;
    }
}
