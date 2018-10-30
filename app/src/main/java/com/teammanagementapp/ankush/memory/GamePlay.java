package com.teammanagementapp.ankush.memory;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class GamePlay extends AppCompatActivity {


    RecyclerView recyclerView;
    TextView timertextView;
    //CountDownTimer countDownTimer;
  //  final int gameTime = 120;  // 2 min
    Button resetbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

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

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));


    }


    private void startTimer() {
//
//        countDownTimer = new CountDownTimer(gameTime * 1000 + 100, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                updateTime((int) (millisUntilFinished / 1000));
//
//            }
//
//            @Override
//            public void onFinish() {
//
//                    //TODO Stop the game here
//
//            }  // first param is timer till which to count
//
//
//        }.start();


        final Handler handler= new Handler(); // it allows delaying
        Runnable run=new Runnable() {  //chunk of code that handler handles is called runnable
            @Override
            public void run() {
                // code to be run every second or afteer a period of time
                handler.postDelayed(this,1000);
                updateTime();
            }
        };
        handler.post(run); // ruun


    }

    public void updateTime(){
        if(!timertextView.getText().toString().equals("")) {
            int time = Integer.parseInt(timertextView.getText().toString());
            timertextView.setText("" + (time + 1));
        }

    }

    public void resettimer(){
        timertextView.setText("0");
    }



}