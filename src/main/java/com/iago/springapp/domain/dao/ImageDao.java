package com.iago.springapp.domain.dao;

import java.util.List;

import com.iago.springapp.domain.pojo.Images;

/**
 *
 * @author Administrador
 */
public class ImageDao extends AbstractDao {
    public ImageDao() {
        super();
    }

    /**
     * Insert a new Images into the database.
     * @param image
     */
    public void create(Images image) throws DataAccessLayerException {
        super.saveOrUpdate(image);
    }


    /**
     * Delete a detached Images from the database.
     * @param image
     */
    public void delete(Images image) throws DataAccessLayerException {
        super.delete(image);
    }

    /**
     * Find an Images by its primary key.
     * @param id
     * @return
     */
    public Images find(Long id) throws DataAccessLayerException {
        return (Images) super.find(Images.class, id);
    }

    /**
     * Updates the state of a detached Images.
     *
     * @param image
     */
    public void update(Images image) throws DataAccessLayerException {
        super.saveOrUpdate(image);
    }

    /**
     * Finds all Imagess in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Images.class);
    }

}