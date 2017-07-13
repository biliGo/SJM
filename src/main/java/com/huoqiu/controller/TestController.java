package com.huoqiu.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.huoqiu.base.db.Pagination;
import com.huoqiu.entity.Test;
import com.huoqiu.service.TestService;
import cn.huoqiu.base.util.JsonResponse;
import cn.huoqiu.base.web.BaseController;

@Controller
@RequestMapping("/tests")
public class TestController extends BaseController {

	@Inject
	private TestService testService;

	@ModelAttribute("test")
	public Test initTest() {
		return new Test();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		Pagination<Test> tests = testService.search(getQueryForm(request));
		model.addAttribute("tests", tests);
		return "tests/index";
	}

	// new是关键字，用new0代替。
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String new0(Model model) {
		return "tests/new";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Test test, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		model.addAttribute("test", test);
		if (result.hasErrors()) {
			return "tests/new";
		}

		testService.create(test);
		redirectAttrs.addFlashAttribute("message", "创建成功!");
		return "redirect:/tests/" + test.getId();
	}

	@RequestMapping(value = "/{id:^\\d+$}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Test test = testService.findById(id);
		model.addAttribute("test", test);
		return "tests/show";
	}

	@RequestMapping(value = "/{id:^\\d+$}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Test test = testService.findById(id);
		model.addAttribute("test", test);
		return "tests/edit";
	}


	@RequestMapping(value = "/{id:^\\d+$}", method = RequestMethod.DELETE)
	public @ResponseBody
	JsonResponse destroy(@PathVariable("id") Long id,
			RedirectAttributes redirectAttrs) {
		Test test = testService.findById(id);
		testService.destroy(test);
		String message = "删除成功!";
		redirectAttrs.addFlashAttribute("message", message);

		return new JsonResponse(true, message);
	}

}
