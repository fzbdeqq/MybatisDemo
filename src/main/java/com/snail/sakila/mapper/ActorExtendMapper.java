package com.snail.sakila.mapper;

import com.snail.sakila.model.ActorExtend;

public interface ActorExtendMapper {
    int deleteByPrimaryKey(Short actorId);

    int insert(ActorExtend record);

    int insertSelective(ActorExtend record);

    ActorExtend selectByPrimaryKey(Short actorId);

    int updateByPrimaryKeySelective(ActorExtend record);

    int updateByPrimaryKey(ActorExtend record);
}