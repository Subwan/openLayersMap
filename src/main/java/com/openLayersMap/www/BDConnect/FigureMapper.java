package com.openLayersMap.www.BDConnect;


import com.openLayersMap.www.Model.Dot;
import com.openLayersMap.www.Model.Figure;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FigureMapper {


    @Select("INSERT INTO map.Figure (type) values(#{type});")
    void insertMarker(@Param("type") String type);

    @Select("SELECT LAST_INSERT_ID();")
    Long getId();

    @Select("INSERT INTO map.Coordinates (lat,lon,fk_figure) values(#{lat}, #{lon}, #{fk});")
    void insertCoordinates(@Param("lat") float lat, @Param("lon") float lon, @Param("fk") float id);

    @ConstructorArgs({
            @Arg(column = "id", javaType = Long.class)
            ,@Arg(column = "lon", javaType = Long.class)
    })
    @Select("SELECT C.id, C.lat, C.lon FROM map.Coordinates C")
    Dot selectById();

    @Select("UPDATE map.Figure set x=#{x}, y=#{y} where id=#{id}; ")
    void updateMarker(@Param("x") float x, @Param("y") float y, @Param("id") long id);

    @ConstructorArgs({
            @Arg(column = "id", javaType = Long.class)
            ,@Arg(column = "type", javaType = String.class)
    })
    @Select("SELECT * FROM Figure; ")
    List<Figure> getAllMarkers();
}
