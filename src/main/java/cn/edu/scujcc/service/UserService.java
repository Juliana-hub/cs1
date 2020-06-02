package cn.edu.scujcc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.edu.scujcc.dao.UserRepository;
import cn.edu.scujcc.model.User;
@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private CacheManager cacheManager;
	private static final Logger logger=LoggerFactory.getLogger(UserService.class);

	public User createUser(User u) {
		
		User result=null;
		
		result=repo.save(u);
		return result;
	}

	public String checkIn(String username) {
		
		String srt=username+System.currentTimeMillis();
    	Cache cache=cacheManager.getCache(User.CACHE_NAME);
    	String tooken=DigestUtils.md5DigestAsHex(srt.getBytes());
    	cache.put(tooken, username);
    	return tooken;
	}

	public boolean getUser(String username, String password) {
		
		boolean result=false; 
		User u= repo.findByUsernameAndPassword(username,password);
		if(null!=u) {
			result=true;
		}
		return result;
	}

	 public String currentUser(String tooken){
	    	Cache cache=cacheManager.getCache(User.CACHE_NAME);
		    String username=cache.get(tooken,String.class);
	    	return username;
	    }

}
