package com.soft.dao;

import com.soft.model.ChildOrder;
import com.soft.model.ChildOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildOrderMapper {
    int countByExample(ChildOrderExample example);

    int deleteByExample(ChildOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChildOrder record);

    int insertSelective(ChildOrder record);

    List<ChildOrder> selectByExample(ChildOrderExample example);

    ChildOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChildOrder record, @Param("example") ChildOrderExample example);

    int updateByExample(@Param("record") ChildOrder record, @Param("example") ChildOrderExample example);

    int updateByPrimaryKeySelective(ChildOrder record);

    int updateByPrimaryKey(ChildOrder record);
}