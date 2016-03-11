package org.wrex.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-config.xml" })
public class UserServiceTest {

	@Autowired
	public UserService service;
	
	@Test
	public void testCount() {
		Assert.assertEquals(3,service.countUsers());
	}

	@Test
	public void getUser() {
		Assert.assertEquals("Wrex Admin",service.load(1).getName());
	}

	@Test
	@Transactional
	public void updateUser() {
		User konum = service.load(1);
		konum.setName("change");
		service.update(konum);
		Assert.assertEquals("change",service.load(1).getName());
	}
}
