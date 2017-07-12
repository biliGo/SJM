package guo.com.sjm.controller;

import guo.com.sjm.entity.Test;
import guo.com.sjm.service.TestService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {
	
	@Autowired
	private TestService ss;

	@ResponseBody
	@RequestMapping("showtest")
	public List<Test> showTest(){
//		new JsonObject();
		List<Test> list=ss.getList();
		return list;
	}
	
	@RequestMapping("show")
	public ModelAndView Show() {
		ModelAndView mav=new ModelAndView("ee");
		List<Test> list=ss.getList();
		mav.addObject("list", list);
		return mav;	
	}
	
	@RequestMapping("add")
	public String Add(String name) {
		Test test=new Test();
		test.setName(name);
		test.setTime(new Timestamp(new Date().getTime()));
		try {
			ss.addList(test);
			return "redirect:/show.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "hh";
		}
	}
	
	@RequestMapping("update")
	public String Update(String nn,Integer id) {
		Test test=new Test();
		test.setId(id);
		test.setName(nn);
		test.setTime(new Timestamp(new Date().getTime()));
		try {
			ss.updateList(test);
			return "redirect:/show.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "hh";
		}
	}
	
	@RequestMapping("delete_{id}")
	public String Delete(@PathVariable("id") Integer id) {
		//id=Integer.parseInt(request.getParameter("id"));
		try {
			ss.deleteList(id);
			return "redirect:/show.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "hh";
		}
	}

}
