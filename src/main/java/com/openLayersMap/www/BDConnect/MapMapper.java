package com.openLayersMap.www.BDConnect;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MapMapper {


    @Select("SELECT MAX(ID) FROM #{table};")
    long findId(@Param("table") String type);
}
