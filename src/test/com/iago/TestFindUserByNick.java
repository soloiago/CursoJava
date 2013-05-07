package com.iago;

import com.iago.springapp.domain.dao.UserDao;
import com.iago.springapp.domain.pojo.Users;

public class TestFindUserByNick {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Users userNull = userDao.findUserByNickname("NoExiste");

		Users userNoNull = userDao.findUserByNickname("otro");
	}

}
