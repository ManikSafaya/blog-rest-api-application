package com.manik.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manik.apis.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void repoTest() {
		String className = this.userRepo.getClass().getName();
		Package packName = this.userRepo.getClass().getPackage();
		System.out.println(className);
		System.out.println(packName);
	}

}
