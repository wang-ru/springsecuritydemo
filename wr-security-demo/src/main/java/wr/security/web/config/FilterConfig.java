package wr.security.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wr.security.web.filter.TimeFilter;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new TimeFilter());
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filter.setUrlPatterns(urls);
        return filter;
    }
}
