package cf.cours.dao;

import java.util.ArrayList;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cf.cours.model.User;

@Repository
public class UserDao<T> implements Dao<T> {
	private List<User> users = new ArrayList<>();


	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		for (User u : users) {
			if (u.getLogin().equals(id))
				return u;
		}
		return null;
	}

	@Override
	public Set getAll() {
		// TODO Auto-generated method stub
		return (Set) users;
	}

	@Override
	public void save(Object t) {
		// TODO Auto-generated method stub
		users.add((User)t);
		
		
	}

	@Override
	public void update(Object t, String[] params) {
		// TODO Auto-generated method stub
		User u = (User)t;	
		u.setLogin(Objects.requireNonNull(
		          params[0], "login cannot be null"));
		        u.setPassword(Objects.requireNonNull(
		          params[1], "Password cannot be null"));
		        users.add(u);
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		users.remove(t);
		
	}

}
