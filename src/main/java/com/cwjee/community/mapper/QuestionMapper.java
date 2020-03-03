package com.cwjee.community.mapper;

import com.cwjee.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Victory
 * @date 2020/2/26 20:36:02
 * @decription
 */
@Mapper
public interface QuestionMapper {

    @Select("select * from COMMUNITY.SCHEMA_USER.QUESTION limit #{offset},#{size}")
    List<Question> list(Integer offset, Integer size);

    @Insert("insert into COMMUNITY.SCHEMA_USER.QUESTION(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select count(1) from COMMUNITY.SCHEMA_USER.QUESTION")
    Integer count();


    @Select("select count(1) from  COMMUNITY.SCHEMA_USER.QUESTION where creator=#{userId}")
    Integer countByUserId(Long userId);

    @Select("select * from COMMUNITY.SCHEMA_USER.QUESTION where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(Long userId, Integer offset, Integer size);

    @Select("select * from COMMUNITY.SCHEMA_USER.QUESTION where id=#{id}")
    Question getById(@Param("id") Integer id);
}
