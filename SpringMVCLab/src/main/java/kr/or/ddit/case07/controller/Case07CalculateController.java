package kr.or.ddit.case07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import kr.or.ddit.case07.vo.CalculateVO;

/**
 * 피연산자 두개를 입력받고, 더하기 연산의 결과를 생성함.
 * 두개의 피연산자는 모두 양의 정수로 가정함.
 * 커맨드 오브젝트와 스프링의 객체 검증 모델(BindingResult 사용)을 사용함.
 * form UI는 form 커스텀 태그 사용.
 */
@Controller
@RequestMapping("/case07/calculate")
public class Case07CalculateController {
	static final String MODELNAME = "cal";
	
	@ModelAttribute(MODELNAME)
	public CalculateVO calculate() {
		return new CalculateVO();
	}
	
	@GetMapping
	public void formUI() {
//		return "case07/calculate";
	}
	@PostMapping
	public String formHandler(
		@Valid @ModelAttribute(MODELNAME) CalculateVO calculate
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		redirectAttributes.addFlashAttribute(MODELNAME, calculate);
		if(errors.hasErrors()) {
			String errorsName = BindingResult.MODEL_KEY_PREFIX+MODELNAME;
			redirectAttributes.addFlashAttribute(errorsName, errors);
		}else {
			calculate.setResult(calculate.getOp1() + calculate.getOp2());
		}
		return "redirect:/case07/calculate";
	}
}
