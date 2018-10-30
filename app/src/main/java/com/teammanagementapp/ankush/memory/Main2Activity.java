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
 //   TextView textView1,textView1,textView1,textView1,textView1,textView1,textView1,textView1,



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        mData=data;
        createListOfpics();


                for(int i=0;i<25;i++){



                }


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
