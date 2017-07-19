package com.example.laptop.appwisetask.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laptop.appwisetask.R;
import com.example.laptop.appwisetask.adapters.DetailedAdapter;
import com.example.laptop.appwisetask.models.DetailedItem;


import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DetailedAdapter mAdapter;
    private List<DetailedItem> mList;
    private EditText mItemEdit;
    private Intent mIntent;
    private Button mAddButton;
    private String mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        init();
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                text=mItemEdit.getText().toString();
                Toast.makeText(DetailedActivity.this,text,Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
            }
        });



    }

    private void init(){

        mIntent=getIntent();
        mCategory=mIntent.getStringExtra("title");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mCategory);
        mItemEdit=(EditText)findViewById(R.id.category_edit);
        mAddButton=(Button)findViewById(R.id.add_item);
        mRecyclerView=(RecyclerView) findViewById(R.id.detailed_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList=new ArrayList<>();
        mList=getItems();
        mAdapter=new DetailedAdapter(mList,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<DetailedItem> getItems(){
        List<DetailedItem>list=new ArrayList<>();
        DetailedItem item1=new DetailedItem("detailed1");
        DetailedItem item2=new DetailedItem("detailed2");
        DetailedItem item3=new DetailedItem("detailed3");
        DetailedItem item4=new DetailedItem("detailed4");
        DetailedItem item5=new DetailedItem("detailed5");
        list.add(item1);
        list.add(item2);
        item3.setDone(true);
        list.add(item3);
        list.add(item4);
        item5.setDone(true);
        list.add(item5);
        return list;
    }


}
