package com.briup.shopping.mapper;

import com.briup.shopping.bean.GO;
import com.briup.shopping.bean.GOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GOMapper {
    long countByExample(GOExample example);

    int deleteByExample(GOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GO record);

    int insertSelective(GO record);

    List<GO> selectByExample(GOExample example);

    GO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GO record, @Param("example") GOExample example);

    int updateByExample(@Param("record") GO record, @Param("example") GOExample example);

    int updateByPrimaryKeySelective(GO record);

    int updateByPrimaryKey(GO record);
}