package com.qkainan.common;

import java.util.List;

public class PageResult<T> {
    private Integer currentPage;

    private Integer pageSize;

    private Integer total;

    private List<T> data;

    public PageResult(Integer currentPage, Integer pageSize, Integer total, List<T> data) {
        //当前页数
        this.currentPage = currentPage;
        //每页条数
        this.pageSize = pageSize;
        //总记录数
        this.total = total;
        //分页数据
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

