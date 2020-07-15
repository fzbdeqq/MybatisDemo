package com.snail;

import static org.junit.Assert.assertTrue;

import com.snail.sakila.mapper.ActorMapper;
import com.snail.sakila.model.Actor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String resource="mybatis-config.xml";
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ActorMapper actorMapper= sqlSession.getMapper(ActorMapper.class);

        short id=1;
        Actor actor=actorMapper.selectByPrimaryKey(id);
        System.out.println(actor.toString());
        log.info(actor.toString());
    }
}
