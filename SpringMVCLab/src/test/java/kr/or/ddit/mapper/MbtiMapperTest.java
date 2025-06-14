package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.annotation.RootContextConfig;
import kr.or.ddit.vo.MbtiVO;
import lombok.extern.slf4j.Slf4j;

@RootContextConfig
@Slf4j
class MbtiMapperTest {
	
	@Autowired
	MbtiMapper mapper;

	@Test
	void testInsertMbti() {
		MbtiVO vo = new MbtiVO();
		vo.setMtType("cccc");
		vo.setMtTitle("cccc");
		vo.setMtContent("cccc");
		mapper.insertMbti(vo);
	}

	@Test
	void testSelectMbtiList() {
		mapper.selectMbtiList();
	}

	@Test
	void testSelectMbti() {
		mapper.selectMbti("intp");
	}

	@Test
	void testUpdateMbti() {
		MbtiVO vo = new MbtiVO();
		vo.setMtType("cccc");
		vo.setMtTitle("4444");
		vo.setMtContent("ccc444c");
		mapper.updateMbti(vo);
	}

	@Test
	void testDeleteMbti() {
		mapper.deleteMbti("cccc");
	}

}
