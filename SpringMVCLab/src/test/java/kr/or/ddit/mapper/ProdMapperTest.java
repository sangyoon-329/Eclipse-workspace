package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.annotation.RootContextConfig;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@RootContextConfig
@Slf4j
class ProdMapperTest {
	
	@Autowired
	ProdMapper mapper;
		
	@Test
	void testInsertProd() {
		ProdVO pvo = new ProdVO();
		pvo.setProdName("테테테");
		pvo.setLprodGu("P302");
		pvo.setBuyerId("P30201");
		mapper.insertProd(pvo);
	}

	@Test
	void testSelectProdList() {
		mapper.selectProdList();
	}

	@Test
	void testSelectProd() {
		mapper.selectProd("P202000014");
	}

	@Test
	void testUpdateProd() {
		ProdVO pvo = new ProdVO();
		pvo.setProdId("P302000024");
		pvo.setProdPrice(50000);
		mapper.updateProd(pvo);
	}

	@Test
	void testDeleteProd() {
		mapper.deleteProd("P302000024");
	}

}
