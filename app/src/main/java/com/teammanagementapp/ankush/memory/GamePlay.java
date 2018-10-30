package com.teammanagementapp.ankush.memory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.teammanagementapp.ankush.memory.Adapter.RecyclerViewAdapter;

import static java.lang.Integer.parseInt;

public class GamePlay extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {



    MyRecyclerViewAdapter adapter;

    //RecyclerViewAdapter adapter;

    RecyclerView recyclerView;
    TextView timertextView;
    Button resetbtn;
    int position=-1;



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

        recyclerView = findViewById(R.id.rvNumbers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//        adapter=new RecyclerViewAdapter(this,data);
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



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


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText( this, "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position, Toast.LENGTH_SHORT ).show();


    }




}