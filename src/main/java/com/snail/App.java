package com.snail;

import com.snail.sakila.mapper.ActorMapper;
import com.snail.sakila.model.Actor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{
    public static void main( String[] args ) throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ActorMapper actorMapper= sqlSession.getMapper(ActorMapper.class);

        short id=1;
        Actor actor=actorMapper.selectByPrimaryKey(id);
        log.info(actor.toString());

        id=2;
        Actor actor2=actorMapper.selectByActorId(id);
        log.info(actor2.toString());
    }
}
