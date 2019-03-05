package com.tech.tsr.nestedrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech.tsr.nestedrecyclerview.models.OuterListModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    RecyclerView.RecycledViewPool viewPool;
    private ArrayList<OuterListModel> outerList;
    private Context context;

    public RecyclerViewAdapter(ArrayList<OuterListModel> outerList, Context context) {
        this.outerList = outerList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.outer_recycler, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.rv_textView.setText(outerList.get(i).getHeader());
        LinearLayoutManager layoutManager_inner = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);
        viewHolder.rv_child.setLayoutManager(layoutManager_inner);
        InnerRecyclerViewAdapter innerRecyclerViewAdapter = new InnerRecyclerViewAdapter(outerList.get(i).getInnerLists(),context);
        viewHolder.rv_child.setAdapter(innerRecyclerViewAdapter);
        innerRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return outerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_child;
        TextView rv_textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_child = itemView.findViewById(R.id.rv_child);
            rv_textView = itemView.findViewById(R.id.rv_textView);

        }
    }
}
