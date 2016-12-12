package com.htw.test.config;

/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.htw.analysis.backend.config.AntPathRequestMatcher;
import com.htw.analysis.backend.config.AuthenticationManagerBuilder;
import com.htw.analysis.backend.config.EnableGlobalMethodSecurity;
import com.htw.analysis.backend.config.HttpSecurity;
import com.htw.analysis.backend.config.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Value("${admin.name}")
	private String adminName;
	
	@Value("${admin.password}")
	private String adminPassword;
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated();
        http
                .formLogin().failureUrl("/signin?error")
                .defaultSuccessUrl("/hello")
                .loginPage("/signin")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/signin")
                .permitAll();
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser(adminName).password(adminPassword).roles("USER");}
}
*/


