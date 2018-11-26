package com.wu.demo.fileupload.demo.util;

/**
 * 自定义异常类， 继承自Exception
 */
public class InsufficientFundsException extends Exception {
    //此处的amount用来储存当出现异常（取出钱多余余额时）所缺乏的钱
    private Double amount;
    public InsufficientFundsException(Double amount){
        this.amount = amount;
    }

    public Double getAmount(){
        return amount;
    }
}
