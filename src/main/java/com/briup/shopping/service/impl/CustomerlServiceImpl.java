package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Customer;
import com.briup.shopping.mapper.CustomerMapper;
import com.briup.shopping.mapper.ex.CustomerlMapper;
import com.briup.shopping.service.ICustomerlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerlServiceImpl implements ICustomerlService {
    @Autowired
    private CustomerlMapper customerlMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Customer> findAll() throws RuntimeException {
        List<Customer> list=customerlMapper.findAll();
        return list;
    }

    @Override
    public List<Customer> search(String word, String phone) throws RuntimeException {
        word=word==null ? "":word;
        phone=phone==null ? "":phone;
        if ((word==null||"".equals(word))&&(phone==null||"".equals(phone))){

            return customerlMapper.findAll();
        }
        if((!"".equals(word))&&(phone==null||"".equals(phone))){
            word="%"+word+"%";

            return customerlMapper.selectByWord(word);
        }

        if ((word==null||"".equals(word))&&(!"".equals(phone))){

            if (phone.length()!=4){
                throw new RuntimeException("请输入电话号码后四位");

            }else {

                phone = "%" + phone;
                return customerlMapper.selectByPhone(phone);
            }
        }
        else if ((!"".equals(word))&&(!"".equals(phone))){

            if (phone.length()!=4){
                throw new RuntimeException("请输入电话号码后四位");

            }else {

                word = "%" + word + "%";
                phone = "%" + phone;

                return customerlMapper.search(word, phone);
            }
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Customer customer) throws RuntimeException {
        if (customer==null){
            throw new RuntimeException("参数为空");
        }
        if (customer.getId()==null){
            customerMapper.insert(customer);
        }else {
            customerMapper.updateByPrimaryKey(customer);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Customer> findByAddress(String key) throws RuntimeException {
        key=key==null ? "":key;
        if (key==null||"".equals(key)){

            throw new RuntimeException("请填入省份名称");

        }else if ("陕西".equals(key)||"山西".equals(key)||"河北".equals(key)||"辽宁".equals(key)||"吉林".equals(key)||"黑龙江".equals(key)||"江苏".equals(key)
        ||"浙江".equals(key)||"安徽".equals(key)||"福建".equals(key)||"山东".equals(key)||"江西".equals(key)||"湖北".equals(key)||"河南".equals(key)||
        "湖南".equals(key)||"海南".equals(key)||"广东".equals(key)||"四川".equals(key)||"云南".equals(key)||"贵州".equals(key)||"青海".equals(key)
        ||"甘肃".equals(key)||"台湾".equals(key)||"广西".equals(key)||"内蒙古".equals(key)||"新疆".equals(key)||"宁夏".equals(key)||"西藏".equals(key)
        ||"北京".equals(key)||"上海".equals(key)||"重庆".equals(key)||"天津".equals(key)||"香港".equals(key)||"澳门".equals(key)
        ||"陕西省".equals(key)||"山西省".equals(key)||"河北省".equals(key)||"辽宁省".equals(key)||"吉林省".equals(key)||"黑龙江省".equals(key)||"江苏省".equals(key)
                ||"浙江省".equals(key)||"安徽省".equals(key)||"福建省".equals(key)||"山东省".equals(key)||"江西省".equals(key)||"湖北省".equals(key)||"河南省".equals(key)||
                "湖南省".equals(key)||"海南省".equals(key)||"广东省".equals(key)||"四川省".equals(key)||"云南省".equals(key)||"贵州省".equals(key)||"青海省".equals(key)
                ||"甘肃省".equals(key)||"台湾省".equals(key)||"广西壮族自治区".equals(key)||"内蒙古自治区".equals(key)||"新疆维吾尔族自治区".equals(key)||"宁夏回族自治区".equals(key)||"西藏自治区".equals(key)
                ||"北京市".equals(key)||"上海市".equals(key)||"重庆市".equals(key)||"天津市".equals(key)||"香港特别行政区".equals(key)||"澳门特别行政区".equals(key)){

            key= key+"%";

            return customerlMapper.findByAddress(key);
        }else {
            throw new RuntimeException("请输入省份名称");



        }

    }
}
