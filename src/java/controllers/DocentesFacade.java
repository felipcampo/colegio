/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Docentes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Smart
 */
@Stateless
public class DocentesFacade extends AbstractFacade<Docentes> {
    @PersistenceContext(unitName = "colegio_crudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocentesFacade() {
        super(Docentes.class);
    }
    
}
