package com.yy.model;

import java.io.Serializable;

/**
 * 账户余额
 */
//@Data
public class AccountBalance implements Serializable{

    private long id;

    /** 账户所在站点 */
    private String site;
    /** 账户地址 */
    private String accountAddr;
    /** 币种 */
    private String coinName;
    /** 余额 */
    private double balance;
    /** 冻结余额 */
    private double balanceFreeze;
    private long createdDate;
    private long modifyDate;

    public AccountBalance(){}

    public AccountBalance(String site, String accountAddr, String coinName,
                          double balance, double balanceFreeze, long createdDate,
                          long modifyDate) {
        this.site = site;
        this.accountAddr = accountAddr;
        this.coinName = coinName;
        this.balance = balance;
        this.balanceFreeze = balanceFreeze;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAccountAddr() {
        return accountAddr;
    }

    public void setAccountAddr(String accountAddr) {
        this.accountAddr = accountAddr;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalanceFreeze() {
        return balanceFreeze;
    }

    public void setBalanceFreeze(double balanceFreeze) {
        this.balanceFreeze = balanceFreeze;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }
}
