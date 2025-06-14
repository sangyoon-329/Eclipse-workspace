package kr.or.ddit.case08.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.case08.vo.NativeJavaVO;

/**
 * RestFul URI
 * 명사(URI) + 동사(method)
 *  /case08/dummy + GET
 *  /case08/dummy/pk1 + GET
 *  /case08/dummy + POST
 *  /cse08/dummy/{} + DELETE
 */
@RestController
@RequestMapping("/case08/dummy")
public class Case08RestApiController {
	private Map<String, NativeJavaVO> dummyDB;
	{
		dummyDB = new HashMap<>();
		NativeJavaVO njv1 = new NativeJavaVO();
		dummyDB.put("pk1", njv1);
		njv1.setCode("pk1");
		njv1.setProp1("문자열");
		njv1.setProp2(23);
		njv1.setProp3(new String[] {"v1", "v2"});
		NativeJavaVO njv2 = new NativeJavaVO();
		dummyDB.put("pk2", njv2);
		njv2.setCode("pk2");
		njv2.setProp1("텍스트");
		njv2.setProp2(36);
		njv2.setProp3(new String[] {"v3", "v4"});
	}
	@GetMapping
	public List<NativeJavaVO> restGet() {
		return new ArrayList<>(dummyDB.values());
	}
	
	@GetMapping("{key}")
	public NativeJavaVO restGetOne(@PathVariable String key) {
		NativeJavaVO target = dummyDB.get(key);
		if(target==null) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404));
		}
		return target;
	}
	@PostMapping
	public NativeJavaVO create(@RequestBody NativeJavaVO njv) {
		String newPk = "pk" + dummyDB.size() + 10;
		njv.setCode(newPk);
		dummyDB.put(newPk, njv);
		return njv;
	}
	
	@PutMapping("{key}")
	public  Map<String, Object> modify(
		@PathVariable String key, @RequestBody NativeJavaVO njv
	) {
		dummyDB.put(key, njv);
		return Map.of("success", true, "target", njv);
	}
	
	@DeleteMapping("{key}")
	public Map<String, Object> restDelete(@PathVariable String key) {
		NativeJavaVO target = dummyDB.remove(key);
		return Map.of("success", true, "target", target);
	}
}
