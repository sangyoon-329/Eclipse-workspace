package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.annotation.RootContextConfig;
import lombok.extern.slf4j.Slf4j;

@RootContextConfig
@Slf4j
class MemberMapperTest {
	
	@Autowired
	MemberMapper mapper;

	@Test
	void testSelecMember() {
		mapper.selectMember("ddit");
	}

}
