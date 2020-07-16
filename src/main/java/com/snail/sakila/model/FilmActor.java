package com.snail.sakila.model;

import lombok.Data;

import java.util.Date;
@Data
public class FilmActor extends FilmActorKey {
    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}