package com.snail.sakila.model;

import com.snail.sakila.vo.FilmVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Actor {
    private Short actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;

    private List<FilmVo> films;

    private ActorExtend actorExtend;

}