package com.briup.shopping.mapper;

import com.briup.shopping.bean.Go_Sh;
import com.briup.shopping.bean.Go_ShExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Go_ShMapper {
    long countByExample(Go_ShExample example);

    int deleteByExample(Go_ShExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Go_Sh record);

    int insertSelective(Go_Sh record);

    List<Go_Sh> selectByExample(Go_ShExample example);

    Go_Sh selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Go_Sh record, @Param("example") Go_ShExample example);

    int updateByExample(@Param("record") Go_Sh record, @Param("example") Go_ShExample example);

    int updateByPrimaryKeySelective(Go_Sh record);

    int updateByPrimaryKey(Go_Sh record);
}