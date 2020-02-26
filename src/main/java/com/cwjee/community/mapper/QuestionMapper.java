package com.cwjee.community.mapper;

import com.cwjee.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Victory
 * @date 2020/2/26 20:36:02
 * @decription
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into COMMUNITY.SCHEMA_USER.QUESTION(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

}
