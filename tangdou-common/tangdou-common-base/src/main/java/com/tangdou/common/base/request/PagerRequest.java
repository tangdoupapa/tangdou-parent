package com.tangdou.common.base.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PagerRequest {
    @ApiModelProperty("当前页")
    private Integer currentPage = 1;

    @ApiModelProperty("页大小")
    private Integer pageSize = 10;

    @ApiModelProperty("分页开始记录条数")
    private Integer start;

    @ApiModelProperty("模糊搜索条件")
    private String search;

    @ApiModelProperty("排序字段，多个字段用','隔开")
    private String orderField;

    @ApiModelProperty("排序方式，DESC降序；ASC升序")
    private String sort = "DESC";

    /**
     * 设置并纠正当前页
     *
     * @param currentPage
     */
    public void setCurrentPage(Integer currentPage) {
        if (currentPage > 0) {
            this.currentPage = currentPage;
            return;
        }
        this.currentPage = 1;
    }

    /**
     * 设置并纠正页大小
     *
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
            return;
        }
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField == null ? null : orderField.trim();
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public void setStart(Integer start) {
        if (start.compareTo(0) > -1) {
            this.start = start;
        }
    }
}
