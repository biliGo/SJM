package guo.com.sjm.controller;

import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.util.JsonResponse;
import cn.huoqiu.base.web.BaseController;
import guo.com.sjm.entity.Dept;
import guo.com.sjm.entity.Test;
import guo.com.sjm.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/depts")
public class DeptController extends BaseController {

    @Inject
    private DeptService deptService;

    @Inject
    private DB db;


    @RequestMapping("suisuisui")
    @ResponseBody
    public JsonResponse destroy() {
        Dept dept = deptService.findById(1001L);
        return new JsonResponse().set("dddd", dept);
    }


    @RequestMapping("ss")
    @ResponseBody
    public Dept ssss() {
        return deptService.findById(1001L);
    }


    @RequestMapping("list")
    @ResponseBody
    public JsonResponse aaa() {
        return new JsonResponse().set("dddd", db.all(Test.class));
    }


    @RequestMapping("list2")
    @ResponseBody
    public List ssssss() {
        return db.all(Test.class);
    }

}
