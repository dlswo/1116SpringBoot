package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/sample/*")
public class SampleController {

	@PreAuthorize("permitAll()")    //"isAnonymous()" => 로그인 안한 사람만 가능
	@GetMapping("/all")
	public void doAll() {
		log.info("doAll................");
	}
	
	@PreAuthorize("isAuthenticated()")  //로그인한 사용자만 볼수있다
	@GetMapping("/member")
	public void doMember() {
		log.info("doMember................");
	}
	
	@PreAuthorize("hasRole('ROLE_BUYER')")
	@GetMapping("/buyer")
	public void doBuyer() {
		log.info("doBuyer................");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("doAdmin................");
	}
	
}
