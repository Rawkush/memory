package com.teammanagementapp.ankush.memory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private String[] mData;
    private List<String> list;
    private List<String > dataOFPics;
    private LayoutInflater mInflater;
   TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19,textView20,textView21,textView22,textView23,textView24;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        mData=data;
        textView1=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView);
        textView5=findViewById(R.id.textView);
        textView6=findViewById(R.id.textView);
        textView7=findViewById(R.id.textView);
        textView8=findViewById(R.id.textView);
        textView9=findViewById(R.id.textView);
        textView10=findViewById(R.id.textView);
        textView11=findViewById(R.id.textView);
        textView12=findViewById(R.id.textView);
        textView13=findViewById(R.id.textView);
        textView14=findViewById(R.id.textView);
        textView15=findViewById(R.id.textView);
        textView16=findViewById(R.id.textView);
        textView17=findViewById(R.id.textView);
        textView18=findViewById(R.id.textView);

        textView19=findViewById(R.id.textView);
        textView20=findViewById(R.id.textView);
        textView21=findViewById(R.id.textView);
        textView22=findViewById(R.id.textView);
        textView23=findViewById(R.id.textView);
        textView24=findViewById(R.id.textView);





        createListOfpics();





    }



    private  void createListOfpics(){

        Collections.addAll(list, mData); /// adding the string into list

    }

    private String randompics(){

        Random rand = new Random();
        int  n = rand.nextInt(list.size());
        String pic = list.get(n);
        dataOFPics.add(pic);
        list.remove(n);

        return pic;
    }





}
