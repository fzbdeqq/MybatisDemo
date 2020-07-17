package com.snail.sakila.mapper;

import com.snail.sakila.model.Category;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {
    int deleteByPrimaryKey(Byte categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Byte categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

//    @Results(id = "categoryFilmResult",value = {
//            @Result(column = "category_id",property = "categoryId"),
//            @Result(column = "name",property = "name"),
//            @Result(property = "filmAnnoVos",many = @Many(columnPrefix = "film"))
//    })
//    @Select("SELECT category.category_id,category.name,film.film_id,film.title film_title from film\n" +
//            "INNER JOIN film_category on film.film_id=film_category.film_id\n" +
//            "INNER JOIN category on film_category.category_id=category.category_id\n" +
//            "where category.category_id = #{categoryId};")
    Category selectCategoryFilmByCategoryId(short categoryId);
}