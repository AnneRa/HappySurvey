package com.htw.test.config;
//package com.htw.analysis.happysurvey.config;
/*package com.htw.analysis.happySurvey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${admin.name}")
	private String adminName;
	
	@Value("${admin.password}")
	private String adminPassword;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

        RequestMatcher csrfRequestMatcher = new RequestMatcher() {

            private RegexRequestMatcher requestMatcher = new RegexRequestMatcher("/api/v1", null);

           @Override
            public boolean matches(HttpServletRequest request) {
                return requestMatcher.matches(request);
            }
        };

        http.csrf().requireCsrfProtectionMatcher(csrfRequestMatcher);
		
		http.httpBasic().realmName("HappySurvey");
		
		http.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser(adminName).password(adminPassword).roles("ADMIN");
	}

}*/