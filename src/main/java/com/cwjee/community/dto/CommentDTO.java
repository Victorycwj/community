package com.cwjee.community.dto;

import com.cwjee.community.model.User;
import lombok.Data;

/**
 * @author Victory
 * @date 2020/3/16 14:58:08
 * @decription
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
