package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.POST;
import kr.or.ddit.annotation.RootContextConfig;
import kr.or.ddit.conf.SpringRootContextConfig;
import lombok.extern.slf4j.Slf4j;

@RootContextConfig
@Slf4j
class LprodMapperTest {

	@Autowired
	LprodMapper mapper;
	
	@PostConstruct
	public void init() {		
		log.info("mapper : {}", mapper);
	}
	
	@Test
	void testSelectLprodList() {
		mapper.selectLprodList();
	}

}
