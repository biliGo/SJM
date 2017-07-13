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
import com.huoqiu.entity.User;
import com.huoqiu.service.UserService;
import cn.huoqiu.base.util.JsonResponse;
import cn.huoqiu.base.web.BaseController;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

	@Inject
	private UserService userService;

	@ModelAttribute("user")
	public User initUser() {
		return new User();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		Pagination<User> users = userService.search(getQueryForm(request));
		model.addAttribute("users", users);
		return "users/index";
	}

	// new是关键字，用new0代替。
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String new0(Model model) {
		return "users/new";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "users/new";
		}

		userService.create(user);
		redirectAttrs.addFlashAttribute("message", "创建成功!");
		return "redirect:/users/" + user.getId();
	}

	@RequestMapping(value = "/{id:^\\d+$}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "users/show";
	}

	@RequestMapping(value = "/{id:^\\d+$}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "users/edit";
	}


	@RequestMapping(value = "/{id:^\\d+$}", method = RequestMethod.DELETE)
	public @ResponseBody
	JsonResponse destroy(@PathVariable("id") Long id,
			RedirectAttributes redirectAttrs) {
		User user = userService.findById(id);
		userService.destroy(user);
		String message = "删除成功!";
		redirectAttrs.addFlashAttribute("message", message);

		return new JsonResponse(true, message);
	}

}
