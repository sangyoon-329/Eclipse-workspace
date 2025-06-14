package kr.or.ddit.case05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/case05")
@Slf4j
public class Case05RedirectController {
	@GetMapping("start02")
	public String start02(RedirectAttributes redirectAttributes) {
		// RPG pattern
		redirectAttributes.addFlashAttribute("modelInfo", "전달 데이터");
		return "redirect:/case05/dest02";
	}
	//addFlashAttribute -> FlashMap에 데이터 저장
	// --> redirect
	// Model 생성 -> FlashMap에 데이터 저장되어 있는 flash attribute --> Model로 이동
	// --> flash attribute 삭제
	@GetMapping("dest02")
	public String dest02(Model modelInfo) {
		if(modelInfo.containsAttribute("modelInfo")) {
			log.info("model : {}", modelInfo.getAttribute("modelInfo"));
		}
		return "case05/view01";
	}
}	
