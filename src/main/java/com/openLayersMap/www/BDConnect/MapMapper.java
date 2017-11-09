package com.openLayersMap.www.BDConnect;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MapMapper {


    @Select("INSERT INTO #{table} (coordinates) values(#{coordinates}; SELECT LAST_INSERT_ID();")
    long insertMarker(@Param("table") String type, @Param("coordinates") String coordinates);

    @Select("UPDATE #{table) set coordinates=#{coordinates} where id=#{id}; ")
    void updateMarker(@Param("id") long id, @Param("table") String type,
                      @Param("coordinates") String coordinates);
}
