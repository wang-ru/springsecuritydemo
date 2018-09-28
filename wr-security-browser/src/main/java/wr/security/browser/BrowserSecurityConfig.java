package wr.security.browser;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import wr.security.browser.authentication.WrAuthenctiationFailureHandler;
import wr.security.browser.authentication.WrAuthenticationSuccessHandler;
import wr.security.core.properties.SecurityProperties;

/**
 * Created by wsh10801 on 2018/9/23.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties properties;
    @Autowired
    private WrAuthenctiationFailureHandler wrAuthenctiationFailureHandler;
    @Autowired
    private WrAuthenticationSuccessHandler wrAuthenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form") //当提交这个请求时  UsernamePasswordAuthenticationFilter来处理
                .failureHandler(wrAuthenctiationFailureHandler)
                .successHandler(wrAuthenticationSuccessHandler)
                .and()
            .authorizeRequests()
                .antMatchers("/authentication/require",properties.getBrowser().getLoginPage()).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
