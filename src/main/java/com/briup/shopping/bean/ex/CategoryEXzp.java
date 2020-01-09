package com.briup.shopping.bean.ex;

import java.io.Serializable;
import java.util.List;

public class CategoryEXzp implements Serializable {
    private Integer id;

    private String name;

    private String description;

    List<GoodsEXzp2> goodsEXzp1List;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GoodsEXzp2> getGoodsEXzp1List() {
        return goodsEXzp1List;
    }

    public void setGoodsEXzp1List(List<GoodsEXzp2> goodsEXzp1List) {
        this.goodsEXzp1List = goodsEXzp1List;
    }
}
