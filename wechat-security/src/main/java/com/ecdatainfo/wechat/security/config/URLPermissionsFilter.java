package com.ecdatainfo.wechat.security.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ecdatainfo.wechat.service.sys.IUserRoleModuleService;
import org.apache.shiro.SecurityUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class URLPermissionsFilter extends PermissionsAuthorizationFilter{
	@Autowired
	private IUserRoleModuleService userRoleModuleService;

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		String curUrl = getRequestUrl(request);
		Subject subject = SecurityUtils.getSubject();
		if(subject.getPrincipal() == null
				|| StringUtils.endsWithAny(curUrl, ".js",".css",".html")
				|| StringUtils.endsWithAny(curUrl, ".jpg",".png",".gif", ".jpeg")
				|| StringUtils.equals(curUrl,"/api/auth/login")
				|| StringUtils.equals(curUrl,"/api/auth/unauthor")
				|| StringUtils.equals(curUrl,"/api/auth/invalidUser")) {
			return true;
		}
		List<String> urls = userRoleModuleService.findPermissionUrl(subject.getPrincipal().toString());

		return urls.contains(curUrl);
	}
	
	/**
	 * 获取当前URL+Parameter
	 * @author changt
	 * @since  2014年12月18日 下午3:09:26
	 * @param request	拦截请求request
	 * @return			返回完整URL
	 */
	private String getRequestUrl(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest)request;
		String queryString = req.getQueryString();
		queryString = StringUtils.isBlank(queryString)?"": "?"+queryString;
		return req.getRequestURI()+queryString;
	}
}
