package com.cwjee.community.model;

import lombok.Data;

/**
 * @author Victory
 * @date 2020/2/25 16:29:37
 * @decription
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;

}
