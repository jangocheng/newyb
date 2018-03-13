package com.yiban.erp.exception;

import com.alibaba.fastjson.JSONObject;

public enum ErrorCode {
    FAILED_DELETE_FROM_DB(1000, "无法删除", ErrorDisplay.NOTICE),
    FAILED_INSERT_FROM_DB(1001, "无法添加", ErrorDisplay.NOTICE),
    FAILED_UPDATE_FROM_DB(1002, "无法修改", ErrorDisplay.NOTICE),
    FAILED_PINGYIN_EXCEPTION(1003, "获取拼音缩写失败"),

    // 11xx - 用户
    USER_NAME_NOT_EXISTED(1100, "用户名不存在"),
    LOGIN_PASSWORD_INVALID(1101, "密码错误"),
    LOGIN_USERNAME_MISSING(1102, "请输入用户名"),
    LOGIN_PASSWORD_MISSING(1103, "请输入密码"),
    USER_REGISTER_FAIL(1104, "用户创建失败"),

    // 12xx - 商品
    GOODS_CATEGORY_ID_MISSING(1201, "缺失商品分类ID"),
    GOODS_REMAINED_IN_CATEGORY(1200, "该分类下还有商品,请先移除商品后操作"),

    CUSTOMER_GET_FAIL(2000, "获取客户信息失败"),
    CUSTOMER_DEL_PARAMS_EMPTY(2001, "请选择需要删除的客户"),
    CUSTOMER_CAT_HAVE_CUST(2002, "分组下存在有客户信息, 不能删除", ErrorDisplay.NOTICE),
    CUSTOMER_CAT_HAVE_CAT(2003, "分组下存在子分组, 不能删除", ErrorDisplay.MODAL),
    CUSTOMER_CAT_DEL_PARAMS(2004, "请选择需要删除的分组"),
    CUSTOMER_REQUIRE_PARAMS_ERROR(2005, "验证客户信息必输项失败"),
    CUSTOMER_CERT_PARAMS_ERROR(2006, "验证客户证件信息必输项失败"),
    CUSTOMER_CERT_IMAGE_NO_ERROR(2007, "证件信息的档案编号错误"),
    CUSTOMER_CERT_REMOVE_PARAMS(2008, "请选择需要删除的证件"),
    CUSTOMER_REP_PARAMS_ERROR(2009, "验证客户代表人信息必输项失败"),
    CUSTOMER_REP_REMOVE_PARAMS(2010, "请选择需要删除的代表人信息"),


    ACCESS_PERMISSION(9001, "无访问权限", ErrorDisplay.MODAL);

    private Integer code;
    private String message;
    private ErrorDisplay display;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode(Integer code, String message, ErrorDisplay display) {
        this.code = code;
        this.message = message;
        this.display = display;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDisplay getDisplay() {
        return display;
    }

    public String toString() {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("message", message);
        if (display != null) {
            obj.put("display", display.name());
        }
        return obj.toString();
    }
}
