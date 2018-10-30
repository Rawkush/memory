package com.teammanagementapp.ankush.memory.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teammanagementapp.ankush.memory.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    Context context;
    private String[] mData;
    private List<String> list;
    private List<String > dataOFPics;
    private LayoutInflater mInflater;




    public RecyclerViewAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        list= new ArrayList<String>();
        dataOFPics= new ArrayList<>();
        createListOfpics();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        AnimeModel data= items.get(position);
//        holder.titles.setText(data.getTitle());
//        holder.episode.setText(data.getEpisode());
//        Glide.with(context)
//                .load(data.getImgUrl())
//                .into(holder.imageView);


        holder.textView.setText(randompics());
    }

    @Override
    public int getItemCount() {
        return list.size();
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






    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textView;
        public TextView questionMark;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.info_text);
            questionMark=itemView.findViewById(R.id.questionMark);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int p = getAdapterPosition();
         //   questionMark.setVisibility(View.INVISIBLE);


        }
    }


}