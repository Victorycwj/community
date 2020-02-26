package com.cwjee.community.model;

import lombok.Data;

/**
 * @author Victory
 * @date 2020/2/26 20:41:43
 * @decription
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
