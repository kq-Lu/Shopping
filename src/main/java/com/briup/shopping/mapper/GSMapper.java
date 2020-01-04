package com.briup.shopping.mapper;

import com.briup.shopping.bean.GS;
import com.briup.shopping.bean.GSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GSMapper {
    long countByExample(GSExample example);

    int deleteByExample(GSExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GS record);

    int insertSelective(GS record);

    List<GS> selectByExample(GSExample example);

    GS selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GS record, @Param("example") GSExample example);

    int updateByExample(@Param("record") GS record, @Param("example") GSExample example);

    int updateByPrimaryKeySelective(GS record);

    int updateByPrimaryKey(GS record);
}