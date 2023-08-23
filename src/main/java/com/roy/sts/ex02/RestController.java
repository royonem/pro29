package com.roy.sts.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/rest3")
	public ResponseEntity rest3() {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message = "<script>";
		message += " alert ('new user registered 한국어');";
		message += " location.href='/sts/test/membersList2';";
		message += " </script>";
		return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	}
	
}
