package com.example.laptop.appwisetask.models;


public class DetailedItem {

    private String mText;
    private boolean done;


    public DetailedItem( String mText) {

        this.mText = mText;

    }

    public String getmText() {

        return mText;

    }

    public void setmText(String mText) {

        this.mText = mText;

    }

    public boolean isDone() {

        return done;

    }

    public void setDone(boolean done) {

        this.done = done;

    }

}
