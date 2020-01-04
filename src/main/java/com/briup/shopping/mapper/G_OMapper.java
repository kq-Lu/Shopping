package com.briup.shopping.mapper;

import com.briup.shopping.bean.G_O;
import com.briup.shopping.bean.G_OExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface G_OMapper {
    long countByExample(G_OExample example);

    int deleteByExample(G_OExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(G_O record);

    int insertSelective(G_O record);

    List<G_O> selectByExample(G_OExample example);

    G_O selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") G_O record, @Param("example") G_OExample example);

    int updateByExample(@Param("record") G_O record, @Param("example") G_OExample example);

    int updateByPrimaryKeySelective(G_O record);

    int updateByPrimaryKey(G_O record);
}