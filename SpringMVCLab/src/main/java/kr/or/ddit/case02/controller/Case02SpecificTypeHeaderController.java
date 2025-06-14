package kr.or.ddit.case02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.ws.rs.ConstrainedTo;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/case02")
@Slf4j
public class Case02SpecificTypeHeaderController {
	@GetMapping("header08")
	public void header08(
			@RequestHeader(value="my-age", required = false, defaultValue = "3") int myAge) {
	}
	/**
	 * "my-flag" 요청 헤더 수신.
	 * 옵셔널 헤더이고, 헤더값으로 true/false만 수신, 생략된 경우, 기본 true만 수신
	 * 
	 */
	@GetMapping("header09")
	public void header09(
		@RequestHeader(value="my-flag", required = false, defaultValue = "true") boolean myFlag) {
		log.info("/case02/header09 수신, my-flag : {}", myFlag);
	}
}
