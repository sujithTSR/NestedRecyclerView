package com.tech.tsr.nestedrecyclerview.models;

public class InnerListModel {
    private String inner_value1;
    private String inner_value2;

    public InnerListModel(String inner_value1, String inner_value2) {
        this.inner_value1 = inner_value1;
        this.inner_value2 = inner_value2;
    }

    public String getInner_value1() {
        return inner_value1;
    }

    public void setInner_value1(String inner_value1) {
        this.inner_value1 = inner_value1;
    }

    public String getInner_value2() {
        return inner_value2;
    }

    public void setInner_value2(String inner_value2) {
        this.inner_value2 = inner_value2;
    }
}
