package com.iago.springapp.domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.pojo.Profile;

/**
 *
 * @author Administrador
 */
public class ProfileDao extends AbstractDao {
	public ProfileDao() {
		super();
	}

	/**
	 * Insert a new Profile into the database.
	 * @param profile
	 */
	public void create(Profile profile) throws DataAccessLayerException {
		super.saveOrUpdate(profile);
	}


	/**
	 * Delete a detached Profile from the database.
	 * @param profile
	 */
	public void delete(Profile profile) throws DataAccessLayerException {
		super.delete(profile);
	}

	/**
	 * Find an Profile by its primary key.
	 * @param id
	 * @return
	 */
	public Profile find(Long id) throws DataAccessLayerException {
		return (Profile) super.find(Profile.class, id);
	}

	/**
	 * Updates the state of a detached Profile.
	 *
	 * @param profile
	 */
	public void update(Profile profile) throws DataAccessLayerException {
		super.saveOrUpdate(profile);
	}

	/**
	 * Finds all Profiles in the database.
	 * @return
	 */
	public List findAll() throws DataAccessLayerException{
		return super.findAll(Profile.class);
	}

	public Profile findByName(String name) throws DataAccessLayerException {
		List<Profile> result = new ArrayList<Profile>();

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			result = session.createQuery("from Profile s where s.name=?").setString(0, name).list();
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close();
		}

		return result.get(0);
	}

	public Profile getProfile(String email, String password) {
		Profile result = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Profile s where s.email=? and s.password=?");
			query.setString(0, email);
			query.setString(1, password);
			result = (Profile) query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close();
		}

		return result;
	}

}