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

        short actorId=1;
        Actor actor=actorMapper.selectByPrimaryKey(actorId);
        log.info(actor.toString());

        actor.setFirstName("FzbName");
        actorMapper.updateByPrimaryKey(actor);

        actorId=1;
        actor=actorMapper.selectByPrimaryKey(actorId);
        log.info(actor.toString());
//        二级缓存
        log.info("二级缓存");
        actor=actorMapper.selectByPrimaryKey(actorId);
        log.info(actor.toString());

        actorId=2;
        actor=actorMapper.selectByActorId(actorId);
        log.info(actor.toString());

        //关联
        //集合
        actor=actorMapper.selectActorFilmByActorId(actorId);
        log.info(actor.toString());

    }
}
