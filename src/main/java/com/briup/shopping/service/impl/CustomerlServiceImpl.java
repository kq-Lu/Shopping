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
}
