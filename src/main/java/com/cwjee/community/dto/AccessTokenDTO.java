package com.cwjee.community.dto;

import lombok.Data;

/**
 * @author Victory
 * @date 2020/2/23 17:06:04
 * @decription
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
