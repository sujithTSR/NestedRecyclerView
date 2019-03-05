package com.tech.tsr.nestedrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech.tsr.nestedrecyclerview.models.InnerListModel;

import java.util.ArrayList;

public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ChildViewHolder>{
    private ArrayList<InnerListModel> innerLists;
    private Context context;
    public InnerRecyclerViewAdapter(ArrayList<InnerListModel> innerLists, Context context) {
        this.innerLists = innerLists;
        this.context = context;
    }

    @NonNull
    @Override
    public InnerRecyclerViewAdapter.ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.inner_recycler, viewGroup, false);
        return new InnerRecyclerViewAdapter.ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerRecyclerViewAdapter.ChildViewHolder viewHolder, int i) {
        viewHolder.rv_inner_tv.setText(innerLists.get(i).getInner_value1());
        viewHolder.rv_inner_tv2.setText(innerLists.get(i).getInner_value2());
    }

    @Override
    public int getItemCount() {
        return innerLists.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder{
        TextView rv_inner_tv, rv_inner_tv2;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_inner_tv = itemView.findViewById(R.id.rv_inner_tv);
            rv_inner_tv2 = itemView.findViewById(R.id.rv_inner_tv2);
        }
    }
}
