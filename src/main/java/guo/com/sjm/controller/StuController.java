package guo.com.sjm.controller;

import cn.huoqiu.base.db.Pagination;
import cn.huoqiu.base.util.JsonResponse;
import cn.huoqiu.base.web.BaseController;
import guo.com.sjm.entity.Stu;
import guo.com.sjm.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/stus")
public class StuController extends BaseController {

    @Inject
    private StuService stuService;

    @ModelAttribute("stu")
    public Stu initStu() {
        return new Stu();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        Pagination<Stu> stus = stuService.search(getQueryForm(request));
        model.addAttribute("stus", stus);
        return "stus/index";
    }

    // new是关键字，用new0代替。
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String new0(Model model) {
        return "stus/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Stu stu, BindingResult result, Model model,
                         RedirectAttributes redirectAttrs) {
        model.addAttribute("stu", stu);
        if (result.hasErrors()) {
            return "stus/new";
        }

        stuService.create(stu);
        redirectAttrs.addFlashAttribute("message", "创建成功!");
        return "redirect:/stus/" + stu.getId();
    }

    @RequestMapping(value = "/{id:^\\d+$}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        Stu stu = stuService.findById(id);
        model.addAttribute("stu", stu);
        return "stus/show";
    }

    @RequestMapping(value = "/{id:^\\d+$}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        Stu stu = stuService.findById(id);
        model.addAttribute("stu", stu);
        return "stus/edit";
    }


    @RequestMapping(value = "/{id:^\\d+$}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    JsonResponse destroy(@PathVariable("id") Long id,
                         RedirectAttributes redirectAttrs) {
        Stu stu = stuService.findById(id);
        stuService.destroy(stu);
        String message = "删除成功!";
        redirectAttrs.addFlashAttribute("message", message);

        return new JsonResponse(true, message);
    }

}
