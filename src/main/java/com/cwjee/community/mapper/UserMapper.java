package com.cwjee.community.mapper;

import com.cwjee.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Victory
 * @date 2020/2/25 16:27:35
 * @decription
 */
@Mapper
public interface UserMapper {

    @Insert("insert into COMMUNITY.SCHEMA_USER.USER(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from COMMUNITY.SCHEMA_USER.USER where token = #{token}")
    User findByToken(@Param("token") String token);

}
