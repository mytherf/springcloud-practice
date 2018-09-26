package com.scp.user.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_reg_stat")
public class UserRegStat {
    private Integer id;

    @Column(name = "reg_date")
    private Date regDate;

    @Column(name = "reg_type")
    private Integer regType;

    @Column(name = "reg_area")
    private String regArea;

    @Column(name = "reg_num")
    private Integer regNum;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return reg_date
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * @return reg_type
     */
    public Integer getRegType() {
        return regType;
    }

    /**
     * @param regType
     */
    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    /**
     * @return reg_area
     */
    public String getRegArea() {
        return regArea;
    }

    /**
     * @param regArea
     */
    public void setRegArea(String regArea) {
        this.regArea = regArea;
    }

    /**
     * @return reg_num
     */
    public Integer getRegNum() {
        return regNum;
    }

    /**
     * @param regNum
     */
    public void setRegNum(Integer regNum) {
        this.regNum = regNum;
    }
}