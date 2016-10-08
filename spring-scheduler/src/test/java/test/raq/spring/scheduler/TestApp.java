package test.raq.spring.scheduler;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		String[] str = {"classpath:WEB-INF/spring-schedulers.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(str);		
	}
}

