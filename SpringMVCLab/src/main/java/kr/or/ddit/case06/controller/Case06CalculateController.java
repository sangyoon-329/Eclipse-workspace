package kr.or.ddit.case06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/case06/calculate")
public class Case06CalculateController {
//	1. form 으로 연결 : get
	@GetMapping
	public String handler01() {
		return "case06/calForm";
	}
//	2. form-data 처리 : post
	@PostMapping
	public String handler02(
		@RequestParam int op1
		, @RequestParam int op2
		, RedirectAttributes redirectAttributes
	) {
		int result = op1 + op2;
		redirectAttributes.addFlashAttribute("result", result);
		return "redirect:/case06/calculate";
	}
//	3. 연산 결과 : get
	@GetMapping("result")
	public String handler03() {
		
		return "case06/calForm";
	}
}
