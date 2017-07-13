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
import com.huoqiu.entity.Dept;
import com.huoqiu.service.DeptService;
import cn.huoqiu.base.util.JsonResponse;
import cn.huoqiu.base.web.BaseController;

@Controller
@RequestMapping("/depts")
public class DeptController extends BaseController {

	@Inject
	private DeptService deptService;

	@ModelAttribute("dept")
	public Dept initDept() {
		return new Dept();
	}


}
