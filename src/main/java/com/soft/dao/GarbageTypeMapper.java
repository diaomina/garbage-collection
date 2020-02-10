package com.soft.dao;

import com.soft.model.GarbageType;
import com.soft.model.GarbageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarbageTypeMapper {
    int countByExample(GarbageTypeExample example);

    int deleteByExample(GarbageTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GarbageType record);

    int insertSelective(GarbageType record);

    List<GarbageType> selectByExample(GarbageTypeExample example);

    GarbageType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GarbageType record, @Param("example") GarbageTypeExample example);

    int updateByExample(@Param("record") GarbageType record, @Param("example") GarbageTypeExample example);

    int updateByPrimaryKeySelective(GarbageType record);

    int updateByPrimaryKey(GarbageType record);
}