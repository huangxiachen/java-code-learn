package com.chx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
    private Integer status;
    private String msg;
    private Object data;

    public static SysResult success(){
        return new SysResult(200,null,null);
    }

    public static SysResult success(Object o){
        return new SysResult(200,null,o);
    }

    public static SysResult success(String msg,Object o){
        return new SysResult(200,msg,o);
    }

    public static SysResult fail(String msg){
        return new SysResult(201,msg,null);
    }

    public static SysResult fail(){
        return new SysResult(201,null,null);
    }
}
