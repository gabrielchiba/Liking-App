package com.example.likingapp.models;

import org.json.JSONArray;

public class Data {
    private int offset;
    private int limit;
    private int total;
    private int count;
    // TODO
    // Results

    public Data(int offset, int limit, int total, int count) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
