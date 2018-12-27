package com.badgenius.memory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.badgenius.memory.adapter.MyRecyclerViewAdapter;
import com.badgenius.memory.model.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GamePlay extends AppCompatActivity {




    MyRecyclerViewAdapter adapter;
    Thread thread=new Thread();
    final Handler handler = new Handler();  // useed for repititve tasks
    Runnable run;

    //RecyclerViewAdapter adapter;
    String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    RecyclerView recyclerView;
    TextView timertextView;
    ArrayList<Model> list= new ArrayList<Model>();
    Button resetbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);

        timertextView = findViewById(R.id.time);


        resetbtn = findViewById(R.id.resetbtn);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resettimer();
                list.clear();
                createUI();
            }
        });

        recyclerView = findViewById(R.id.rvNumbers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        adapter=new RecyclerViewAdapter(this,data);
        adapter = new MyRecyclerViewAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);

/*
        MyAsyncTask task= new MyAsyncTask();
        task.execute();
*/
        createUI();

    }


    private void createUI(){


        if(thread.getName().equals("creatingUI")){
            thread.interrupt();
            handler.removeCallbacks(run); // removing repetitve tasks


        }
        thread= new Thread(new Runnable() {
            @Override
            public void run() {

                createListOfpics();

            }
        });
        thread.setName("creatingUI");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
        startTimer();

    }

    private synchronized void randompics(ArrayList<String> temp) {
        for(int i=0;i<temp.size();){
        Random rand = new Random();
        int n = rand.nextInt(temp.size());
        String pic = temp.get(n);
        list.add(new Model(pic));
        temp.remove(n);
        }
    }
    private void createListOfpics() {
        ArrayList<String> temp= new ArrayList<>();
        Collections.addAll(temp, data); /// adding the string into list
        randompics(temp);
    }

    private void startTimer() {

         // it allows delaying
         run = new Runnable() {  //chunk of code that handler handles is called runnable
            @Override
            public void run() {
                // code to be run every second or afteer a period of time
                handler.postDelayed(run, 1000);
                updateTime();
            }
        };
        handler.post(run); // ruun


    }

    public void updateTime() {
        if (!timertextView.getText().toString().equals("")) {
            int time = Integer.parseInt(timertextView.getText().toString());
            timertextView.setText("" + (time + 1));
        }

    }

    public void resettimer() {
        timertextView.setText("0");
    }
}