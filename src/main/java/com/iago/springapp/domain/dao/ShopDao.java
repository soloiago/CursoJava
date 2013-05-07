package com.iago.springapp.domain.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.pojo.Shops;

/**
 *
 * @author Administrador
 */
public class ShopDao extends AbstractDao {
    public ShopDao() {
        super();
    }

    /**
     * Insert a new Shops into the database.
     * @param shop
     */
    public void create(Shops shop) throws DataAccessLayerException {
        super.saveOrUpdate(shop);
    }


    /**
     * Delete a detached Shops from the database.
     * @param shop
     */
    public void delete(Shops shop) throws DataAccessLayerException {
        super.delete(shop);
    }

    /**
     * Find an Shops by its primary key.
     * @param id
     * @return
     */
    public Shops find(Long id) throws DataAccessLayerException {
        return (Shops) super.find(Shops.class, id);
    }

    /**
     * Updates the state of a detached Shops.
     *
     * @param shop
     */
    public void update(Shops shop) throws DataAccessLayerException {
        super.saveOrUpdate(shop);
    }

    /**
     * Finds all Shopss in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Shops.class);
    }
    
    public Shops findByName(String name) throws DataAccessLayerException {
        List<Shops> result = new ArrayList<Shops>();
                
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            result = session.createQuery("from Shops s where s.nombre=?").setString(0, name).list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close();
        }
        return result.get(0);
    }
    
    public List<Shops> findDistinctShops() {
    	List<Shops> shopList = new ArrayList<Shops>();

		try {
			startOperation();
			List<String> otraLista = session.createSQLQuery("select distinct s.nombre from Shops s").list();
			shopList = session.createSQLQuery("select distinct s.nombre from Shops s").list();
			
			
		} catch (HibernateException e) {
			handleException(e);
		}

		return shopList;
	}

}