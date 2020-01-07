package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Customer;
import com.briup.shopping.service.ILoginService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Api(description = "登陆注册")
@RequestMapping(value = "Login")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @GetMapping("/login")
    @ApiOperation(value = "登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "username",value = "用户名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",paramType = "query",dataType = "String")})
    public Message login(String username,String password){
        if (("".equals(username)||username==null)&&("".equals(password)||password==null)){
            return MessageUtil.success("请输入用户名和密码");
        }else if (("".equals(username)||username==null)&&(!"".equals(password)||password!=null)){
            return MessageUtil.success("请输入用户名");
        }else if ((!"".equals(username)||username!=null)&&("".equals(password)||password==null)){
            return MessageUtil.success("请输入密码");
        } else if (!"".equals(username)&&!"".equals(password)){
            if (iLoginService.login(username,password)!=null){
                return MessageUtil.success("登陆成功");
            }else if (iLoginService.login(username,password)==null){
                return MessageUtil.success("不存在该用户");
            }
        }
        return MessageUtil.success("bbbbbb");
    }



    @PostMapping("/insert")
    @ApiOperation(value = "注册")
    public Message insert(String username,String password,int phone,String address){
        iLoginService.insert(username, password, phone, address);
        return MessageUtil.success("注册成功");
    }
}
