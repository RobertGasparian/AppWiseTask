package com.example.laptop.appwisetask.models;


import java.util.ArrayList;
import java.util.List;

public class Item {


    public String title;
    private List<DetailedItem> mList;

    public Item(String mTitle) {
        this.title = mTitle;
        mList=new ArrayList<>();
    }

    public void addItemToList(DetailedItem item){

        mList.add(item);
    }

    public DetailedItem getItemFromList(int position){
        return mList.get(position);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

    public List<DetailedItem> getmList() {
        return mList;
    }
}
