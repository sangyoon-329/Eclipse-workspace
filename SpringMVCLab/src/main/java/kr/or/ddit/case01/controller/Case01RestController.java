package kr.or.ddit.case01.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 *  /case01/rest/api 로 발생하는 rest 요청에 대한 핸들러 매핑.
 *  CRUD 요청처리 가능해야함.
 *  해당 요청에서 POST/PUT 요청의 경우, body 컨텐츠로 json을 수신함.
 *  
 */
@Controller // 스프링 컨테이너가 빈을 등록하는 조건으로 사용되고, 
// HandlerMapping에 의해 핸들러 메소드의 클래스로 수집됨.
@RequestMapping(value="/case01/rest/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class Case01RestController {
	@GetMapping
	public void rest_get() {
		log.info("get 요청 수신");
	}
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public void rest_post() {
		log.info("post 요청 수신");
	}
	
	@PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public void rest_put() {
		log.info("put 요청 수신");
	}
	
	@DeleteMapping
	public void rest_delete() {
		log.info("delete 요청 수신");
	}
}
