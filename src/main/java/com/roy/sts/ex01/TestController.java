package com.roy.sts.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {

	Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!!";
	}

	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId("zy");
		vo.setPwd("6ft1");
		vo.setName("Zyeighr");
		vo.setEmail("scootergang@bsk.com");
		return vo;
	}

	@RequestMapping("/membersList")
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();

		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("zy" + i);
			vo.setPwd("6ft1" + i);
			vo.setName("Zyeighr" + i);
			vo.setEmail("scootergang@bsk.com" + i);
			list.add(vo);

		}
		return list;
	}

	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap() {

		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("zy" + i);
			vo.setPwd("6ft1" + i);
			vo.setName("Zyeighr" + i);
			vo.setEmail("scootergang@bsk.com");
			map.put(i, vo);
		}
		return map;
	}
	
	@RequestMapping(value="/notice/{num}", method = RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception {
		return num;
	}
	
	@RequestMapping(value="/notice2/{word}", method = RequestMethod.GET)
	public String notice2(@PathVariable("word") String word) throws Exception {
		return word;
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo) {
		logger.info(vo.toString());
	}
	
}
