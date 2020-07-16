package com.snail.sakila.mapper;

import com.snail.sakila.model.FilmActor;
import com.snail.sakila.model.FilmActorKey;

public interface FilmActorMapper {
    int deleteByPrimaryKey(FilmActorKey key);

    int insert(FilmActor record);

    int insertSelective(FilmActor record);

    FilmActor selectByPrimaryKey(FilmActorKey key);

    int updateByPrimaryKeySelective(FilmActor record);

    int updateByPrimaryKey(FilmActor record);
}