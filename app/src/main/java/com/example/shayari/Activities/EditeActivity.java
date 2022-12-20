package com.example.shayari.Activities;

import static com.example.shayari.Activities.Config.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayari.Adapters.BackgroundAdapter;
import com.example.shayari.Adapters.EmojiAdapter;
import com.example.shayari.Adapters.FontcolorAdapter;
import com.example.shayari.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class EditeActivity extends AppCompatActivity
{
    int pos;
    String[] temp;
    TextView textView,emoji_item;
    Button bg,tc,share,emoji,font,ts,expend,reload,cancel;
    BackgroundAdapter backgroundAdapter;
    GridView gridView;
    ListView listView;
    SeekBar seekBar;
    FontcolorAdapter fontcolorAdapter;
    EmojiAdapter emojiAdapter;
    File f;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editactivity);


                textView=findViewById(R.id.shayari1);
                bg=findViewById(R.id.bg);
                tc=findViewById(R.id.tc);
                share=findViewById(R.id.share);
                emoji=findViewById(R.id.emoji);
                font=findViewById(R.id.font);
                ts=findViewById(R.id.ts);
                expend=findViewById(R.id.exp);
                emoji_item=findViewById(R.id.emoji_item);
                seekBar=findViewById(R.id.seekbar);
                reload=findViewById(R.id.rel);




                pos=getIntent().getIntExtra("pos",pos);
                temp=getIntent().getStringArrayExtra("temp");

                textView.setText(temp[pos]);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Bitmap icon = getBitmapFromView(textView);
                //Intent share = new Intent(Intent.ACTION_SEND);
                Intent share =new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                int num=new Random().nextInt(2000);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());

                f= new File(Config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
                try
                {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                    Toast.makeText(EditeActivity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share Image"));
            }

        });

                bg.setOnClickListener(new View.OnClickListener()
                {


                    @Override
                    public void onClick(View view)
                    {
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(EditeActivity.this);
                        view= LayoutInflater.from(EditeActivity.this).inflate(R.layout.background,null);


                        backgroundAdapter=new BackgroundAdapter(EditeActivity.this,Config.colors,"color");
                        gridView=view.findViewById(R.id.griedview);
                        gridView.setNumColumns(5);
                        gridView.setAdapter(backgroundAdapter);
                        bottomSheetDialog.setContentView(view);
                        bottomSheetDialog.show();
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                            {
                                textView.setBackgroundColor(view.getResources().getColor(Config.colors[i]));
                                bottomSheetDialog.dismiss();
                            }

                        });

                    }
                });

                tc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(EditeActivity.this);
                        view= LayoutInflater.from(EditeActivity.this).inflate(R.layout.background,null);

                        fontcolorAdapter=new FontcolorAdapter(EditeActivity.this,Config.colors);
                        gridView=view.findViewById(R.id.griedview);
                        gridView.setNumColumns(5);
                        gridView.setAdapter(fontcolorAdapter);
                        bottomSheetDialog.setContentView(view);
                        bottomSheetDialog.show();
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                textView.setTextColor(view.getResources().getColor(Config.colors[i]));
                                bottomSheetDialog.dismiss();
                            }
                        });
                    }
                });

                emoji.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(EditeActivity.this);
                        view= LayoutInflater.from(EditeActivity.this).inflate(R.layout.emoji_list,null);

                        emojiAdapter=new EmojiAdapter(EditeActivity.this,Config.emoji,"emog");
                        listView=view.findViewById(R.id.emoji_list);
                        listView.setAdapter(emojiAdapter);
                        bottomSheetDialog.setContentView(view);
                        bottomSheetDialog.show();
                        Button cancel=view.findViewById(R.id.cancel_button);
                        cancel.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view) {
                                bottomSheetDialog.dismiss();
                                System.out.println("Cancel Clicked");
                            }

                        });

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                textView.setText(Config.emoji[i]+"\n"+temp[pos]+"\n"+Config.emoji[i]);
//                                bottomSheetDialog.dismiss();

                            }
                        });
                    }
                });

        expend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(EditeActivity.this);
                view = LayoutInflater.from(EditeActivity.this).inflate(R.layout.background, null);

                backgroundAdapter = new BackgroundAdapter(EditeActivity.this, Config.gradient, "gradient");
                gridView = view.findViewById(R.id.griedview);
                gridView.setNumColumns(2);
                gridView.setAdapter(backgroundAdapter);
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Config.gradient[i]);
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
               textView.setBackgroundResource(Config.gradient[rand]);
           }
       });
        font.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(EditeActivity.this);
                view = LayoutInflater.from(EditeActivity.this).inflate(R.layout.emoji_list, null);

                emojiAdapter = new EmojiAdapter(EditeActivity.this, Config.emoji, "font");
                listView = view.findViewById(R.id.emoji_list);
                listView.setAdapter(emojiAdapter);
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
                Button cancel=view.findViewById(R.id.cancel_button);
                cancel.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                        System.out.println("Cancel Clicked");
                    }

                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Typeface face = Typeface.createFromAsset(getAssets(), Config.font[i]);
                        textView.setTypeface(face);


                    }
                });
            }
        });
        ts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(EditeActivity.this);
                view= LayoutInflater.from(EditeActivity.this).inflate(R.layout.layout_seekbar,null);


                seekBar=view.findViewById(R.id.seekbar);
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        textView.setTextSize(1,10+i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }


                });
            }
        });

    }
    private Bitmap getBitmapFromView(View view1)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view1.getWidth(), view1.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view1.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view1.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}
