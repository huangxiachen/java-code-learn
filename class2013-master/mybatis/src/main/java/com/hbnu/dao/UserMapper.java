package com.hbnu.dao;

import com.hbnu.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-03-28 8:05
 */
public interface UserMapper {

    @Insert("insert into tb_user(name, addr) values(#{name}, #{addr})")
    public abstract void addData3(User user);

    // @Update("update tb_user set name = #{arg0} where id = #{arg1}")
    // @Update("update tb_user set name = #{param1} where id = #{param2}")
    @Update("update tb_user set name = #{name} where id = #{id}")
    // public abstract void updateData3(User user);
    // public abstract void updateData3(String name, int id);
    public abstract void updateData3(@Param(value = "name") String name, @Param(value = "id") int id);

    @Delete("delete from tb_user where id = #{id}")
    public abstract void deleteData3(int id);

    @Select("select * from tb_user where id = #{id}")
    public abstract User findById(int id);

    @Select("select * from tb_user")
    public abstract List<User> findAll3();
}
