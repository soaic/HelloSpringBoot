package com.soaic.hellospringboot.controller;

import com.github.pagehelper.PageHelper;
import com.soaic.hellospringboot.common.PageBean;
import com.soaic.hellospringboot.common.PageModel;
import com.soaic.hellospringboot.common.ResponseResult;
import com.soaic.hellospringboot.entity.MyUser;
import com.soaic.hellospringboot.services.MyUserServices;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MyUserController {

    @Autowired
    private MyUserServices myUserServices;

    @ApiOperation(value="用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult<MyUser> register(String userName, String password) {
        ResponseResult<MyUser> responseResult;
        try {
            MyUser user = new MyUser();
            user.setUserName(userName);
            user.setPassword(password);
            myUserServices.insertUser(user);
            responseResult = new ResponseResult<>(200, "register success!", user);
        } catch (Exception e) {
            responseResult = new ResponseResult<>(501, e.getMessage(), null);
        }
        return responseResult;
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public ResponseResult<PageBean> findAllUser(PageModel pageModel) {
        ResponseResult<PageBean> responseResult;
        try {
            PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
            PageHelper.orderBy("id asc");
            List<MyUser> myUsers = myUserServices.selectUser();
            PageBean<MyUser> pageInfo = new PageBean<>(myUsers);
            responseResult = new ResponseResult<>(200, "success", pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult = new ResponseResult<>(501, "failure", null);
        }
        return responseResult;
    }

    @ApiOperation(value="用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult<MyUser> login(HttpServletRequest request, String userName, String password) {
        ResponseResult<MyUser> responseResult;
        try {
            List<MyUser> myUser = myUserServices.login(userName, password);
            if (myUser != null && myUser.size() > 0) {
                request.getSession(true).setAttribute("user", myUser.get(0));
                responseResult = new ResponseResult<>(200, "login success", myUser.get(0));
            } else {
                responseResult = new ResponseResult<>(501, "login failure: invalid userName or password", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult = new ResponseResult<>(501, "login failure: " + e.getMessage(), null);
        }
        return responseResult;
    }

    @RequestMapping(value="/findUser", method = RequestMethod.GET)
    public ResponseResult<MyUser> findUser(Integer id) {
        ResponseResult<MyUser> responseResult;
        try {
            MyUser myUser = myUserServices.selectUser(id);
            responseResult = new ResponseResult<>(200, "success", myUser);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult = new ResponseResult<>(501, "failure", null);
        }
        return responseResult;
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    public ResponseResult<MyUser> removeUser(Integer id) {
        ResponseResult<MyUser> responseResult;
        try {
            myUserServices.removeUser(id);
            responseResult = new ResponseResult<>(200, "remove success", null);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult = new ResponseResult<>(501, "remove failure", null);
        }
        return responseResult;
    }
}
