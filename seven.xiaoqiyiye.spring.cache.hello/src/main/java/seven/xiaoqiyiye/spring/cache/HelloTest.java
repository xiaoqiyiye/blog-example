package seven.xiaoqiyiye.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class HelloTest extends AbstractJUnit4SpringContextTests{

	@Test
	public void hello(){
		HelloService service = applicationContext.getBean(HelloService.class);
		service.get("linya");
		Hello hello = service.get("linya");
		System.out.println(hello.toString());
	}
}
