package com.tech.tsr.nestedrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tech.tsr.nestedrecyclerview.models.InnerListModel;
import com.tech.tsr.nestedrecyclerview.models.OuterListModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView outer_recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<OuterListModel> outerList = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);
        recyclerViewAdapter = new RecyclerViewAdapter(outerList, context);
        outer_recyclerView = findViewById(R.id.outer_recyclerView);
        outer_recyclerView.setHasFixedSize(true);
        outer_recyclerView.setLayoutManager(linearLayoutManager);
        outer_recyclerView.setAdapter(recyclerViewAdapter);
        createDummyData();
    }

    private void createDummyData() {
        if(outerList.size()==0){
            InnerListModel innerModel1 = new InnerListModel("Inner Value 1", "Value1");
            InnerListModel innerModel2 = new InnerListModel("Inner Value 2", "Value2");
            InnerListModel innerModel3 = new InnerListModel("Inner Value 3", "Value3");
            InnerListModel innerModel4 = new InnerListModel("Inner Value 4", "Value4");
            InnerListModel innerModel5 = new InnerListModel("Inner Value 5", "Value5");
            InnerListModel innerModel6 = new InnerListModel("Inner Value 6", "Value6");
            ArrayList<InnerListModel> innerListModelArrayList = new ArrayList<>();
            innerListModelArrayList.add(innerModel1);
            innerListModelArrayList.add(innerModel2);
            innerListModelArrayList.add(innerModel3);
            innerListModelArrayList.add(innerModel4);
            innerListModelArrayList.add(innerModel5);
            innerListModelArrayList.add(innerModel6);


            OuterListModel outerListModel1 = new OuterListModel("Outer List1",innerListModelArrayList);
            OuterListModel outerListModel2 = new OuterListModel("Outer List2",innerListModelArrayList);
            OuterListModel outerListModel3 = new OuterListModel("Outer List3",innerListModelArrayList);
            outerList.add(outerListModel1);
            outerList.add(outerListModel2);
            outerList.add(outerListModel3);
        }
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
