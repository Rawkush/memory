package com.teammanagementapp.ankush.memory.model;

import android.widget.TextView;

public class model {


    public model(int position, TextView textView, TextView question) {
        this.position = position;
        this.textView = textView;
        this.question = question;
    }

    public int position;
    public  TextView textView;
    public  TextView question;



}
