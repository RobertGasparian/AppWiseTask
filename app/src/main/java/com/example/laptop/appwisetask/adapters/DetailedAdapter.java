package com.example.laptop.appwisetask.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.laptop.appwisetask.R;
import com.example.laptop.appwisetask.models.DetailedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laptop on 7/19/2017.
 */

public class DetailedAdapter extends RecyclerView.Adapter<DetailedAdapter.DetailedHolder>{


    private List<DetailedItem> mList;
    private List<DetailedItem> mDoneList;
    private List<DetailedItem> mTodoList;
    private Context mContext;



    public DetailedAdapter(List<DetailedItem> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mDoneList=new ArrayList<>();
        mTodoList=new ArrayList<>();
        setList();
    }

    @Override
    public DetailedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.detailed_rv_item,parent,false);
        return new DetailedHolder(view);

    }

    @Override
    public void onBindViewHolder(final DetailedHolder holder, final int position) {



        if(!mList.get(position).isDone()){
            holder.mItemText.setText(mList.get(position).getmText());
            holder.mItemText.setPaintFlags(holder.mItemText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.button.setImageResource(R.drawable.to_do);
        }

        else {
            holder.mItemText.setText(mList.get(position).getmText());
            holder.mItemText.setPaintFlags(0);
            holder.button.setImageResource(R.drawable.done);
        }

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mList.get(position).isDone()){
                    mList.get(position).setDone(false);
                    holder.mItemText.setPaintFlags(0);
                    setList();
                    notifyDataSetChanged();
                }
                else{
                    mList.get(position).setDone(true);
                    holder.mItemText.setPaintFlags(holder.mItemText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    setList();
                    notifyDataSetChanged();
                }


            }
        });



    }

    @Override
    public int getItemCount() {
        if(mList==null){
            return 0;
        }
        else{
        return mList.size();}
    }

    class DetailedHolder extends RecyclerView.ViewHolder{

        private TextView mItemText;
        private ImageButton button;

        public DetailedHolder(View itemView) {
            super(itemView);
            mItemText=(TextView)itemView.findViewById(R.id.item_text);
            button=(ImageButton)itemView.findViewById(R.id.todo_button);
        }
    }

    private void setList(){
        for (int i = 0; i < mList.size(); i++) {
            if(mList.get(i).isDone()){
                mDoneList.add(mList.get(i));
            }
        }
        for (int i = 0; i < mList.size(); i++) {
            if(!mList.get(i).isDone()){
                mTodoList.add(mList.get(i));
            }
        }
        mList.clear();
        mList.addAll(mDoneList);
        mDoneList.clear();
        mList.addAll(mTodoList);
        mTodoList.clear();
    }
}
