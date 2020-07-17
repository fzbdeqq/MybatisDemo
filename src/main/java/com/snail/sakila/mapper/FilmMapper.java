package com.snail.sakila.mapper;

import com.snail.sakila.model.Film;
import com.snail.sakila.vo.FilmAnnoVo;
import com.snail.sakila.vo.FilmVo;
import org.apache.ibatis.annotations.*;

public interface FilmMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    int insertSelective(Film record);

    Film selectByPrimaryKey(Short filmId);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);

    @Results(id="filmBaseResult",value = {
//            @Result(property = "filmId",column = "film_id"),
//            @Result(property = "title",column = "title"),
            @Result(property = "release_year",column = "releaseYear")
    })
    @ConstructorArgs({
            @Arg(column = "film_id",javaType = Short.class,id = true),
            @Arg(column = "title",javaType = String.class)
    })
    @Select("select film_id,title,release_year from film where film_id=#{filmId}")
    FilmAnnoVo selectFilmByFilmId(short filmId);



    @Select("SELECT film.film_id,film.title,category.name from film\n" +
            "INNER JOIN film_category on film.film_id=film_category.film_id\n" +
            "INNER JOIN category on film_category.category_id=category.category_id\n" +
            "where film.film_id=#{filmId};")
    FilmAnnoVo selectFilmCategoryByFilm(short filmId);
}