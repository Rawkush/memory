package com.teammanagementapp.ankush.memory;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePlay extends AppCompatActivity {


    RecyclerView recyclerView;
    TextView textView;
    TextView timertextView;
    CountDownTimer countDownTimer;
    final int gameTime = 12;
    Button resetbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        timertextView = findViewById(R.id.time);
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    private void StartTimer() {

        countDownTimer = new CountDownTimer(gameTime * 1000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                updateTime((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                    //TODO Stop the game here

            }  // first param is timer till which to count


        };


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