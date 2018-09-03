package org.wrex.dao.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.VehicleRepository;
import org.wrex.entities.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:integrationTest-config.xml" })
public class VehicleDaoTest {

	@Autowired
	VehicleRepository userDao;

	@Test
	@Transactional
	public void createUser() {
		Vehicle test = new Vehicle();
		test.setPlate("XXXX-22");
		userDao.save(test);
		Assert.assertEquals(5, userDao.count());
	}

	@Test
	@Transactional
	public void getAll() {
		Assert.assertEquals(4, userDao.count());
	}
}
