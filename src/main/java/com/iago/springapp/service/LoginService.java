package com.iago.springapp.service;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.iago.springapp.domain.dao.ProfileDao;
import com.iago.springapp.domain.dao.UserDao;
import com.iago.springapp.domain.pojo.Profile;
import com.iago.springapp.domain.pojo.Users;
import com.iago.springapp.form.UserForm;

public class LoginService implements Serializable {
	
	protected final Log logger = LogFactory.getLog(getClass());

	private boolean logged = false;

	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private UserDao userDao;

	private Users user;

	public boolean isLogged() {
		return logged;
	}

	public boolean login(String nickname, String password) {
		boolean result = false;

		try {
			if (getUserDao().isOnSystem(nickname, password)) {
				result = true;
				this.logged = true;
				setUser(getUserDao().findUserByNickname(nickname));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public ProfileDao getProfileDao() {
		return profileDao;
	}

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}

	public boolean isUser(String nickname) {
		boolean result = false;
		
		try {
			Users user = userDao.findUserByNickname(nickname);
			if(user!=null) {
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	public boolean insertUser(UserForm userForm) {
		boolean result = true;
		
		try {
			Users user = new Users();
			user.setNickname(userForm.getNickname());
			user.setPassword(userForm.getPassword());
			getUserDao().create(user);

			Profile profile = new Profile();
			profile.setName(userForm.getName());
			profile.setSurname(userForm.getSurname());
			profile.setEmail(userForm.getEmail());
			profile.setUsers(user);
			getProfileDao().create(profile);
				
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}

}
