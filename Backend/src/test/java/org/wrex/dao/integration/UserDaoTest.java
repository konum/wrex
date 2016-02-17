package org.wrex.dao.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:integrationTest-config.xml" })
public class UserDaoTest {

	@Autowired
	@Qualifier("eventDao")
	UserDao eventDao;

	@Test
	@Transactional
	public void createEvent() {
	}
	
}
