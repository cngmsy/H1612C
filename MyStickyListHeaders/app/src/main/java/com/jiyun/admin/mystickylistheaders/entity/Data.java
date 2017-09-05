package com.jiyun.admin.mystickylistheaders.entity;

/**
 * Created by admin on 2017/8/16.
 */
//右边的Bean
public class Data {
    private String info;  //普通条目的内容
    private int headId;  //进行分组操作,同组数据该字段相同
    private int headIndex;  //当前条目对应的头数据所在集合的index下标


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public int getHeadIndex() {
        return headIndex;
    }

    public void setHeadIndex(int headIndex) {
        this.headIndex = headIndex;
    }
}
