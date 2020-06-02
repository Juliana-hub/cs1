package cn.edu.scujcc.Api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.model.Weather;


import cn.edu.scujcc.model.Comment;
import cn.edu.scujcc.model.User;
import cn.edu.scujcc.service.WeatherService;

@RestController   
@RequestMapping("/weather")
public class WeatherController {
	public static final Logger logger =LoggerFactory.getLogger(WeatherController.class);
	@Autowired
	private WeatherService service;
	@Autowired
	private CacheManager cacheManager;
	@PostMapping
	public Weather createWeather(@RequestBody Weather w) {
		return this.service.createWeather(w);
	}
	@GetMapping("/{Id}")
	public Weather findWeatherById(@PathVariable String Id) {
		return this.service.findWeatherById(Id);
	}
	@GetMapping("/{city}")
	public List<Weather> findWeatherByCity(@PathVariable String city) {
		return this.service.findWeatherByCity(city);
	}
	@GetMapping("/{date}")
	public List<Weather> findWeatherByDate(@PathVariable String date) {
		return this.service.findWeatherByDate(date);
	}
	@GetMapping("/{city}/{date}")
	public Weather findWeatherByCityAndDate(@PathVariable String city,@PathVariable String date) {
		return this.service.findWeatherByCityAndDate(city,date);
	}
	@PostMapping("/{weatherId}/comment")
	public Weather addComment(@PathVariable String weatherId,@RequestBody Comment comment){
		
	    Weather result=null;
		
	    result=service.addComment(weatherId, comment);
		
		return result;
	}
	@PutMapping("/{weatherId}/comment")
	public Weather updateWeatherComment(@PathVariable String weatherId,@RequestBody List<Comment> comments) {
		
		return this.service.updateWeatherComment(weatherId,comments);
		
	}
}