package com.snail.sakila;

import com.snail.sakila.mapper.DatabaseIdMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
@Slf4j
public class DatabaseIdApp {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development");
        SqlSession sqlSession = sqlSessionFactory.openSession();

        log.info("DatabaseId Mapper Test");
        DatabaseIdMapper databaseIdMapper = sqlSession.getMapper(DatabaseIdMapper.class);

        String time=databaseIdMapper.getTime();
        log.info("time:{}",time);
    }
}
