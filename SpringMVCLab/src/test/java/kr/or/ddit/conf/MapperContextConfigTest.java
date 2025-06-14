package kr.or.ddit.conf;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;

@SpringJUnitWebConfig(classes = MapperContextConfig.class)
@Slf4j
class MapperContextConfigTest {
	
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	MapperScannerConfigurer mapper;

	@Test
	void testSqlSessionFactory() {
		log.info("factory : {}", factory);
	}

	@Test
	void testMapperScanner() {
		log.info("MapperScannerConfigurer : {}", mapper);
	}

}
