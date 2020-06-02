package cn.edu.scujcc.Api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.model.City;


import cn.edu.scujcc.service.CityService;


@RestController   
@RequestMapping("/city")
public class CityController {
	public static final Logger logger =LoggerFactory.getLogger(CityController.class);
	@Autowired
	private CityService service;
	@Autowired
	private CacheManager cacheManager;
	@GetMapping
	public List<City> getALLCities() {
		logger.info("正在读取所有频道信息...");
		
		List<City> res=service.getAllCity();
		
		return res;
		
	}
	
	@PostMapping
	public City createCity(@RequestBody City c) {
		return service.createCity(c);
	}
	@PutMapping("/common")
	public City joinCommonCity(@RequestBody City c) {
		return service.addCommonCity(c);
		
	}
	@DeleteMapping("/common/{cityname}")
	public City deleteCommonCity(@PathVariable String cityname) {
		return service.deleteCity(cityname);
		
	}
	@GetMapping("/common")
	public List<City> getAllCommonCities(){
		return service.getAllCommonCities();
	}
	@PutMapping("/common/{cityname}")
	public City updateCommonCityWeather(@RequestBody City c) {
		return service.updateCommonCityWeather(c);
		
	}
	
}
