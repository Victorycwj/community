package com.cwjee.community.dto;

import com.cwjee.community.model.User;
import lombok.Data;

/**
 * @author Victory
 * @date 2020/2/27 15:12:32
 * @decription
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
