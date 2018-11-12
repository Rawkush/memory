package com.badgenius.memory.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.badgenius.memory.R;
import com.badgenius.memory.model.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public  class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private List<Model> list=new ArrayList();
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public  MyRecyclerViewAdapter(Context context, ArrayList<Model> list) {
        this.mInflater = LayoutInflater.from(context);
        this.list=list;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        //holder.myTextView.setText(mData[position]);
        //TODO finding random number and
        final Model data = list.get(position);
        holder.setIsRecyclable(true);
        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.isSelected()){
                   holder.questionMark.setVisibility(View.INVISIBLE);
                }  else
                    holder.questionMark.setVisibility(View.VISIBLE);

                data.setSelected(!data.isSelected());


            }
        });
        holder.myTextView.setText(list.get(position).getText());

    }



    // total number of cells
    @Override
    public int getItemCount() {
        return list.size();
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



            }
        }




}

