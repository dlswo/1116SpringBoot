package org.zerock.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.Member;

import lombok.Data;

@Data
public class ZerockSecurityUser extends User{

	private Member member;
	
	public ZerockSecurityUser(Member member) {
		
		super(member.getMid(), member.getMpw(),
				//map => 전혀 다른 타입으로 바꿔준다.
				member.getAuthList().stream().map(auth -> new SimpleGrantedAuthority("ROLE_"+auth.getAuth()))
					.collect(Collectors.toList())
				);
		this.member = member;
	}
	
}
