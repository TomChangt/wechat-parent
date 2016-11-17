package com.ecdatainfo.wechat.api.config;

import com.ecdatainfo.wechat.api.config.filter.ApiOriginFilter;
import com.ecdatainfo.wechat.api.config.filter.XSSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig {



    @Bean
    public FilterRegistrationBean apiOriginFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("ApiOriginFilter");
        ApiOriginFilter apiOriginFilter = new ApiOriginFilter();
        registrationBean.setFilter(apiOriginFilter);
        registrationBean.setOrder(1);
        List<String> urlList = new ArrayList<String>();
        urlList.add("/api/*");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("XSSFilter");
        XSSFilter xssFilter = new XSSFilter();
        registrationBean.setFilter(xssFilter);
        registrationBean.setOrder(2);
        List<String> urlList = new ArrayList<String>();
        urlList.add("/api/wechat/notice");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }


}