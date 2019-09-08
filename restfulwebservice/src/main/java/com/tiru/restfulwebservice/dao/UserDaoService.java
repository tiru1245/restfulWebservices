package com.tiru.restfulwebservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tiru.restfulwebservice.beans.User;

@Component
public class UserDaoService {
private static  List<User> users= new ArrayList<User>();
private Integer userCount=3;
static {
	users.add(new User(1,"tiru", new Date()));
	users.add(new User(2,"surya", new Date()));
	users.add(new User(3,"salman", new Date()));
}
public List findAll() {
	return users;
}
public User save(User user) {
	if(user.getId()==null) {
		user.setId(++userCount);
	}
	users.add(user);
	return user;
}
public User findOne(int id) {
	Optional<User> us=users.stream().filter(user-> user.getId()==id).collect(Collectors.reducing((a, b) -> null));
	if(us.isPresent()) {
		return us.get();
	}
	else {
		return null;

	}
}
}
