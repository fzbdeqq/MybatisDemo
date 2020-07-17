package com.snail;

import com.snail.sakila.mapper.ActorMapper;
import com.snail.sakila.mapper.FilmMapper;
import com.snail.sakila.model.Actor;
import com.snail.sakila.model.Film;
import com.snail.sakila.vo.FilmAnnoVo;
import com.snail.sakila.vo.FilmVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream,"development");
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
        log.info("association");
        actor=actorMapper.selectActorExtendByActorId(actorId);
        log.info(actor.toString());

        //集合
        log.info("collection");
        actor=actorMapper.selectActorFilmByActorId(actorId);
        log.info(actor.toString());


        log.info("动态SQL");
        Actor where=new Actor();
        where.setFirstName("FzbName");
        where.setLastName("GUI");
        actor=actorMapper.selectActorByActor(where);
        log.info(actor.toString());

        log.info("foreach");
        List<Short> actorIds= Arrays.asList((short)1,(short)3,(short)5,(short)7);
//        List<Short> actorIds= Arrays.asList();
        List<Actor> actors=actorMapper.selectActorByActorIds(actorIds);
        log.info(actors.toString());

        //注解
        FilmMapper filmMapper=sqlSession.getMapper(FilmMapper.class);
        short filmId=1;
        FilmAnnoVo filmAnnoVo=filmMapper.selectFilmByFilmId(filmId);
        log.info(filmAnnoVo.toString());
        filmAnnoVo=filmMapper.selectFilmCategoryByFilm(filmId);
        log.info(filmAnnoVo.toString());
    }
}
