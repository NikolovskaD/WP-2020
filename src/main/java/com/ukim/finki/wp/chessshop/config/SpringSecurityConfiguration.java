/*
package com.ukim.finki.wp.chessshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {


        @Autowired
        @Autowired
        private AuthenticationEntryPoint entryPoint;
        private AuthenticationEntryPoint entryPoint;


        @Autowired
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            private MyUserDetailsService userDetailsService;
            auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");

        }

        @Override
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                http.authorizeRequests().anyRequest().authenticated().and().httpBasic()
                auth.userDetailsService(userDetailsService);
			.authenticationEntryPoint(entryPoint);
            }
        }


	*/
/*@Override
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint);
	}*//*

    }


    */
/*
     * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
     * throws Exception {
     * auth.inMemoryAuthentication().withUser("user").password("password").roles
     * ("USER"); }
     *//*


    */
/*
     * @Override protected void configure(HttpSecurity http) throws Exception {
     * http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
     * }
     *//*


}
*/
