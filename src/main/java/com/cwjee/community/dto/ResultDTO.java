package com.cwjee.community.dto;

import com.cwjee.community.exception.CustomizeErrorCode;
import com.cwjee.community.exception.CustomizeException;
import lombok.Data;

/**
 * @author Victory
 * @date 2020/3/13 16:46:25
 * @decription
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode code) {
        return errorOf(code.getCode(),code.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }
}
