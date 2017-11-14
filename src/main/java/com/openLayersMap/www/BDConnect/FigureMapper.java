package com.openLayersMap.www.BDConnect;


import com.openLayersMap.www.Model.Figure;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FigureMapper {

    @Select("INSERT INTO map.Figure (coordinates) values(#{coordinates});")
    void insertFigure(@Param("coordinates") String coordinates);


    @Select("SELECT LAST_INSERT_ID();")
    Long getId();


    @Select("UPDATE map.Figure set coordinates=#{coordinates} where id =#{id}; ")
    void updateCoordinates(@Param("coordinates") String coordinates, @Param("id") long id);


    @ConstructorArgs({
            @Arg(column = "id", javaType = Long.class)
            ,@Arg(column = "type", javaType = String.class)
    })
    @Select("SELECT * FROM Figure; ")
    List<Figure> getAllMarkers();


    @Select("delete from map.Figure where id= #{id};")
    void deleteFigure(@Param("id") long id);
}
