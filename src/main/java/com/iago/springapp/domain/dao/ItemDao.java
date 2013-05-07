package com.iago.springapp.domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.pojo.Items;

/**
 *
 * @author Administrador
 */
public class ItemDao extends AbstractDao {
    public ItemDao() {
        super();
    }

    /**
     * Insert a new Items into the database.
     * @param item
     */
    public void create(Items item) throws DataAccessLayerException {
        super.saveOrUpdate(item);
    }


    /**
     * Delete a detached Items from the database.
     * @param item
     */
    public void delete(Items item) throws DataAccessLayerException {
        super.delete(item);
    }

    /**
     * Find an Items by its primary key.
     * @param id
     * @return
     */
    public Items find(Long id) throws DataAccessLayerException {
        return (Items) super.find(Items.class, id);
    }

    /**
     * Updates the state of a detached Items.
     *
     * @param item
     */
    public void update(Items item) throws DataAccessLayerException {
        super.saveOrUpdate(item);
    }

    /**
     * Finds all Itemss in the database.
     * @return
     */
    public List<Items> findAll() throws DataAccessLayerException{
        return super.findAll(Items.class);
    }
    
    public Items findByName(String name) throws DataAccessLayerException {
        Items result = new Items();
                
        try {
        	startOperation();
        	result = (Items) session.getNamedQuery("getItemByName").setString("name", name).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close();
        }
        return result;
    }

	public List<Items> findAllRestricted() {
		 List<Items> result = new ArrayList<Items>();
         
	        try {
	        	startOperation();
	            result = (List<Items>) session.getNamedQuery("findAllRestricted").list();
	            tx.commit();
	        } catch (HibernateException e) {
	            handleException(e);
	        } finally {
	            HibernateUtil.close();
	        }
	        
	        return result;
	}

}