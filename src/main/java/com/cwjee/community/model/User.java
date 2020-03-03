package com.cwjee.community.model;

import lombok.Data;

/**
 * @author Victory
 * @date 2020/2/25 16:29:37
 * @decription
 */
@Data
public class User {
    private long id;
    private String name;
    private long accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
