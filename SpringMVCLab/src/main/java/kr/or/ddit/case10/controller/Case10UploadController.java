package kr.or.ddit.case10.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import kr.or.ddit.case10.vo.DummyFileVO;
import kr.or.ddit.validate.utils.ErrorsUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case10/upload")
public class Case10UploadController {
	@Autowired
	private ErrorsUtils errorsUtils;
	
	@Value("${dummyUpload}")
	private Resource saveRes;
	
	@GetMapping
	public String formUI(Model model) {
		return "case10/uploadForm";
	}
	
	@PostMapping
	public String formProcess2(
		@Valid @ModelAttribute("dummyFile") DummyFileVO dummyFile
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) throws IOException {
		if(errors.hasErrors()) {
			Map<String, List<String>> customErrors = errorsUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);
		}else {
			
			MultipartFile other = dummyFile.getUploadFile();
			String mime = other.getContentType();
			if(!mime.startsWith("image/")) {
				throw new ResponseStatusException(HttpStatusCode.valueOf(400));
			}
			String originalName = other.getOriginalFilename();
			String saveName = System.currentTimeMillis()+"_" + originalName;
			
			File saveFolder = saveRes.getFile();
			File saveFile = new File(saveFolder, saveName);
			
			other.transferTo(saveFile);
			
			log.info("uploader : {}", dummyFile.getUploader());
			log.info("uploadFile : {}", other);
			
			redirectAttributes.addFlashAttribute("saveName", saveName);
		}
		
		return "redirect:/case10/upload";
	}
	
//	@PostMapping
	public String formProcess(
		@RequestParam String uploader
		, @RequestPart(name ="uploadFile") MultipartFile other
		, RedirectAttributes redirectAttributes
	) throws IOException {
		if(other.isEmpty()) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(400));
		}
		String mime = other.getContentType();
		if(!mime.startsWith("image/")) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(400));
		}
		String originalName = other.getOriginalFilename();
		String saveName = System.currentTimeMillis()+"_" + originalName;
		
		File saveFolder = saveRes.getFile();
		File saveFile = new File(saveFolder, saveName);
		
		other.transferTo(saveFile);
		
		log.info("uploader : {}", uploader);
		log.info("uploadFile : {}", other);
		
		redirectAttributes.addFlashAttribute("saveName", saveName);
		return "redirect:/case10/upload";
	}
}
