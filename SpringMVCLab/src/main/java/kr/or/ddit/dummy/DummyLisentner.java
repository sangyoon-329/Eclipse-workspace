package kr.or.ddit.dummy;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyLisentner implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
      log.info("서버 구동");  
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
      log.info("서버 종료");
    }
	
}
