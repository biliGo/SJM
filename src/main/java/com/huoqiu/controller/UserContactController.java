package com.huoqiu.controller;

import javax.inject.Inject;


import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.util.JsonResponse;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.huoqiu.entity.UserContact;
import com.huoqiu.service.UserContactService;
import cn.huoqiu.base.web.BaseController;

import java.util.List;

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

//	@RequestMapping("getList")
//	@ResponseBody
//	public List<UserContact> getList(){
//		return  db.all(UserContact.class);
////		return new JsonResponse().set("push",userContactService.findById((long) 1));
//	}


}
