package com.openLayersMap.www.BDConnect;


import com.openLayersMap.www.Model.Dot;
import com.openLayersMap.www.Model.Line;
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

    @Select("Select Coordinates.id from map.Coordinates where fk_figure=#{id} LIMIT #{idPoint}, 1;")
    Long getFK (@Param("id") long id, @Param("idPoint") long idPoint);

    @Select("UPDATE map.Coordinates set lat=#{lat}, lon=#{lon} where id =#{id}; ")
    void updateCoordinates(@Param("lat") double x, @Param("lon") double y, @Param("id") long id);

    @Select("UPDATE map.Coordinates set lat=#{lat}, lon=#{lon} where fk_figure=#{id}; ")
    void updatePoint(@Param("lat") double x, @Param("lon") double y, @Param("id") long id);

    @ConstructorArgs({
            @Arg(column = "id", javaType = Long.class)
            ,@Arg(column = "type", javaType = String.class)
    })
    @Select("SELECT * FROM Figure; ")
    List<Line> getAllMarkers();
}
