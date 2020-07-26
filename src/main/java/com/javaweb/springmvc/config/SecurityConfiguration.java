package com.javaweb.springmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.Service.IUserService;
import com.javaweb.springmvc.Service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@Transactional
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	@Autowired
	IUserService ser;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource).
//		usersByUsernameQuery("select user,password from users user= ? ").
//		authoritiesByUsernameQuery("select user,role from users where user= ? ");
		 auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("123456789")).roles("USER");
	       auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("123456789")).roles("ADMIN");
	       auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin**").hasRole("ADMIN").
		and().authorizeRequests().antMatchers("/**").permitAll().
		and().authorizeRequests().antMatchers("/web**").permitAll().
		anyRequest().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login-form").
		usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin").
		failureUrl("/login?error").and().exceptionHandling().accessDeniedPage("/web?page=1&limit=6").
		and().logout().logoutUrl("/logout").logoutSuccessUrl("/web?page=1&limit=6");
		

 }
		
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/Template/**");
	}

}
