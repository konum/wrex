package org.wrex.dao.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.UserRepository;
import org.wrex.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:integrationTest-config.xml" })
public class UserDaoTest {

	@Autowired
	UserRepository userDao;

	@Test
	@Transactional
	public void createUser() {
		User test = new User();
		test.setName("test");
		test.setPassword("asd");
		userDao.save(test);
		Assert.assertEquals(3, userDao.count());
	}

	@Test
	@Transactional
	public void getAll() {
		Assert.assertEquals(2, userDao.count());
	}
}
