package com.soft.dao;

import com.soft.model.GarbageOrder;
import com.soft.model.GarbageOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarbageOrderMapper {
    int countByExample(GarbageOrderExample example);

    int deleteByExample(GarbageOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GarbageOrder record);

    int insertSelective(GarbageOrder record);

    List<GarbageOrder> selectByExample(GarbageOrderExample example);

    GarbageOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GarbageOrder record, @Param("example") GarbageOrderExample example);

    int updateByExample(@Param("record") GarbageOrder record, @Param("example") GarbageOrderExample example);

    int updateByPrimaryKeySelective(GarbageOrder record);

    int updateByPrimaryKey(GarbageOrder record);
}