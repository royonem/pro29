package com.roy.sts.bbs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roy.sts.ex01.MemberVO;

@RestController
@RequestMapping("/boards")
public class BoardController {
	
	static Logger logger = LoggerFactory.getLogger(BoardController.class);
       
	// 목록 보기: 2. GET 방식으로 요청하므로 모든 글의 정보를 조회
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleVO>> listArticles() {
		logger.info("listArticles 메서드 호출");
		
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		for (int i = 0; i <10 ; i++) {
			ArticleVO vo = new ArticleVO();
			vo.setArticleNo(i);
			vo.setWriter("scott" + i);
			vo.setTitle("chang's blog" + i);
			vo.setContent("chang is a buff boy" + i);
			list.add(vo);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	// 검색하기: 3. GET 방식으로 요청하면서 글 번호를 전달하므로 글 번호에 대한 글 정보를 조회
	@RequestMapping(value = "/{articleNo}", method = RequestMethod.GET)
	public ResponseEntity<ArticleVO> findArticle(@PathVariable("articleNo") Integer articleNo) {
		logger.info("findArticles 메서드 호출");
		
			ArticleVO vo = new ArticleVO();
			vo.setArticleNo(articleNo);
			vo.setWriter("scott");
			vo.setTitle("chang's blog");
			vo.setContent("chang is a buff boy");

		return new ResponseEntity(vo, HttpStatus.OK);
	}
	

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addArticle(@RequestBody ArticleVO articleVO) {
		
		ResponseEntity<String> resEntity = null;
		
		try {
			logger.info("addArticles 메서드 호출");
			logger.info(articleVO.toString());
			resEntity = new ResponseEntity("ADD_SUCCEEDED", HttpStatus.OK);
			
		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
		return resEntity;
	}
	
	@RequestMapping(value = "/{articleNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNo") Integer articleNo, @RequestBody ArticleVO articleVO) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("call modArticle method");
//			logger.info(articleNo);
			logger.info(articleVO.toString());
			resEntity = new ResponseEntity("MOD_SUCCEEDED", HttpStatus.OK);
			
		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	
	@RequestMapping(value = "/{articleNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle(@PathVariable("articleNo") Integer articleNo) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("call removeArticle method");
			logger.info(articleNo.toString());
//			logger.info(articleNo);
			
			resEntity = new ResponseEntity("REMOVE_SUCCEEDED", HttpStatus.OK);
			
		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
}
