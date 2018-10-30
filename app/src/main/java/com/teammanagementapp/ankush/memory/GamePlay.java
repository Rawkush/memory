package com.teammanagementapp.ankush.memory;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GamePlay extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {


    TextView textView;
    MyRecyclerViewAdapter adapter;
    TextView timertextView;
    CountDownTimer countDownTimer;
    final int gameTime = 120;  // 2 min
    Button resetbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        timertextView = findViewById(R.id.time);

        startTimer();

        resetbtn=findViewById(R.id.resetbtn);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resettimer();
              //TODO resetGame();

            }
        });


    }


    private void startTimer() {

        countDownTimer = new CountDownTimer(gameTime * 1000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                updateTime((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                    //TODO Stop the game here

            }  // first param is timer till which to count


        }.start();



    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText( this, "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position, Toast.LENGTH_SHORT ).show();
    }


    public void updateTime(int secondsLeft){

        int minutes =(int) secondsLeft/ 60;
        int seconds= secondsLeft-minutes*60;
        timertextView.setText(Integer.toString(minutes)+":"+Integer.toString(seconds));


    }

    public void resettimer(){
        countDownTimer.cancel();

    }



}
