/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iago.springapp.domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.pojo.Comments;

/**
 *
 * @author Administrador
 */
@Repository
public class CommentDao extends AbstractDao {
	public CommentDao() {
		super();
	}

	/**
	 * Insert a new Comments into the database.
	 * @param comment
	 */
	public void create(Comments comment) throws DataAccessLayerException {
		super.saveOrUpdate(comment);
	}


	/**
	 * Delete a detached Comments from the database.
	 * @param comment
	 */
	public void delete(Comments comment) throws DataAccessLayerException {
		super.delete(comment);
	}

	/**
	 * Find an Comments by its primary key.
	 * @param id
	 * @return
	 */
	public Comments find(Long id) throws DataAccessLayerException {
		return (Comments) super.find(Comments.class, id);
	}

	/**
	 * Updates the state of a detached Comments.
	 *
	 * @param comment
	 */
	public void update(Comments comment) throws DataAccessLayerException {
		super.saveOrUpdate(comment);
	}

	/**
	 * Finds all Commentss in the database.
	 * @return
	 */
	public List findAll() throws DataAccessLayerException{
		return super.findAll(Comments.class);
	}

	public List<Comments> findByItemIdRoot(long itemId) throws DataAccessLayerException {
		List<Comments> result = new ArrayList<Comments>();

		try {
			startOperation();
			result = (List<Comments>) session.createSQLQuery("select * from Comments c where c.item_id= :itemId and REPLY_ID=0 order by fecha").addEntity(Comments.class).setParameter("itemId", itemId).list();
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close();
		}

		return result;
	}
	
	public List<Comments> findByItemIdReplies(long itemId, long replyId) throws DataAccessLayerException {
		List<Comments> result = new ArrayList<Comments>();

		try {
			startOperation();
			result = (List<Comments>) session.createSQLQuery("select * from Comments c where c.item_id= :itemId and REPLY_ID= :replyId order by fecha").addEntity(Comments.class).setParameter("itemId", itemId).setParameter("replyId", replyId).list();
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtil.close();
		}

		return result;
	}

}