package com.blog.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.apis.repository.UserRepository;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String name = this.userRepository.getClass().getName();
		System.out.println(name);
	}

}
