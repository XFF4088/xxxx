import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.ItemMapper;

public class TestDemo {
	@Test
	public void test() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml","spring/applicationContext-service.xml");
		ItemMapper bean = app.getBean(ItemMapper.class);
		bean.selectById(1);
	}
}
