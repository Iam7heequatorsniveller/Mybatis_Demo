package com.itheima.mybatis.test;

import com.itheima.mybatis.dao.BlogMapper;
import com.itheima.mybatis.dao.UserMapper;
import com.itheima.mybatis.pojo.Blog;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void init() throws Exception {
        // 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlsessionFactory
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void TestFindUserCount() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setUsername("王五");
        int i = userMapper.findUserCount(u);
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void TestFindUserByQueryVo() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("王");
        queryVo.setUser(user);
        List<User> list = userMapper.findUserByQueryVo(queryVo);
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void TestQueryUser() {
        // 获取sqlSession
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询方法
        //User user = userMapper.queryUser(24);
        //System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void TestQueryBlog() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.queryBlog(1);
        System.out.println(blog);
        sqlSession.close();
    }
}

