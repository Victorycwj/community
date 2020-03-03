package com.cwjee.community.mapper;

import com.cwjee.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Victory
 * @date 2020/2/25 16:27:35
 * @decription
 */
@Mapper
public interface UserMapper {

    @Insert("insert into COMMUNITY.SCHEMA_USER.USER(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from COMMUNITY.SCHEMA_USER.USER where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from COMMUNITY.SCHEMA_USER.USER where account_id = #{id} ")
    User findById(@Param("id") long id);

    @Update("update COMMUNITY.SCHEMA_USER.USER set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where account_id = #{accountId} ")
    void update(User user);
}
