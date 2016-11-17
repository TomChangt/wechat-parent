package com.ecdatainfo.wechat.api.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: XSSFilter 
 * @Description: xss 攻击过滤器 
 * @author 573196010@qq.com
 * @date 2015年7月15日 下午9:00:51 
 *
 */
public class XSSFilter implements Filter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final List<String> trustAPIList = new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	String trustAPIs = filterConfig.getInitParameter("trustAPIList");
    	if(!StringUtils.isEmpty(trustAPIs)){
    		String[] array = trustAPIs.split(",");
    		for(String api : array){
    			trustAPIList.add(api);
    			logger.info("add xss trust API {}" ,api);
    		}
    	}
    	logger.info("XSSFilter init success!");
    }
    
    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    	//ignore api path
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
    	String requestAPI = httpRequest.getRequestURI();
    	String contextPath = httpRequest.getContextPath();
    	//指定响应字符编码
    	response.setCharacterEncoding("utf-8");
    	requestAPI =  requestAPI.replace(contextPath, "");
    	/**
    	 * 对于信任API，不做xss过滤
    	 */
    	for(String trustAPI : trustAPIList){
    		if(requestAPI.startsWith(trustAPI)){
    			chain.doFilter(request, response);
    			return;
    		}
    	}
    	
//    	if(!httpRequest.getMethod().equalsIgnoreCase(HttpMethodEnum.OPTIONS.name()) ){//对于文件上传以及options方法直接跳过
//        	logger.debug("filter request start!");
//    	    chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
//    	    logger.debug("filter request end!");
//    	} else{
//    		chain.doFilter(request, response);
//    	}
    	
       
    } 

}
