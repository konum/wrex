package org.wrex.dao.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wrex.dao.PostDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:integrationTest-config.xml" })
public class PostDaoTest {

	@Autowired
	@Qualifier("gradeDao")
	PostDao gradeDao;

	@Test
	public void getUserAllWithOrder() {
		
	}
	
}
