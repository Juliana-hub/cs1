package cn.edu.scujcc.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scujcc.dao.WeaherRepository;
import cn.edu.scujcc.model.Comment;
import cn.edu.scujcc.model.Weather;


@Service
public class WeatherService {
	@Autowired
	private WeaherRepository repo;
	public static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	public List<Weather> findWeatherByCity(String city) {
		return repo.findByCity(city);	
	}

	public List<Weather> findWeatherByDate(String date) {
		return repo.findByDate(date);
	}

	public Weather findWeatherByCityAndDate(String city, String date) {
		return repo.findByCityAndDate(city,date);
	}
	public Weather findWeatherById(String weatherId) {
		Optional<Weather> result = repo.findById(weatherId);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	
	

	public Weather addComment(String weatherId, Comment comment) {
		Weather result = null;
		Weather saved = findWeatherById(weatherId);
		if (null != saved) {
			saved.addComment(comment);
			result = repo.save(saved);
		}
		return result;
	}

	public Weather updateWeatherComment(String weatherId, List<Comment> comments) {
		
		Weather saved = findWeatherById(weatherId);
		saved.setComments(comments);
		return saved;
	}

	public Weather createWeather(Weather w) {
		repo.save(w);
		return w;
	}

}
