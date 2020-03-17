package com.cwjee.community.mapper;

import com.cwjee.community.model.Comment;

/**
 * @author Victory
 * @date 2020/3/17 15:27:32
 * @decription
 */
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
