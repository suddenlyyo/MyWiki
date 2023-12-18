package com.zx.enums;


public enum BillCheckMarkEnum {
    /**
     * 正确
     */
    OK("R", "正确"),
    /**
     * 不一致
     */
    DIFFERENCE("B", "不一致"),
    /**
     * 多余
     */
    REMAINING("E", "多余");

    /**
     * code R-正确，B-不一致，E-多余(即平台医保订单中不存在)
     */
    private String code;
    /**
     * 说明
     */
    private String comment;

    BillCheckMarkEnum(String code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    public static BillCheckMarkEnum getBillCheckMarkEnum(String code) {
        for (BillCheckMarkEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
