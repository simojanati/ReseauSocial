package com.reseau.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal,password as credentials, active from utilisateur where username=?")
			.authoritiesByUsernameQuery("select username as principal, role as role from utilisateur_roles where username=?")
			.rolePrefix("ROLE_")
			.passwordEncoder(new Md5PasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .authorizeRequests()
	        .antMatchers("/profile","/index","/groupe","/profileChercher","/message","/inbox","/lireMessage","/message").hasAnyRole("ETUDIANT","PROFESSEUR","ADMIN")
	        .antMatchers("/dist/imagesPoste/**","/dist/img/**","/dist/tmpFiles/**").authenticated()
	        .and()
	    .formLogin() 
	        .loginPage("/login")
	        .defaultSuccessUrl("/index")
	        .permitAll()
	        .and()
	    .exceptionHandling()
	    	.accessDeniedPage("/403");
	}
	
	
	
}
