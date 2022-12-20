package com.example.shayari.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shayari.Adapters.ShayriAdapter;
import com.example.shayari.R;

public class ShayriListActivity extends AppCompatActivity {

    String[] love_shayari={"उनकी चाल ही काफी थी इस दिल के धड़कन बढ़ाने के लिए,\n" +
            "अब तो हद हो गई जब से वो पाँव में पायल पहनने लगे l","मेरे दिल ने जब भी दुआ माँगी है, तुझे माँगा है तेरी वफ़ा माँगी है,\n"+
            "जिस मोहब्बत को देख के दुनिया को रश्क आये, तेरे प्यार करने की वो अदा माँगी है।",
            "खुश रहना तो हमने भी सीख लिया था उनके बगैर,\n" +
                    "मुद्द्त बाद उन्होंने हाल पूछ के फिर बेहाल कर दिया..!",
            "Itna Pyaar Hogaya Hai Tumhse Ki Ab Jha Bhi\n" +
                    "Pyaar Ki Baat Hoti Hai Mujhe Tum Yaad Aate Ho",
            "लिखना था कि खुश हैं तेरे बगैर भी यहां हम, मगर कमबख्त… आंसू हैं कि कलम से पहले ही चल दिए।"};

    String [] motivational_shayari={"dil nā-umīd to nahīñ nākām hī to hai \n" +
            "\n" +
            "lambī hai ġham kī shaam magar shaam hī to hai ",
            "ḳhudī ko kar buland itnā ki har taqdīr se pahle \n" +
                    "\n" +
                    "ḳhudā bande se ḳhud pūchhe batā terī razā kyā hai ",
            "sitāroñ se aage jahāñ aur bhī haiñ \n" +
                    "\n" +
                    "abhī ishq ke imtihāñ aur bhī haiñ",
            "maiñ akelā hī chalā thā jānib-e-manzil magar \n" +
                    "\n" +
                    "log saath aate ga.e aur kārvāñ bantā gayā ",
            "ham ko miTā sake ye zamāne meñ dam nahīñ \n" +
                    "\n" +
                    "ham se zamāna ḳhud hai zamāne se ham nahīñ ",};

    String[] sad_shayari={"जाते वक़्त आखिरी बार मुड़के देखा जरूर था उन्होंने हमें\n" +
            "पता नही क्या कहना चाह रही थी वो बेबस सी दो आँखे उनकी ",
            "सबको देखकर यू मुस्कुराना तो अदा थी उनकी\n" +
                    "हम खामखा खुद को खुशनसीब समझ बैठे",
            "देखी है बेरुखी की आज हम ने इन्तेहाँ,\n" +
                    "हमपे नजर पड़ी तो वो महफ़िल से उठ गए।",
            "जिंदगी कुछ दिनों की हैं और मैं कुछ दिनों से बहुत परेशान हूँ",
            "माँगा था थोड़ा सा उजाला जिंदगी में, पर चाहने बालो ने तो आग ही लगा दी।"};

    String[] smiley_shayari={"एक अलग सी मुस्कान है मेरे चेहरे पर छाई है,\n" +
            "जब से तुझसे मिलने की खबर है आयी है।",
            "उदासी भरे गाने सुनते हुए भी अब मैं मुस्कुराने लगा हूँ,\n" +
                    "लगता है दीवानगी की हद तक मैं तुझे चाहने लगा हूँ।",
            "जनाब वजह यूं तो कई हैं ग़म में डूब जाने की।\n" +
                    "पर हमने एक वजह चुनी है उसमें मुस्कुराने की।",
            "फरेबी मुस्कानों ने चाहे लाखों ही दिल लूटे हों,\n" +
                    "मासूम मुस्कानें अक्सर रूह को छू ही लेती हैं।",
            "अब और क्या लिखूं उसकी प्यारी मुस्कान के बारे में,\n" +
                    "बस कुछ यूं समझ लो चमकता चाँद हैं लाखो सितारों में।"};

    int pos;
    String [] item;
    String[] temp;
    int[] imgArr;
    int img;
    TextView textView1;
    ImageView imageView,imageView2;
    ListView listView1;
    ShayriAdapter shayriAdapter;
    ActionBar actionBar;
    String actionTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        listView1=findViewById(R.id.category_listview);


        textView1=findViewById(R.id.list_text);
        imageView=findViewById(R.id.list_img);
        imageView2=findViewById(R.id.list_img2);

        pos=getIntent().getIntExtra("pos",0);
        imgArr=getIntent().getIntArrayExtra("imgarr");
        item=getIntent().getStringArrayExtra("itemarr");
        img=imgArr[pos];

        actionTitle=item[pos];

        actionBar=getSupportActionBar();
        actionBar.setTitle(actionTitle);

        if(pos==0)
         {
             temp=love_shayari;
         }
         if(pos==1)
         {
             temp=motivational_shayari;
         }
         if (pos==2)
         {
             temp=sad_shayari;
         }
         if (pos==3)
         {
             temp=smiley_shayari;
         }

         shayriAdapter=new ShayriAdapter(this,temp,img);
         listView1.setAdapter(shayriAdapter);

         listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent=new Intent(ShayriListActivity.this,shayariActivity.class);
                 intent.putExtra("temp",temp);
                 intent.putExtra("pos",i);
                 startActivity(intent);

             }
         });




    }
}