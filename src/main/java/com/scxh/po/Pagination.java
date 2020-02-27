package com.scxh.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 简略的分页类，只显示上下翻页
 * @Date: 2020/02/27 16:59
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Pagination<E> {
    /**
     * 当前页数
     */
    private Integer currCount;
    /**
     * 数据列表
     */
    private List<E> elements;
    /**
     * 每页记录数
     */
    private final Integer pageSize=6;
    /**
     * 总页数
     */
    private Integer pageTotal;
    /**
     * 显示下一页
     */
    private boolean showNext;
    /**
     * 显示上一页
     */
    private boolean showPrevious;

    /**
     * 根据当前页，总记录数，设置分页类
     * @param pageCount 当前页
     * @param total 总记录数
     */
    public void setPagination(Integer pageCount,Integer total)
    {
        this.currCount =pageCount;
        this.pageTotal=total%this.pageSize==0?(total/this.pageSize):((total/this.pageSize)+1);
        if (pageCount>pageTotal)
        {
            pageCount=pageTotal;
        }
        //如果总页数小于2，或者当前页等于总页数，就不显示下一页
        this.showNext= pageTotal >= 2 && !pageCount.equals(pageTotal);
        //如果当前页为第一页，就不显示上一页
        this.showPrevious= pageCount != 1;
    }
}
