package com.imooc.bilibili.domain.exception;

public class ConditionException extends RuntimeException {

    private static final long serialVersionUID = 1L; //The serialVersionUID attribute is an identifier that is used to serialize/deserialize an object of a Serializable class

    private String code; //响应状态码

    public ConditionException(String code, String name){
        super(name);
        this.code = code;  //与runtime exception的区别在于多了一个code
    }

    public ConditionException(String name){
        super(name);
        code = "500";   //常规错误处理
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
