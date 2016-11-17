package com.ecdatainfo.wechat.api.config.filter;

import org.springframework.util.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 * Created by tonymac on 14/11/7.
 */
public class CORSResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        MultivaluedMap<String, Object> headers = containerResponseContext.getHeaders();
        //设置默认头
        if (StringUtils.isEmpty(headers.getFirst("Content-Type"))) {
            headers.putSingle("Content-Type", "application/json; charset=utf-8");
        }
    }
}
