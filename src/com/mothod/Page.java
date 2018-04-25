package com.mothod;

import java.util.List;

public class Page {

    private int page;//当前页
    private int pagesize;//页面数据条数
    private int count;//总数据条数
    private int pagecount;//总页数
    private int pagefirst;//limit起点

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", pagesize=" + pagesize +
                ", count=" + count +
                ", pagecount=" + pagecount +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getPagefirst() {
        return pagefirst;
    }

    public void setPagefirst(int pagefirst) {
        this.pagefirst = pagefirst;
    }


}