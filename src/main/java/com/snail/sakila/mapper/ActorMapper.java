package com.snail.sakila.mapper;

import com.snail.sakila.model.Actor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActorMapper {
    int deleteByPrimaryKey(Short actorId);

    int insert(Actor record);

    Actor selectByPrimaryKey(Short actorId);

    @Select("select * from actor where actor_id = #{actorId}")
    Actor selectByActorId(Short actorId);

    List<Actor> selectAll();

    int updateByPrimaryKey(Actor record);
}