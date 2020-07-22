package lsl.study2020.springcloud.entities;

import lombok.Data;

@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T   result;

    public CommonResult(){
    }
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
    public CommonResult(Integer code,String message,T result){
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
