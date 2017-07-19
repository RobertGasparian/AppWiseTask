package com.example.laptop.appwisetask.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.laptop.appwisetask.R;
import com.example.laptop.appwisetask.activities.DetailedActivity;
import com.example.laptop.appwisetask.models.DetailedItem;
import com.example.laptop.appwisetask.models.Item;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {


    private List<Item> mList;

    private Context mContext;

    public CategoryAdapter(List<Item> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.category_rv_item,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, final int position) {


        holder.adapter.setmTitle(mList.get(position).getTitle());
        holder.title.setText(mList.get(position).getTitle());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DetailedActivity.class);
                intent.putExtra("title",mList.get(position).getTitle());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder{

        TextView title;
        RecyclerView recyclerView;
        InnerAdapter adapter;
        private List<DetailedItem> detailedItems;
        private LinearLayout layout;

        public CategoryHolder(View itemView) {
            super(itemView);

            detailedItems=getItems();
            title=(TextView)itemView.findViewById(R.id.category_title);
            recyclerView=(RecyclerView)itemView.findViewById(R.id.inner_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            adapter=new InnerAdapter(detailedItems,mContext);
            recyclerView.setAdapter(adapter);
            layout=(LinearLayout)itemView.findViewById(R.id.category_rv_item_layout);


        }

        public void setDetailedItems(List<DetailedItem> detailedItems) {
            this.detailedItems = detailedItems;
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
            list.add(item5);
            return list;
        }
    }


}
