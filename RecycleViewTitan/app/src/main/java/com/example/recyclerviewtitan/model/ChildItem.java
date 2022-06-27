package com.example.recyclerviewtitan.model;

public class ChildItem {

    private String ChildItemTitle;
    private int ChildItemRate;

    public ChildItem(String childItemTitle, int ChildItemRate) {
        this.ChildItemTitle = childItemTitle;
        this.ChildItemRate = ChildItemRate;
    }

    public String getChildItemTitle() {
        return ChildItemTitle;
    }

    public void setChildItemTitle(String childItemTitle) {
        ChildItemTitle = childItemTitle;
    }

    public int getChildItemRate() {
        return ChildItemRate;
    }

    public void setChildItemRate(int childItemRate) {
        ChildItemRate = childItemRate;
    }
}