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

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}