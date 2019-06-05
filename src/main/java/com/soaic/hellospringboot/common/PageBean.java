package com.soaic.hellospringboot.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageBean<T> extends PageInfo<T> {

    public PageBean(List<T> list){
        super(list);
    }

    @JsonIgnore
    @Override
    public int getSize() {
        return super.getSize();
    }

    @JsonIgnore
    @Override
    public int getStartRow() {
        return super.getStartRow();
    }

    @JsonIgnore
    @Override
    public int getEndRow() {
        return super.getEndRow();
    }

    @JsonIgnore
    @Override
    public int getPrePage() {
        return super.getPrePage();
    }

    @JsonIgnore
    @Override
    public int getNextPage() {
        return super.getNextPage();
    }

    @JsonIgnore
    @Override
    public boolean isIsFirstPage() {
        return super.isIsFirstPage();
    }

    @JsonIgnore
    @Override
    public boolean isIsLastPage() {
        return super.isIsLastPage();
    }

    @JsonIgnore
    @Override
    public boolean isHasNextPage() {
        return super.isHasNextPage();
    }

    @JsonIgnore
    @Override
    public boolean isHasPreviousPage() {
        return super.isHasPreviousPage();
    }

    @JsonIgnore
    @Override
    public int getNavigatePages() {
        return super.getNavigatePages();
    }

    @JsonIgnore
    @Override
    public int[] getNavigatepageNums() {
        return super.getNavigatepageNums();
    }

    @JsonIgnore
    @Override
    public int getNavigateFirstPage() {
        return super.getNavigateFirstPage();
    }

    @JsonIgnore
    @Override
    public int getNavigateLastPage() {
        return super.getNavigateLastPage();
    }

    @JsonIgnore
    @Override
    public int getPages() {
        return super.getPages();
    }

    @JsonProperty("items")
    @Override
    public List<T> getList() {
        return super.getList();
    }

    @JsonProperty("items")
    @Override
    public void setList(List<T> list) {
        super.setList(list);
    }
}