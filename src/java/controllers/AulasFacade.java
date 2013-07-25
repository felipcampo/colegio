/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Aulas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Smart
 */
@Stateless
public class AulasFacade extends AbstractFacade<Aulas> {
    @PersistenceContext(unitName = "colegio_crudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AulasFacade() {
        super(Aulas.class);
    }
    
}
