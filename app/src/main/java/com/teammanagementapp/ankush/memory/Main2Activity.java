package com.teammanagementapp.ankush.memory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

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
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);
        textView9=findViewById(R.id.textView9);
        textView10=findViewById(R.id.textView10);
        textView11=findViewById(R.id.textView11);
        textView12=findViewById(R.id.textView12);
        textView13=findViewById(R.id.textView13);
        textView14=findViewById(R.id.textView14);
        textView15=findViewById(R.id.textView15);
        textView16=findViewById(R.id.textView16);
        textView17=findViewById(R.id.textView17);
        textView18=findViewById(R.id.textView18);

        textView19=findViewById(R.id.textView19);
        textView20=findViewById(R.id.textView20);
        textView21=findViewById(R.id.textView21);
        textView22=findViewById(R.id.textView22);
        textView23=findViewById(R.id.textView23);
        textView24=findViewById(R.id.textView24);

        textView21.setOnClickListener(this);

        textView20.setOnClickListener(this);

        textView19.setOnClickListener(this);

        textView18.setOnClickListener(this);

        textView17.setOnClickListener(this);

        textView16.setOnClickListener(this);

        textView15.setOnClickListener(this);

        textView14.setOnClickListener(this);

        textView13.setOnClickListener(this);

        textView12.setOnClickListener(this);

        textView11.setOnClickListener(this);

        textView10.setOnClickListener(this);

        textView9.setOnClickListener(this);

        textView8.setOnClickListener(this);

        textView7.setOnClickListener(this);

        textView6.setOnClickListener(this);

        textView5.setOnClickListener(this);

        textView4.setOnClickListener(this);

        textView3.setOnClickListener(this);

        textView2.setOnClickListener(this);

        textView1.setOnClickListener(this);

        textView22.setOnClickListener(this);


        textView23.setOnClickListener(this);

        textView24.setOnClickListener(this);


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


    @Override
    public void onClick(View v) {











    }





}
