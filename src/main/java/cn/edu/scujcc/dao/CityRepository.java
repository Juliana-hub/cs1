package cn.edu.scujcc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cn.edu.scujcc.model.City;

@Repository
public interface CityRepository extends MongoRepository<City,String>{
	public City findByCityname(String cityname);
	public List<City> findBystatus(String  status);

}
