package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.ex.GoodsEXl;
import com.briup.shopping.mapper.GoodsMapper;
import com.briup.shopping.mapper.ex.GoodsEXlMapper;
import com.briup.shopping.service.IGoodsEXlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsEXlServiceImpl implements IGoodsEXlService {
    @Autowired
    private GoodsEXlMapper goodsEXlMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<GoodsEXl> findAll() throws RuntimeException {
        List<GoodsEXl> list=goodsEXlMapper.findAll();
        return list;
    }

    @Override
    public List<GoodsEXl> findByWord(String word,Integer p1,Integer p2) throws RuntimeException {
        word=word==null ? "":word;
        if ((word==null||"".equals(word))&&(("null".equals(String.valueOf(p1))||"0".equals(String.valueOf(p1))))&&(("null".equals(String.valueOf(p2))||"0".equals(String.valueOf(p2))))){
            return goodsEXlMapper.findAll();

        }
        if (!"".equals(word)&&(("null".equals(String.valueOf(p1))||"0".equals(String.valueOf(p1))))&&(("null".equals(String.valueOf(p2))||"0".equals(String.valueOf(p2))))){
            word="%"+word+"%";
            return goodsEXlMapper.findByKey(word);

        }
        if ((word==null||"".equals(word))&&((!"null".equals(String.valueOf(p1))||!"0".equals(String.valueOf(p1))))&&(("null".equals(String.valueOf(p2))||"0".equals(String.valueOf(p2))))){

            return goodsEXlMapper.findByLowPrice(p1);

        }else if ((word==null||"".equals(word))&&(("null".equals(String.valueOf(p1))||"0".equals(String.valueOf(p1))))&&((!"null".equals(String.valueOf(p2))||!"0".equals(String.valueOf(p2))))){

            return goodsEXlMapper.findByHighPrice(p2);

        }else if ((word==null||"".equals(word))&&((!"null".equals(String.valueOf(p1))||!"0".equals(String.valueOf(p1))))&&((!"null".equals(String.valueOf(p2))||!"0".equals(String.valueOf(p2))))){

            return goodsEXlMapper.findByPrice(p1,p2);

        } else if ((!"".equals(word))&&((!"null".equals(String.valueOf(p1))||!"0".equals(String.valueOf(p1))))&&(("null".equals(String.valueOf(p2))||"0".equals(String.valueOf(p2))))){
            word="%"+word+"%";

            return goodsEXlMapper.findByWlp(word,p1);

        }else if((!"".equals(word))&&(("null".equals(String.valueOf(p1))||"0".equals(String.valueOf(p1))))&&((!"null".equals(String.valueOf(p2))||!"0".equals(String.valueOf(p2))))){
            word="%"+word+"%";

            return goodsEXlMapper.findByWhp(word,p2);

        }else if ((!"".equals(word))&&((!"null".equals(String.valueOf(p1))||!"0".equals(String.valueOf(p1))))&&((!"null".equals(String.valueOf(p2))||!"0".equals(String.valueOf(p2))))){
            word="%"+word+"%";

            return goodsEXlMapper.findByWord(word,p1,p2);
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Goods goods) throws RuntimeException {
        if (goods==null){
            throw new RuntimeException("参数为空");
        }
        if (goods.getId()==null){
            goodsMapper.insert(goods);
        }else {
            goodsMapper.updateByPrimaryKey(goods);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        goodsMapper.deleteByPrimaryKey(id);
    }


}
