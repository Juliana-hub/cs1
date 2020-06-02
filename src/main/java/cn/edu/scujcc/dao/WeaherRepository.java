package cn.edu.scujcc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cn.edu.scujcc.model.Weather;

@Repository
public interface WeaherRepository extends MongoRepository<Weather,String>{
	public List<Weather> findByCity(String city);
	public List<Weather> findByDate(String date);
	public Weather findByCityAndDate(String city,String date);

}
