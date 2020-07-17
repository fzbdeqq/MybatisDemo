package com.snail.sakila.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class FilmAnnoVo {

    private Short filmId;

    private String title;

    private Date releaseYear;

    private String name;

    public FilmAnnoVo(Short filmId, String title) {
        this.filmId = filmId;
        this.title = title;
    }

}
