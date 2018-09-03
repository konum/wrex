package org.wrex.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.dto.DriverDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
@SpringBootApplication
public class DriverServiceTest {

	@Autowired
	private DriverService serv;

	@Test
	public void getAllDrivers(){
		Assert.assertEquals(2,serv.getAllDrivers().size());
	}
	@Test
	public void getDriverByRut(){
		Assert.assertEquals("Walter", serv.getDriverByRut("22222222-2"));
	}
	@Test
	public void saveDriver() {
		DriverDTO nuevo = new DriverDTO();
		nuevo.setRut("1");
		nuevo.setName("Guille");
		serv.saveDriver(nuevo);
		Assert.assertEquals("Guille", serv.getDriverByRut("1"));
	}
	@Test
	public void deleteDriverByRut(){
		serv.deleteDriverByRut("22222222-2");
		Assert.assertEquals(1,serv.getAllDrivers().size());
	}
}
