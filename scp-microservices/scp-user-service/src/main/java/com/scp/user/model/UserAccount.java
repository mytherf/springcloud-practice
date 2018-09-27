package com.scp.user.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_account")
public class UserAccount {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "silver_coin")
    private Integer silverCoin;

    @Column(name = "gold_coin")
    private Integer goldCoin;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return silver_coin
     */
    public Integer getSilverCoin() {
        return silverCoin;
    }

    /**
     * @param silverCoin
     */
    public void setSilverCoin(Integer silverCoin) {
        this.silverCoin = silverCoin;
    }

    /**
     * @return gold_coin
     */
    public Integer getGoldCoin() {
        return goldCoin;
    }

    /**
     * @param goldCoin
     */
    public void setGoldCoin(Integer goldCoin) {
        this.goldCoin = goldCoin;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}