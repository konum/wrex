package org.wrex.dao.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.UserDao;
import org.wrex.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:integrationTest-config.xml" })
public class UserDaoTest {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	@Test
	@Transactional
	public void createUser() {
		User test = new User();
		test.setName("test");
		test.setPassword("asd");
		userDao.insert(test);
		Assert.assertEquals(3, userDao.getAll().size());
	}

	@Test
	@Transactional
	public void getAll() {
		Assert.assertEquals(2, userDao.getAll().size());
	}
}
