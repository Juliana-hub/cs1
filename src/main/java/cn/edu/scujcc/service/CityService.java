package cn.edu.scujcc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scujcc.model.City;
import cn.edu.scujcc.model.Weather;
import cn.edu.scujcc.dao.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repo;
	public static final Logger logger = LoggerFactory.getLogger(CityService.class);
	public List<City> getAllCity() {
		
		return repo.findAll();
	}

	public City findCityByCityname(String cityname) {
		
		return repo.findByCityname(cityname);
	}

	public City addCommonCity(City c) {
		City saved=repo.findByCityname(c.getCityname());
		saved.setStatus(c.getStatus());
		repo.save(saved);
		return saved;
	}

	public City deleteCity(String cityname) {
		City c=findCityByCityname(cityname);
		c.setStatus("");
		repo.save(c);
		return c;
		
	}

	public City updateCommonCityWeather(City c) {
		City saved=repo.findByCityname(c.getCityname());
		
		List<Weather> ws=c.getWeathers();
		saved.setWeathers(ws);
		repo.save(saved);
		return saved;
	}

	public List<City> getAllCommonCities() {
		
		return repo.findBystatus("Yes");
	}

	public City createCity(City c) {
		
		return repo.save(c);
	}

}
