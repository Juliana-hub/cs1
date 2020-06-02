package cn.edu.scujcc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.servlet.HandlerInterceptor;

import cn.edu.scujcc.model.User;

public class interceptor2 implements HandlerInterceptor {
	@Autowired
    private CacheManager cacheManager;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean logged=false;
		String target=request.getRequestURI();
		if(target!=null&&target.startsWith("/user")) {
			return true;
		}
		if(response.getStatus()==HttpServletResponse.SC_FORBIDDEN){
			return true;
		}
		String tooken=request.getHeader("tooken");
		if(tooken!=null) {
			Cache cache=cacheManager.getCache(User.CACHE_NAME);
		    String username=cache.get(tooken,String.class);
		    if(null!=username){
		    	logged=true;
		    }
		}
		return logged;
	}
	

}



