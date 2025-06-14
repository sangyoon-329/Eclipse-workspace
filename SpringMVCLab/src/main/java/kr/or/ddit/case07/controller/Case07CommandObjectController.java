package kr.or.ddit.case07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import kr.or.ddit.case07.vo.DummyVO;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * command objet를 이용한 form data 바인딩.
 * 1. form UI 구성
 * 	1) controller 구현
 * 	- GetMapping 핸들러 메소드
 * 	- model attribute 를 전달해야 함.
 * 	  @ModelAttribute 메소드를 구현하고, 모델 객체를 생성 및 반환.
 * 	2) view 구현
 * 	- form 커스텀 태그 사용(modelattribute 속성).
 * 
 * 2. form data 처리.
 * 	1) PostMapping 핸들러 메소드 
 * 	- 핸들러 메소드 아규먼트로 커맨드 오브젝트 사용. : 동시에 모델 속성으로도 저장됨(CoC 반영).
 * 	  @ModelAttribute 로 속성명 변경 가능.
 * 	- 커맨드 오브젝트에 대한 검증
 * 	  @Valid, @Validated(group hint) 와 Errors(BindingResult) 활용
 * 	ex) handlerMethod(@Valid CommandObject co, BindingResult errors)
 * 		주의! 검증 결과는 검증 대상인 커맨드 오브젝트 바로 다음 인자로 받아야 함.
 * 	- 검증 실패시 form UI 로 이동.
 * 	  커맨드 오브젝트와 검증 결과를 모델 속성으로 저장해야 함.
 * 		주의! 검증 결과를 모델 속성으로 저장할 때 사용할 모델명은
 * 			BindingResult.MODEL_KEY_PREFIX+"모델 속성명"; 
 * 
 */
@Slf4j
@Controller
@RequestMapping("/case07")
public class Case07CommandObjectController {
	@ModelAttribute("dummy")
	public DummyVO dummy() {
		log.info("dummy 메소드 실행 및 'dummy' 속성 생성");
		return new DummyVO();
	}
	
	@GetMapping("dummyForm")
	public String formUI() {
		log.info("dummyForm 핸들러 메소드 실행");
		return "case07/form";
	}
	
	// 문자로 전달된 name(필수), 숫자로 전달된 age(옵셔널)
	// 문자들로 전달된 hobbies(옵셔널)
	@RequestMapping("commandObject01")
	public String handler01(@ModelAttribute("dummy") DummyVO dummy) {
		log.info("dummy vo : {}", dummy);
//		model.addAttribute("dummy", dummy);
		return "case07/view01";
	}
	
	@RequestMapping("commandObject02")
	public String handler02(
		@Validated(InsertGroup.class) @ModelAttribute("dummy") DummyVO dummy	
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("dummy", dummy);
			String errorsName = BindingResult.MODEL_KEY_PREFIX+"dummy";
			redirectAttributes.addFlashAttribute(errorsName, errors);
			log.error("검증 실패 : {}", errors);
			errors.getAllErrors().forEach(e-> {
				log.error("{}", e);
			});
			return "redirect:/case07/dummyForm";
		}else {			
			log.info("dummy vo : {}", dummy);
			return "case07/view01";
		}
	}
}
