package com.example.laptop.appwisetask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laptop.appwisetask.R;
import com.example.laptop.appwisetask.adapters.CategoryAdapter;
import com.example.laptop.appwisetask.models.DetailedItem;
import com.example.laptop.appwisetask.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private List<Item> mList;
    private CategoryAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private Button mAddCategory;
    private EditText mEditCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                text=mEditCategory.getText().toString();
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();

            }
        });

    }
    private void init(){
        mList=getData();
        mRecyclerView = (RecyclerView)findViewById(R.id.category_rv);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mAdapter=new CategoryAdapter(mList,this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAddCategory=(Button)findViewById(R.id.add_category);
        mEditCategory=(EditText)findViewById(R.id.category_edit);

    }

    private List<Item> getData(){
        Item item1=new Item("books");
        Item item2=new Item("sport");
        Item item3=new Item("tv shows");
        Item item4=new Item("study");
        List<Item> list=new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        return list;
    }
}
