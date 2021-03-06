package cn.edu.scujcc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cn.edu.scujcc.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
	public User findByUsernameAndPassword(String username,String password);

}
