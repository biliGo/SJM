package com.huoqiu.controller;

import javax.inject.Inject;


import cn.huoqiu.base.db.DB;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
		return  new JsonResponse().set("push",db.all(UserContact.class));
//		return new JsonResponse().set("push",userContactService.findById((long) 1));
	}

}
