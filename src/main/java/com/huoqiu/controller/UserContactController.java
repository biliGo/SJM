package com.huoqiu.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import cn.huoqiu.base.db.DB;
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
import com.huoqiu.entity.UserContact;
import com.huoqiu.service.UserContactService;
import cn.huoqiu.base.util.JsonResponse;
import cn.huoqiu.base.web.BaseController;

@Controller
@RequestMapping("/user_contacts")
public class UserContactController extends BaseController {

	@Inject
	private UserContactService userContactService;

	@Inject
	private DB db;

	@RequestMapping("getList")
	@ResponseBody
	public JsonResponse getList(){
		return new JsonResponse().set("push",db.all(UserContact.class));
	}

}
