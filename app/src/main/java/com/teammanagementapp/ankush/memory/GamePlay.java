package com.teammanagementapp.ankush.memory;
import android.content.Context;
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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.teammanagementapp.ankush.memory.Adapter.RecyclerViewAdapter;
import com.teammanagementapp.ankush.memory.model.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class GamePlay extends AppCompatActivity {


    TextView textViewG;
    TextView QuestionG;


    boolean first = true;
    String prev;

    MyRecyclerViewAdapter adapter;

    //RecyclerViewAdapter adapter;
    String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    RecyclerView recyclerView;
    TextView timertextView;
    Button resetbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        timertextView = findViewById(R.id.time);

        startTimer();

        resetbtn = findViewById(R.id.resetbtn);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resettimer();
                //TODO resetGame();

            }
        });

        recyclerView = findViewById(R.id.rvNumbers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//        adapter=new RecyclerViewAdapter(this,data);
        adapter = new MyRecyclerViewAdapter(this, data);
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


        final Handler handler = new Handler(); // it allows delaying
        Runnable run = new Runnable() {  //chunk of code that handler handles is called runnable
            @Override
            public void run() {
                // code to be run every second or afteer a period of time
                handler.postDelayed(this, 1000);
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


    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


        private String[] mData;
        private List<String> list;
        private List<String> dataOFPics;
        private LayoutInflater mInflater;

        // data is passed into the constructor
        MyRecyclerViewAdapter(Context context, String[] data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
            list = new ArrayList<String>();
            dataOFPics = new ArrayList<>();
            createListOfpics();
        }

        // inflates the cell layout from xml when needed
        @Override
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        // binds the data to the TextView in each cell
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //holder.myTextView.setText(mData[position]);
            //TODO finding random number and
            holder.myTextView.setText(randompics());

        }


        private void createListOfpics() {

            Collections.addAll(list, mData); /// adding the string into list

        }


        private String randompics() {

            Random rand = new Random();
            int n = rand.nextInt(list.size());
            String pic = list.get(n);
            dataOFPics.add(pic);
            list.remove(n);
            return pic;
        }


        // total number of cells
        @Override
        public int getItemCount() {
            return mData.length;
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView myTextView;
            TextView questionMark;

            ViewHolder(View itemView) {
                super(itemView);

                myTextView = itemView.findViewById(R.id.info_text);
                questionMark = itemView.findViewById(R.id.questionMark);
                itemView.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {

                if (first){
                    prev=myTextView.getText().toString();
                    questionMark.setVisibility(View.INVISIBLE);
                    QuestionG=myTextView;
                    first=false;
                }else{
                    if(prev.equals(myTextView.getText().toString())){
                        myTextView.setVisibility(View.INVISIBLE);
                        questionMark.setVisibility(View.INVISIBLE);

                    }else{
                        questionMark.setVisibility(View.INVISIBLE);
                        QuestionG.setVisibility(View.VISIBLE);

                    }

                    first=true;
                }


            }

        }


    }


}
