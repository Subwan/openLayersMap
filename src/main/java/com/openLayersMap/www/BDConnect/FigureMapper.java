package com.openLayersMap.www.BDConnect;


import com.openLayersMap.www.Model.Dot;
import com.openLayersMap.www.Model.Point;
import com.openLayersMap.www.Model.Figure;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FigureMapper {

    @Select("INSERT INTO map.Figure (type) values(#{type});")
    void insertMarker(@Param("type") String type);


    @Select("SELECT LAST_INSERT_ID();")
    Long getId();

    @Select("INSERT INTO map.Coordinates (lat,lon,fk_figure) values(#{lat}, #{lon}, #{fk});")
    void insertCoordinates(@Param("lat") double lat, @Param("lon") double lon, @Param("fk") long id);


    @Select("SELECT lat, lon FROM map.Coordinates  WHERE fk_figure=#{fk};")
        @Results(value = {
                @Result(property = "lat", column = "lat"),
                @Result(property = "lon", column = "lon")
        })
    List<Dot> selectById(@Param("fk") long id);

    @Select("UPDATE map.Coordinates set lat=#{lat}, lon=#{lon} where fk_figure=#{id}; ")
    void updateCoordinates(@Param("lat") double x, @Param("lon") double y, @Param("id") long id);

    @ConstructorArgs({
            @Arg(column = "id", javaType = Long.class)
            ,@Arg(column = "type", javaType = String.class)
    })
    @Select("SELECT * FROM Figure; ")
    List<Figure> getAllMarkers();
}
