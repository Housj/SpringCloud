package com.sergei.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sergei.entity.User;
import com.sergei.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String index(){
        return "port="+port;
    }

    @HystrixCommand(fallbackMethod = "findAllError")
    @RequestMapping("/findOrder")
    public String findAll(@RequestParam("userId") Long userId){
//        List<UserAddress> list = userAddressService.findByUser(userId);
//        String a = new String();
//        for (UserAddress u:list){
//            a = a+u.toString();
//        }
//        return a;
        return null;
    }

    public String findAllError(@RequestParam("userId") String userId){
        return "用户"+userId+"未找到";
    }


//    @ResponseBody
//    @RequestMapping("/jian")
//    public String jian(@RequestParam("id") int id){
//        int a = userAddressService.jian(id);
//        return "result="+a;
//    }

//    @RequestMapping("/findByPage")
//    public String findAllByPage(int PageNum,int PageSize){
//        PageInfo<UserAddress> list = userAddressService.findPageByUserId(PageNum,PageSize);
//        String a = new String();
//        for (UserAddress u:list.getList()){
//            a = a+u.toString();
//        }
//        return a;
//    }

    @RequestMapping("/findUserById")
    public User findUserAllByPage(@RequestParam("id")long id){
        return userService.findByUser(id);
    }


    @RequestMapping("/list")
    public String findUserAllByPage(Model model,@RequestParam(value="PageNum",defaultValue = "1")int PageNum,
                                        @RequestParam(value = "PageSize",defaultValue = "5")int PageSize) throws JsonProcessingException {
//        model.addAttribute("users",userService.list());

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userService.list());
//        return userService.list().toString();
    }
    @RequestMapping("/list2")
    public List<User> findUserAllByPage2() throws JsonProcessingException {
        return userService.list();
    }

    @RequestMapping("/user/add")
    public String add(Model model){
        model.addAttribute("user",new User());
        return "add";
    }

    @RequestMapping("/user/update")
    public String update(Model model,@Param(value = "id") Long id){
        User u  = userService.findByUser(id);
        model.addAttribute("user",u);
        return "update";
    }

    @RequestMapping("/user/updateSave")
    public String updateSave(User user){
        userService.updateUser(user);
        return "redirect:/list";
    }

    @RequestMapping("/user/delete")
    public String delete(@Param(value = "id") Long id){
        userService.delete(id);
        return "redirect:/list";
    }

    @RequestMapping("/user/save")
    public String save(User user){
        if (!user.getUserName().isEmpty() && !user.getPassWord().isEmpty()){
           userService.add(user);
        }
        return "redirect:/list";
    }

//    @RequestMapping("/user/login")
//    public String login(User user, @RequestParam(value = "remMe",required = false,defaultValue = "false")boolean remMe, Model model, HttpServletRequest request){
//        remMe = true;
//        // 从SecurityUtils里边创建一个 subject
//        Subject subject = SecurityUtils.getSubject();
//        // 在认证提交前准备 token（令牌）
//        UsernamePasswordToken auth = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
////        User u = userService.findByUser(user.getUserName(),user.getPassWord());
//        try {
//            subject.login(auth);
//            request.getSession().setAttribute("user",(User)SecurityUtils.getSubject().getPrincipal());
//            log.info(user.getUserName()+"登录成功。。。");
//            model.addAttribute("msg","登录成功");
//            return "redirect:/list";
//        }catch (Exception e){
//            e.printStackTrace();
//            model.addAttribute("msg","账号或密码错误");
//            model.addAttribute("user",new User());
//        }
//        return "login";
//    }
//
//    @RequestMapping("/user/out")
//    public String out(HttpServletRequest request,Model model){
//        //获取用户信息
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//
////        User u = (User) request.getSession().getAttribute("user");
////        if (u != null){
////            request.getSession().removeAttribute("user");
////        }
////        model.addAttribute("userName",u.getUserName());
//        log.info("退出。。。");
//        return "out";
//    }
//
//    public static void main(String[] args) {
//        //加密
//        String jiami = new Md5Hash("admin", "sergei",10).toString();
//        System.out.println(jiami);
//        String hashAlgorithmName = "MD5";
//        String credentials = "admin";
//        int hashIterations = 10;
//        ByteSource credentialsSalt = ByteSource.Util.bytes("sergei");
//        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
//        System.out.println(obj);
//    }
}
