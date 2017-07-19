package com.example.laptop.appwisetask.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.laptop.appwisetask.R;
import com.example.laptop.appwisetask.activities.DetailedActivity;
import com.example.laptop.appwisetask.models.DetailedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laptop on 7/19/2017.
 */

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder> {


    private List<DetailedItem> mList;
    private Context mContext;
    private String mTitle;
    private List<DetailedItem> mDoneList;
    private List<DetailedItem> mTodoList;

    public InnerAdapter(List<DetailedItem> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mDoneList=new ArrayList<>();
        mTodoList=new ArrayList<>();
        setList();
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.detailed_rv_item, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {

        holder.button.setClickable(false);

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

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DetailedActivity.class);
                intent.putExtra("title",mTitle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    class InnerHolder extends RecyclerView.ViewHolder {


        private TextView mItemText;
        private ImageButton button;
        private RelativeLayout relativeLayout;

        public InnerHolder(View itemView) {
            super(itemView);

            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.inner_rv_layout);
            mItemText = (TextView) itemView.findViewById(R.id.item_text);
            button = (ImageButton) itemView.findViewById(R.id.todo_button);

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
