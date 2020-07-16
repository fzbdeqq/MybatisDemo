package com.snail.sakila.mapper;

import com.snail.sakila.model.Actor;
import org.apache.ibatis.annotations.Select;

public interface ActorMapper {

    int deleteByPrimaryKey(Short actorId);

    int insert(Actor record);

    int insertSelective(Actor record);

    Actor selectByPrimaryKey(Short actorId);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);

    @Select("select * from actor where actor_id=#{actorId}")
    Actor selectByActorId(short actorId);

    Actor selectActorFilmByActorId(short actorId);
}