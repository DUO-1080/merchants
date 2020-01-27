package com.avondrix.merchants.ov;

import com.avondrix.merchants.constant.ErrorCode;
import com.avondrix.merchants.dao.MerchantsDao;

import java.util.Date;

public class PassTemplate {
    private Integer id;
    private String title;
    private String summary;
    private String desc;
    private Long limit;
    private Date start;
    private Date end;
    private Boolean hasToken;
    private Integer background;

    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (!merchantsDao.findById(id).isPresent()) {
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }
        return ErrorCode.SUCCESS;
    }


    public PassTemplate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getHasToken() {
        return hasToken;
    }

    public void setHasToken(Boolean hasToken) {
        this.hasToken = hasToken;
    }

    public Integer getBackground() {
        return background;
    }

    public void setBackground(Integer background) {
        this.background = background;
    }
}
