package com.hq.simpleblog.vo;

import com.alibaba.fastjson.JSONObject;
import com.hq.simpleblog.enums.Code;
import lombok.Data;

/**
 * 返回数据 VO 类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 15:15
 **/
@Data
public class ResultVO {

    private Integer code;

    private String msg;

    private JSONObject data;

    public ResultVO() {
        code = Code.Success.getCode();
        msg = Code.Success.getMessage();
        data = new JSONObject();
    }

    public void setCode(Code code) {
        this.code = code.getCode();
        this.msg = code.getMessage();
    }

}
