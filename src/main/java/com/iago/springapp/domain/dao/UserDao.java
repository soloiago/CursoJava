/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iago.springapp.domain.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.pojo.Users;

/**
 *
 * @author Administrador
 */
public class UserDao extends AbstractDao implements Serializable {
	
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Hacemos el objeto serializable para poder usarlo a la hora de validar el nick
	 */
	private static final long serialVersionUID = 1L;

	public UserDao() {
		super();
	}

	/**
	 * Insert a new Users into the database.
	 * @param user
	 */
	public void create(Users user) throws DataAccessLayerException {
		super.saveOrUpdate(user);
	}


	/**
	 * Delete a detached Users from the database.
	 * @param user
	 */
	public void delete(Users user) throws DataAccessLayerException {
		super.delete(user);
	}

	/**
	 * Find an Users by its primary key.
	 * @param id
	 * @return
	 */
	public Users find(Long id) throws DataAccessLayerException {
		return (Users) super.find(Users.class, id);
	}

	/**
	 * Updates the state of a detached Users.
	 *
	 * @param user
	 */
	public void update(Users user) throws DataAccessLayerException {
		super.saveOrUpdate(user);
	}

	/**
	 * Finds all Userss in the database.
	 * @return
	 */
	public List findAll() throws DataAccessLayerException{
		return super.findAll(Users.class);
	}

	public Users findUserByNickname(String nickname) {
		Users user = null;

		try {
			startOperation();
			Query query = session.getNamedQuery("findUserByNickname").setString("nickname", nickname);
			user = (Users) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return user;
	}

	public boolean isOnSystem(String nickname, String password) {
		boolean result = false;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Users s where s.nickname=? and s.password=?");
			query.setString(0, nickname);
			query.setString(1, password);
			result = query.list().size() > 0 ? true: false;
			tx.commit();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			handleException(e);
		} finally {
			HibernateUtil.close();
		}

		return result;
	}

}