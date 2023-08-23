package com.roy.sts.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestController {

	@RequestMapping(value = "/rest1")
	@ResponseBody
	public Map<String, Object> rest1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "roy");
		return map;
	}
	
	@RequestMapping(value ="/rest2")
	public ModelAndView rest2() {
		return new ModelAndView("JSONTest");
	}
	
}
