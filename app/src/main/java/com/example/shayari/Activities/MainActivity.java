package com.example.shayari.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shayari.Adapters.ShayriAdapter;
import com.example.shayari.R;

public class MainActivity extends AppCompatActivity {

    int[] img_arr={R.drawable.love,R.drawable.motivational,R.drawable.sad,
            R.drawable.smily,R.drawable.bewfa,R.drawable.child,
            R.drawable.married,R.drawable.god,R.drawable.politics,
            R.drawable.boyfriendgirl,R.drawable.bestwishesh};
    int img;
    ShayriAdapter shayriAdapter;

    String[] item={"love shayari","motivational shayari","sad shayari",
                    "smiley shayari","bewafa shayari","child shayari","married shayari",
                    "god shayari","politics shayari","boyfriendhgirl shayari","bestwishes shayari"};

   ;

    ListView listView;
    int pos;
    ListAdapter ListAdapter ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAdapter= new com.example.shayari.Adapters.ListAdapter(this, img_arr, item);

        listView=findViewById( R.id.list);
        listView.setAdapter(ListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, ShayriListActivity.class);
                intent.putExtra("pos",i);
                intent.putExtra("itemarr",item);
                intent.putExtra("imgarr",img_arr);
                startActivity(intent);
                System.out.println(""+item[i]);
            }
        });



    
    }
}