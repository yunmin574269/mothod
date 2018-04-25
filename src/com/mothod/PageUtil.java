package com.mothod;

public class PageUtil {

    public Page setpageinfo(int page,int pagesize,int pagecount){

        Page p=new Page();

        p.setPage(page);//当前页数
        p.setPagesize(pagesize);//每页数量
        p.setPagecount(pagecount);//总数量
        //总页数
        p.setPagecount((int) Math.ceil((double) pagecount/(double)pagesize));
        //limit 起始
        int first=(page-1)*pagesize;
        p.setPagefirst(first);

        return p;
    }


/*    public static void main(String args[]){
        Page s=setpageinfo(2,10,54);
        System.out.println(s);
    }*/
}
