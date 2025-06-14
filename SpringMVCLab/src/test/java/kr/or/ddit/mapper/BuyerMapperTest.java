package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.annotation.RootContextConfig;
import kr.or.ddit.conf.SpringRootContextConfig;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(classes = SpringRootContextConfig.class)
@RootContextConfig
class BuyerMapperTest {
	
	@Autowired
	BuyerMapper mapper;

	@Test
	void testSelectBuyer() {
		mapper.selectBuyer("P10106");
	}

	@Test
	void testSelectBuyerList() {
		mapper.selectBuyerList();
	}

	@Test
	void testInsertBuyer() {
		BuyerVO vo = new BuyerVO();
		vo.setBuyerName("신규제조사");
		vo.setLprodGu("P101");
		vo.setBuyerBank("하나");
		vo.setBuyerBankname("계좌주");
		vo.setBuyerBankno("888888");
		vo.setBuyerComtel("000-000-0000");
		vo.setBuyerMail("ddit.or.kr");
		vo.setBuyerCharger("담당");
		assertEquals(1, mapper.insertBuyer(vo));
	}

	@Test
	void testUpdateBuyer() {
		fail("Not yet implemented");
	}

}
