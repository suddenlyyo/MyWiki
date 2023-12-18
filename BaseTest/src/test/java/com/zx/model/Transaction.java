package com.zx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction implements Serializable {
    /**
     * 唯一订单号
     */
    private String orderNo;
    /**
     * 交易时间
     */
    private LocalDateTime tradeDateTime;
    /**
     * 交易金额
     */
    private BigDecimal tradeAmount;
    /**
     * 比对标志
     */
    private String compareResultMark;
    /**
     * 比对说明
     */
    private String compareResultNote;

    public Transaction() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDateTime getTradeDateTime() {
        return tradeDateTime;
    }

    public void setTradeDateTime(LocalDateTime tradeDateTime) {
        this.tradeDateTime = tradeDateTime;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getCompareResultMark() {
        return compareResultMark;
    }

    public void setCompareResultMark(String compareResultMark) {
        this.compareResultMark = compareResultMark;
    }

    public String getCompareResultNote() {
        return compareResultNote;
    }

    public void setCompareResultNote(String compareResultNote) {
        this.compareResultNote = compareResultNote;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "orderNo='" + orderNo + '\'' +
                ", tradeDateTime=" + tradeDateTime +
                ", tradeAmount=" + tradeAmount +
                ", compareResultMark='" + compareResultMark + '\'' +
                ", compareResultNote='" + compareResultNote + '\'' +
                '}';
    }
}
