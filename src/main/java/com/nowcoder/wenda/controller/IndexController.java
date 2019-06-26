package com.nowcoder.wenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {


    @RequestMapping(path={"/", "/index"})
    @ResponseBody
    public String index(){
        return "Hello wjh";
    }

    @RequestMapping(path={"/profile/{groupId}/{userId}"}) //解析变量userId,groupId
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId,
                          @RequestParam(value = "type",defaultValue = "1",required = false) int type, //请求参数
                          @RequestParam(value = "key",defaultValue = "zz",required = false) String key){
        return String.format("Profile Page of %s / %d, t: %d k : %s",groupId, userId,type,key);
    }

    @RequestMapping(path={"/vm"},method=RequestMethod.GET)
    public String template(Model model){//Model为ui类
        model.addAttribute("value1","vvvvv1");
        return "home";  //返回home模版文件(Thymeleaf)
    }


}
