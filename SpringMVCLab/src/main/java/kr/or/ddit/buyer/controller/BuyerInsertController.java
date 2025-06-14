package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.ViewResolverComposite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.BuyerVO;

/**
 *   /buyer/buyerInsert.do (GET, POST)
 */
@Controller
@RequestMapping("/buyer/buyerInsert.do")
public class BuyerInsertController {
	@Autowired
	private BuyerService service;
	static final String MODELNAME = "buyer";
	
	@ModelAttribute(MODELNAME)
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	/**
	 * 등록 form 제공
	 */
	@GetMapping
	public String formUI(){
		return "buyer/buyerForm";
	}
	
	/**
	 * form으로 입력받은 데이터 처리
	 */
	@PostMapping
	public String formHandler(
		@Validated(InsertGroup.class) @ModelAttribute(MODELNAME) BuyerVO buyer
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute(MODELNAME, buyer);
			String errorNames = BindingResult.MODEL_KEY_PREFIX+MODELNAME;
			redirectAttributes.addFlashAttribute(errorNames, errors);
			return "redirect:/buyer/buyerInsert.do";
		}else {
			service.createBuyer(buyer);
			return "redirect:/buyer/buyerList.do";
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BuyerVO buyer = new BuyerVO();
//		try {
//			BeanUtils.populate(buyer, req.getParameterMap());
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			throw new ServletException(e);
//		}
////		3. BuyerVO(Command Object)가 검증 대상
////		Map<String, String> errors = new HashMap<String, String>();
////		boolean validate = validate(buyer, errors);
//		
//		Map<String, String> errors = ValidateUtils.validate(buyer, InsertGroup.class);
//		
//		String lvn;
//		if(errors.isEmpty()) {
//			service.createBuyer(buyer);
//			// PRG 패턴
//			lvn = "redirect:/buyer/buyerList.do";
//		}else {
//			HttpSession session =  req.getSession();
//			session.setAttribute("buyer", buyer);
//			session.setAttribute("errors", errors);
//			lvn = "redirect:/buyer/buyerInsert.do";
//		}
//		new ViewResolverComposite().resolveView(lvn, req, resp);
//	}

	
}
