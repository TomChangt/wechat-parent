package com.ecdatainfo.wechat.security.config;

import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.google.common.collect.Maps;

@Configuration
public class ShiroConfig {


	/**
	 * FilterRegistrationBean
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); 
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*"); 
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
	}


	/**
	 * @see ShiroFilterFactoryBean
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager());
		bean.setLoginUrl("/api/auth/invalidUser");
		bean.setUnauthorizedUrl("/api/auth/unauthor");
		
		Map<String, Filter>filters = Maps.newHashMap();
		filters.put("perms", urlPermissionsFilter());
		filters.put("anon", new AnonymousFilter());
		filters.put("statelessAuthc",getStatelessAuthcFilter());
		bean.setFilters(filters);

		Map<String, String> chains = Maps.newHashMap();
		chains.put("/api/auth/login", "anon");
		chains.put("/unauthor", "anon");
		chains.put("/logout", "logout");
		chains.put("/base/**", "anon");
		chains.put("/css/**", "anon");
		chains.put("/layer/**", "anon");
		chains.put("/api/**", "statelessAuthc,authc,perms");
		bean.setFilterChainDefinitionMap(chains);
		return bean;
	}

	@Bean(name = "statelessAuthcFilter")
	public StatelessAuthcFilter getStatelessAuthcFilter(){
		return  new StatelessAuthcFilter();
	}

	/**
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(userRealm());
		//manager.setCacheManager(redisCacheManager());
		manager.setSessionManager(defaultSessionManager());
		return manager;
	}

	@Bean(name="redisSessionDAO")
	public RedisSessionDAO redisSessionDAO(){
		return  new RedisSessionDAO();
	}
	
	/**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultSessionManager defaultSessionManager() {
		DefaultSessionManager sessionManager = new DefaultSessionManager();
		sessionManager.setSessionValidationSchedulerEnabled(false);
//		sessionManager.setSessionDAO(redisSessionDAO());
		return sessionManager;
	}

	
	/**
	 * @see UserRealm--->AuthorizingRealm
	 * @return
	 */
	@Bean
	//@DependsOn(value={"lifecycleBeanPostProcessor", "shrioRedisCacheManager"})
	@DependsOn(value={"lifecycleBeanPostProcessor"})
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
//		userRealm.setCacheManager(redisCacheManager());
		userRealm.setCachingEnabled(false);
//		userRealm.setAuthenticationCachingEnabled(true);
		return userRealm;
	}
	
	@Bean
	public URLPermissionsFilter urlPermissionsFilter() {
		return new URLPermissionsFilter();
	}
	
//	@Bean(name="shrioRedisCacheManager")
//	@DependsOn(value="redisTemplate")
//	public ShrioRedisCacheManager redisCacheManager() {
//		ShrioRedisCacheManager cacheManager = new ShrioRedisCacheManager(redisTemplate());
//		return cacheManager;
//	}
	
//	@Bean(name="redisTemplate")
//	public RedisTemplate<byte[], Object> redisTemplate() {
//	    RedisTemplate<byte[], Object> template = new RedisTemplate();
//	    template.setConnectionFactory(connectionFactory());
//	    return template;
//	}
//
//	@Bean
//	public JedisConnectionFactory connectionFactory(){
//		JedisConnectionFactory conn = new JedisConnectionFactory();
//		conn.setDatabase(0);
//		conn.setHostName("120.77.8.9");
//		conn.setPassword("tomchangt");
//		conn.setPort(6379);
//		conn.setTimeout(3000);
//		return conn;
//	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}