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
import java.util.List;

public  class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private List<Model> list=new ArrayList();
    private LayoutInflater mInflater;
    private String prevData=null;
    private int prevPos=-1;
    ViewHolder preViewHolder=null;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder,  int position) {
        //holder.myTextView.setText(mData[position]);
        //TODO finding random number and
        final Model data = list.get(position);
        holder.setIsRecyclable(true);
        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data.setSelected(!data.isSelected());
                if(data.isSelected()){
                   holder.questionMark.setVisibility(View.INVISIBLE);

                   if(data.getText().equals(prevData)&& prevPos!=holder.getAdapterPosition()){
                       holder.questionMark.setVisibility(View.INVISIBLE);
                       holder.myTextView.setVisibility(View.INVISIBLE);
                       preViewHolder.myTextView.setVisibility(View.INVISIBLE);
                       preViewHolder.questionMark.setVisibility(View.INVISIBLE);
                   }else{
                       if(preViewHolder!=null){
                           preViewHolder.questionMark.setVisibility(View.VISIBLE);
                       }
                   }

                }  else {
                    holder.questionMark.setVisibility(View.VISIBLE);

                }

                prevPos=holder.getAdapterPosition();
                prevData=data.getText();
                preViewHolder=holder;
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


