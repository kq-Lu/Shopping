package com.briup.shopping.mapper;

import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.bean.ShoppingcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingcarMapper {
    long countByExample(ShoppingcarExample example);

    int deleteByExample(ShoppingcarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    List<Shoppingcar> selectByExample(ShoppingcarExample example);

    Shoppingcar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shoppingcar record, @Param("example") ShoppingcarExample example);

    int updateByExample(@Param("record") Shoppingcar record, @Param("example") ShoppingcarExample example);

    int updateByPrimaryKeySelective(Shoppingcar record);

    int updateByPrimaryKey(Shoppingcar record);
}