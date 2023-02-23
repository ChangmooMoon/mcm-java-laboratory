package com.example.di_without_spring;

import com.example.di_without_spring.dto.RegisterDto;
import com.example.di_without_spring.repository.MemberDao;
import com.example.di_without_spring.service.ChangePasswordService;
import com.example.di_without_spring.service.MemberRegiesterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiWithoutSpringApplication {

	public static void main(String[] args) {
//        SpringApplication.run(DiWithoutSpringApplication.class, args);
		Assembler assembler = new Assembler();
		ChangePasswordService changePasswordService = assembler.getChangePasswordService();
		MemberRegiesterService regiesterService = assembler.getMemberRegiesterService();
		MemberDao memberDao = assembler.getMemberDao();

		regiesterService.regist(
			RegisterDto.builder()
				.email("hihi@hihi.net")
				.password("1234555")
				.confirmPassword("1234555")
				.name("meme")
				.build()
		);
		changePasswordService.changePassword("hihi@hihi.net", "1234555", "newpw");

		var map = memberDao.getMap();
		System.out.println(map.get("hihi@hihi.net").getPassword());
	}

}
