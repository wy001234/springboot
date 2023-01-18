package kr.co.sboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties.ConfigureAction;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 접근권한 설정
		http.authorizeRequests().antMatchers("/").permitAll();
		
		
		// 사이트 위조 방지 설정
		http.csrf().disable();
		
		/*
		// 로그인 설정
		http.formLogin()
		.loginPage("/user2/login")
		.defaultSuccessUrl("/user2/loginSuccess")
		.usernameParameter("uid")
		.passwordParameter("pass");
		
		// 로그아웃 설정
		http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
		.logoutSuccessUrl("/user2/login");
		*/
	}
	
	//@Autowired
	//private User2Service userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Security 사용자에 대한 테스트 권한 설정
		//auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER");
		//auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		
		// 로그인 인증 처리 서비스, 암호화 방식 설정
		//auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}	//auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    

}
