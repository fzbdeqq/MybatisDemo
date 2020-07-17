package com.snail.sakila.model;

import com.snail.sakila.vo.FilmAnnoVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Category {
    private Byte categoryId;

    private String name;

    private Date lastUpdate;

    private List<FilmAnnoVo> filmAnnoVos;

    public Byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Byte categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}