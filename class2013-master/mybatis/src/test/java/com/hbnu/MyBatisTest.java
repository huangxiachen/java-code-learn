package com.hbnu;

import com.hbnu.dao.UserMapper;
import com.hbnu.pojo.Classes;
import com.hbnu.pojo.Teacher;
import com.hbnu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chendikai
 * @date 2023-03-21 9:20
 */
public class MyBatisTest {

    private SqlSession sqlSession = null;

    @Before
    public void beforeCRUD() throws IOException {
        // 1、获取配置文件输入流对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // InputStream inputStream = MyBatisTest.class.getClassLoader().getResourceAsStream("mybatis-config.xlml");

        // 2、通过配置文件输入流对象构建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3、通过会话工厂创建会话对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void findAll() throws IOException {
        // 1、获取配置文件输入流对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // InputStream inputStream = MyBatisTest.class.getClassLoader().getResourceAsStream("mybatis-config.xlml");

        // 2、通过配置文件输入流对象构建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3、通过会话工厂创建会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4、通过会话对象执行数据库的CRUD操作
        String sql = "UserMapper.findAll";
        List<User> userList = sqlSession.selectList(sql);
        for (User user : userList) {
            System.out.println(user);
        }

        // 5、关闭资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void addData() {
        sqlSession.insert("UserMapper.addData");
    }

    @Test
    public void updateData() {
        sqlSession.update("UserMapper.updateData");
    }

    @Test
    public void deleteData() {
        sqlSession.delete("UserMapper.deleteData");
    }

    @Test
    public void findById() {
        User user = sqlSession.selectOne("UserMapper.findById");
        System.out.println(user);
    }

    @Test
    public void addData2() {
        User user = new User();
        user.setName("臣弟阿凯");
        user.setAddr("湖北黄石");
        sqlSession.insert("UserMapper.addData2", user);
    }

    @Test
    public void updateData2() {
        User user = new User();
        user.setId(5);
        user.setName("黄石阿凯");
        sqlSession.update("UserMapper.updateData2", user);
    }

    @Test
    public void deleteData2() {
        sqlSession.delete("UserMapper.deleteData2", 5);
    }

    @Test
    public void findById2() {
        User user = sqlSession.selectOne("UserMapper.findById2", 3);
        System.out.println(user);
    }

    @Test
    public void findByColumn() {
        Map<String, String> map = new HashMap<>();
        map.put("cols", "name,addr");
        List<User> userList = sqlSession.selectList("UserMapper.findByColumn", map);
        for (User user : userList) {
            System.out.println(user.getName() + "-->" + user.getAddr());
        }
    }

    @Test
    public void addData3() {
        User user = new User();
        user.setName("小七");
        user.setAddr("青城山");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addData3(user);
    }

    @Test
    public void updateData3() {
        User user = new User();
        user.setId(6);
        user.setName("xiaoqi");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateData3("小十", 6);
    }

    @Test
    public void deleteData3() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteData3(6);
    }

    @Test
    public void findById3() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(3);
        System.out.println(user);
    }

    @Test
    public void findAll3() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll3();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findAll4() {
        List<User> userList = sqlSession.selectList("UserMapper.findAll4");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getClassesByTeacherId() {
        Classes classes = sqlSession.selectOne("ClassesMapper.getClassesByTeacherId", 2);
        System.out.println(classes);
    }

    @Test
    public void getTeacherByClassesId() {
        Teacher teacher = sqlSession.selectOne("ClassesMapper.getTeacherByClassesId", 1);
        System.out.println(teacher);
    }

    @Test
    public void getClassesByTeacherId2() {
        List<Classes> classes = sqlSession.selectList("ClassesMapper.getClassesByTeacherId2", 1);
        for (Classes aClass : classes) {
            System.out.println(aClass);
        }
    }

    @Test
    public void findAll5() {
        Map<String, Double> map = new HashMap<>();
        map.put("minSalary" , 9000.00);
        map.put("maxSalary", 14000.00);
        List<User> userList = sqlSession.selectList("UserMapper.findAll5", map);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void updateData5() {
        User user = new User();
        user.setId(3);
        user.setName("凯die");
        user.setAddr("湖北武汉");
        user.setSalary(12000.00);
        sqlSession.update("UserMapper.updateData5", user);
    }

    @Test
    public void findAll6() {
        String[] usernames = {"阿凯", "阿凯2"};
        List<User> users = sqlSession.selectList("UserMapper.findAll6", usernames);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
