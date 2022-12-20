package com.example.shayari.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayari.Adapters.BackgroundAdapter;
import com.example.shayari.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class shayariActivity extends AppCompatActivity  {
    int pos;
    String[] temp;
    TextView textView1,position;
    Button previous,next,edit,copy,share,expend,reload;
    BackgroundAdapter backgroundAdapter;
    GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari);

                textView1=findViewById(R.id.shayari);
                previous=findViewById(R.id.previous);
                next=findViewById(R.id.next);
                edit=findViewById(R.id.edit);
//                shayari=findViewById(R.id.shayari);
                copy=findViewById(R.id.cpoy);
                share=findViewById(R.id.share);
                expend=findViewById(R.id.expend);
                reload=findViewById(R.id.reload);
                position=findViewById(R.id.position);

                pos=getIntent().getIntExtra("pos",pos);
                temp=getIntent().getStringArrayExtra("temp");
                textView1.setText(temp[pos]);
                position.setText(pos+1+"/"+temp.length);


                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(pos<temp.length-1)
                        {
                            pos++;
                            textView1.setText(temp[pos]);
                            position.setText((pos+1)+"/"+temp.length);

                        }



                    }
                });

                previous.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(pos>0)
                        {
                            pos--;
                            textView1.setText(temp[pos]);
                            position.setText((pos+1)+"/"+temp.length);
                       }

                    }
                });

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(shayariActivity.this,EditeActivity.class);
                        intent.putExtra("temp",temp);
                        intent.putExtra("pos",pos);
                        startActivity(intent);
                    }
                });

                copy.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        ClipboardManager cm = (ClipboardManager)getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        cm.setText(textView1.getText().toString());
                        Toast.makeText(getApplicationContext(), "Copied :)", Toast.LENGTH_SHORT).show();
                    }
                });
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        /*This will be the actual content you wish you share.*/
                        String shareBody = ""+temp[pos];
                        /*The type of the content is text, obviously.*/
                        intent.setType("text/plain");
                        /*Applying information Subject and Body.*/
                        //intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
                        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        /*Fire!*/
                        startActivity(Intent.createChooser(intent, "text"));
                    }
                });

                expend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(shayariActivity.this);
                        view= LayoutInflater.from(shayariActivity.this).inflate(R.layout.background,null);

                        backgroundAdapter=new BackgroundAdapter(shayariActivity.this,Config.gradient,"gradient");
                        gridView=view.findViewById(R.id.griedview);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(backgroundAdapter);
                        bottomSheetDialog.setContentView(view);
                        bottomSheetDialog.show();
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                            {
                                textView1.setBackgroundResource(Config.gradient[i]);
                                bottomSheetDialog.dismiss();
                            }
                        });




                    }
                });
                reload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int min=0,max=Config.gradient.length;
                        int rand=  new Random().nextInt(max-min)+min;
                        textView1.setBackgroundResource(Config.gradient[rand]);
                    }
                });








            }


}