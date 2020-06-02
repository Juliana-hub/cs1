package cn.edu.scujcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class web2 extends WebMvcConfigurerAdapter{
	@Autowired
	interceptor2 ceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ceptor);
	}
    
} 


