package org.wrex.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.api.domain.UserDTO;
import org.wrex.entities.User;
import org.wrex.mappers.UserMapper;

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
		Assert.assertEquals("konum",service.load(1).getName());
	}

	@Test
	@Transactional
	public void updateUser() {
		UserDTO konum = service.load(1);
		konum.setName("change");
		service.save(konum);
		Assert.assertEquals("change",service.load(1).getName());
	}
	
	
	@Test
	public void performanceMap() {
		User user = generateUser();
		int i = 0;
		long startTime = System.currentTimeMillis();
		while (i++<10000) {
			UserDTO dto = UserMapper.INSTANCE.userToUserDTO(user);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("10000 con mapper  milisegundos " +(endTime - startTime));
		
	}

	private User generateUser() {
		User user = new User();
		user.setEmail("asdasd@asd.com");
		user.setIdpicture("2");
		user.setIduser(1);
		user.setName("nombre");
		user.setPassword("asdasdxcfweiorjlskjdfoiashdroñ832u4u8o");
		user.setRole(1);
		user.setStatus(1);
		return user;
	}
}
