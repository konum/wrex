package org.wrex.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dto.VehicleDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-config.xml" })
public class UserServiceTest {

	@Autowired
	public VehicleService service;
	
	@Test
	public void testCount() {
		Assert.assertEquals(3,service.countAll());
	}

	@Test
	public void getUser() {
		Assert.assertEquals("gasolina",service.load("FYJA-44").getGas());
	}

	@Test
	@Transactional
	public void updateUser() {
		VehicleDTO konum = service.load("FYJA-44");
		konum.setGas("diesel");
		service.save(konum);
		Assert.assertEquals("diesel", service.load("FYJA-44").getGas());
	}
	
	
//	@Test
//	public void performanceMap() {
//		User user = generateUser();
//		int i = 0;
//		long startTime = System.currentTimeMillis();
//		while (i++<10000) {
//			UserDTO dto = VehicleMapper.INSTANCE.userToUserDTO(user);
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("10000 con mapper  milisegundos " +(endTime - startTime));
//		
//	}
//
//	private User generateUser() {
//		User user = new User();
//		user.setEmail("asdasd@asd.com");
//		user.setIdpicture("2");
//		user.setIduser(1);
//		user.setName("nombre");
//		user.setPassword("asdasdxcfweiorjlskjdfoiashdroñ832u4u8o");
//		user.setRole(1);
//		user.setStatus(1);
//		return user;
//	}
}
