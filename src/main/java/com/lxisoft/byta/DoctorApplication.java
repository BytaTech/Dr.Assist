package com.lxisoft.byta;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class DoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}

	public @PostConstruct void init() {


		SecurityContextHolder.clearContext();
	}

	/**
	 * This application is secured at both the URL level for some parts, and the
	 * method level for other parts. The URL security is shown inside this code,
	 * while method-level annotations are enabled at by
	 *
	 * 
	 */
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		/**
		 * This section defines the user accounts which can be used for
		 * authentication as well as the roles each user has.
		 * 
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
		 */
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.inMemoryAuthentication().//
					withUser("akhil").password("akhil").roles("USER").and().//
					withUser("arun").password("arun").roles("USER", "DOCTOR");
		}

		/**
		 * This section defines the security policy for the app.
		 * <p>
		 * <ul>
		 * <li>BASIC authentication is supported (enough for this REST-based
		 * demo).</li>
		 * <li>/Patient Medical Data is secured using URL security shown below.</li>
		 * <li>CSRF headers are disabled since we are only testing the REST
		 * interface, not a web one.</li>
		 * </ul>
		 *
		 * @param http
		 * @throws Exception
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
		 */
		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.httpBasic().and().authorizeRequests().//
					antMatchers(HttpMethod.GET, "/medicalhistory/**").hasRole("USER").//
					antMatchers(HttpMethod.PUT, "/medicalhistory/**").hasRole("DOCTOR").//
					antMatchers(HttpMethod.POST, "/medicalhistory/**").hasRole("DOCTOR").and().//
					csrf().disable();
		}

	}
}
