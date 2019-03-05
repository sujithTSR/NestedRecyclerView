package com.tech.tsr.nestedrecyclerview.models;

import java.util.ArrayList;

public class OuterListModel {

    private String header;
    private ArrayList<InnerListModel> innerLists;

    public OuterListModel(String header, ArrayList<InnerListModel> innerLists) {
        this.header = header;
        this.innerLists = innerLists;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList<InnerListModel> getInnerLists() {
        return innerLists;
    }

    public void setInnerLists(ArrayList<InnerListModel> innerLists) {
        this.innerLists = innerLists;
    }
}
