package com.snail.sakila.model;

import lombok.Data;

@Data
public class FilmActorKey {
    private Short actorId;

    private Short filmId;

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }
}