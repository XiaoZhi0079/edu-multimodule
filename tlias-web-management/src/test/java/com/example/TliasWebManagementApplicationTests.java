package com.example;

import com.example.entity.User;
import com.example.EsRepository.EsRepository;
import org.apache.ibatis.annotations.Options;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class TliasWebManagementApplicationTests {


	@Autowired
	private EsRepository esRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void add() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i);
			user.setName("第"+i+"张三");
			user.setAge(18+i);
			user.setSex("男");
			User user1=esRepository.save(user);
			System.out.println(user1);
		}
	}
	@Test
	public void find() {
		Iterable<User>  users=esRepository.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void findById() {
		Optional<User> userbyid =esRepository.findById(1);
		System.out.println(userbyid);
	}

	@Test
	public void update() {
		User updateuser=new User();
		updateuser.setId(9);
		updateuser.setName("张三");
		updateuser.setAge(19);
		updateuser.setSex("男");
		User update=esRepository.save(updateuser);
		System.out.println(update);
	}

	@Test
	public void delete() {
		esRepository.deleteById(1);
	}

}
