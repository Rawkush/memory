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


    private List<Model> list = new ArrayList();
    private LayoutInflater mInflater;
    private String prevData = null;
    private int prevPos = -1;
    ViewHolder preViewHolder = null;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, ArrayList<Model> list) {
        this.mInflater = LayoutInflater.from(context);
        this.list = list;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final Model data = list.get(position);
        holder.setIsRecyclable(true);
        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean match=false;
                if(!data.isSelected()){
                    data.setSelected(true);


                    //unhide data

                    if( data.getText().equals(prevData)&&prevPos!=position){
                       preViewHolder.myTextView.setVisibility(View.INVISIBLE);
                       holder.questionMark.setVisibility(View.INVISIBLE);
                       holder.myTextView.setVisibility(View.INVISIBLE);
                       //reset them
                        match=true;

                   }else{
                       if(preViewHolder!=null) {
                           preViewHolder.questionMark.setVisibility(View.VISIBLE);
                           Model model= list.get(prevPos);
                           if(position!=prevPos)
                           model.setSelected(false);
                       }
                    }


                    holder.questionMark.setVisibility(View.INVISIBLE);


                    // making currently selected as previous data
                        prevPos=position;
                        preViewHolder=holder;
                        prevData=data.getText();
                        if(match){
                            prevData=null;
                            preViewHolder=null;
                            prevPos=-1;
                            match=false;
                        }

                }else{
                    // data is already selected
                    // same data pressed twice
                    holder.questionMark.setVisibility(View.VISIBLE);
                    data.setSelected(false);

                }


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
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        TextView questionMark;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            questionMark = itemView.findViewById(R.id.questionMark);

        }
    }


}

