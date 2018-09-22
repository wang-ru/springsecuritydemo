package wr.security.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import wr.security.web.interceptor.TimeInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TimeInterceptor timeInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
