package com.example.shayari.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayari.Activities.MainActivity;
import com.example.shayari.R;

public class ListAdapter extends BaseAdapter {

    int[] img_arr;
    String[] item;
    TextView textView1;
    ImageView img1;
    MainActivity mainActivity;
    public ListAdapter(MainActivity mainActivity, int[] img_arr, String[] item) {
        this.img_arr=img_arr;
        this.item=item;
        this.mainActivity=mainActivity;
    }
    @Override
    public int getCount() {
        return item.length ;
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
        view= LayoutInflater.from(mainActivity).inflate(R.layout.item_category,viewGroup,false);
        textView1=view.findViewById(R.id.item_text);
        img1=view.findViewById(R.id.item_img);

        textView1.setText(item[i]);
        img1.setImageResource(img_arr[i]);
        return view;
    }
}
