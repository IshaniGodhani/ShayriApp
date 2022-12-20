package com.example.shayari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayari.Activities.ShayriListActivity;
import com.example.shayari.R;

public class ShayriAdapter extends BaseAdapter
{
    String[] temp;
    int img;
    TextView textView;
    ImageView imageView;
    Context context;
    public ShayriAdapter(Context context, String[] temp, int img)
    {
        this.context=context;
        this.img=img;
        this.temp=temp;

//        for(int i=0;i< temp.length;i++)
//        {
//            System.out.println(""+temp[i]);
//        }

    }

    @Override
    public int getCount() {
        return temp.length;
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
        view= LayoutInflater.from(context).inflate(R.layout.fullscreen_list,viewGroup,false);
        textView=view.findViewById(R.id.list_text);
        imageView=view.findViewById(R.id.list_img);
        //imageView1=view.findViewById(R.id.list_img2);

        textView.setText(temp[i]);
        imageView.setImageResource(img);




        return view;
    }
}
