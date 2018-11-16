package org.zerock.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@EnableWebSecurity //configration 어노테이션 자동 추가
@Log
@EnableGlobalMethodSecurity(prePostEnabled=true)  //이 어노테이션 활성화 시킨다
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public UserDetailsService UserDetailsService() {
		
		return new ZerockUserService();		
		
	}
	
//	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
//		log.warning("================configureGlobal======================");
//		
//		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("----------------------------------");
		log.info("configure");
		log.info("----------------------------------");
		
		http.formLogin();
		
		http.rememberMe().tokenValiditySeconds(60*60*24); //하루 쿠키 지속
	}
	
	   @Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      
	      log.info("-------------------------------1");
	      log.info("-------------------------------1");
	      log.info("-------------------------------1");
	      log.info("-------------------------------1");
	      log.info("-------------------------------1");
	      
	      auth.userDetailsService(UserDetailsService())
	      .passwordEncoder(passwordEncoder());
	   }
	
}
